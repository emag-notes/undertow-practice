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

    HttpHandler root = new HelloWorldHandler();
    root = new PreHelloWorldHandler(root);

    Undertow server = Undertow.builder()
      .addHttpListener(8080, "localhost")
      .setHandler(root)
      .build();
    server.start();
    System.out.println("HelloWorldServer is running!");
  }

}
