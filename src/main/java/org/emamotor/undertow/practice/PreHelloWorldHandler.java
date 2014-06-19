package org.emamotor.undertow.practice;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

/**
 * @author tanabe
 */
public class PreHelloWorldHandler implements HttpHandler {

  private final HttpHandler next;

  public PreHelloWorldHandler(final HttpHandler next) {
    this.next = next;
  }

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {
    exchange.getResponseHeaders().put(Headers.LOCATION, "http://google.com");
    next.handleRequest(exchange);
  }

}
