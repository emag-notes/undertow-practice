package org.emamotor.undertow.practice;

import io.undertow.UndertowOptions;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.protocol.http.HttpOpenListener;
import io.undertow.util.Headers;
import org.xnio.BufferAllocator;
import org.xnio.ByteBufferSlicePool;
import org.xnio.ChannelListener;
import org.xnio.ChannelListeners;
import org.xnio.OptionMap;
import org.xnio.Options;
import org.xnio.Pool;
import org.xnio.StreamConnection;
import org.xnio.Xnio;
import org.xnio.XnioWorker;
import org.xnio.channels.AcceptingChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

/**
 * @author tanabe
 */
public class NoBuilderServer {

  private static final int IO_THREADS = 16;
  private static final int WORKER_THREADS = 128;
  private static final int BUFFER_SIZE = 512;
  private static final int BUFFER_PER_REGION = 512;
  private static final String HOST_NAME = "localhost";
  private static final int PORT = 8888;

  public static void main(String[] args) {
    Xnio xnio = Xnio.getInstance();

    try {
      XnioWorker worker = xnio.createWorker(OptionMap.builder()
        .set(Options.WORKER_IO_THREADS, IO_THREADS)
        .set(Options.WORKER_TASK_CORE_THREADS, WORKER_THREADS)
        .set(Options.WORKER_TASK_MAX_THREADS, WORKER_THREADS)
        .set(Options.TCP_NODELAY, true)
        .getMap());

      OptionMap socketOptions = OptionMap.builder()
        .set(Options.WORKER_IO_THREADS, IO_THREADS)
        .set(Options.TCP_NODELAY, true)
        .set(Options.REUSE_ADDRESSES, true)
        .getMap();

      Pool<ByteBuffer> buffers = new ByteBufferSlicePool(
        BufferAllocator.DIRECT_BYTE_BUFFER_ALLOCATOR,
        BUFFER_SIZE,
        BUFFER_SIZE * BUFFER_PER_REGION);

      HttpOpenListener openListener = new HttpOpenListener(
        buffers,
        OptionMap.builder()
          .set(UndertowOptions.BUFFER_PIPELINED_DATA, true)
          .addAll(OptionMap.builder().getMap()) // serverOptions
          .getMap(),
        BUFFER_SIZE);
      openListener.setRootHandler(new HttpHandler() {
        @Override
        public void handleRequest(HttpServerExchange exchange) throws Exception {
          exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
          exchange.getResponseSender().send("Hello World(No Builder)");
        }
      });

      ChannelListener<AcceptingChannel<StreamConnection>> acceptListener =
        ChannelListeners.openListenerAdapter(openListener);
      AcceptingChannel<? extends StreamConnection> server =
        worker.createStreamConnectionServer(
          new InetSocketAddress(HOST_NAME, PORT), acceptListener, socketOptions);
      server.resumeAccepts();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
