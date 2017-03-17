package com.cgi.concurrent.example.client;

import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * Created by ychang on 8/5/2016.
 */
public class NetworkClientCallable implements Callable<RequestResponse> {
  private final RequestResponse lookup;

  public NetworkClientCallable(RequestResponse lookup) {
    this.lookup = lookup;
  }

  @Override
  public RequestResponse call() throws Exception {
    try (Socket socket = new Socket(lookup.host, lookup.port);
         Scanner scanner = new Scanner(socket.getInputStream())) {
      lookup.response = scanner.next();
      return lookup;
    }

  }
}
