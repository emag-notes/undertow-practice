package org.emamotor.undertow.practice;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

/**
 * @author Yoshimasa Tanabe
 */
public class HelloWorldServer {

  public static void main(String[] args) {

    Undertow server = Undertow.builder()
      .addHttpListener(8080, "localhost")
      .setHandler(new HttpHandler() {
        @Override
        public void handleRequest(final HttpServerExchange exchange) throws Exception {

          exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
          exchange.getResponseSender().send("Hello World");

        }
      }).build();
    server.start();
    System.out.println("HelloWorldServer is running!");
  }

}
