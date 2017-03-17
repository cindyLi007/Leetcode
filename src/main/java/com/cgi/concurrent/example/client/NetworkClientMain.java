package com.cgi.concurrent.example.client;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by ychang on 8/5/2016.
 */
public class NetworkClientMain {

  public static void main(String[] args) {
    String host = "localhost";
    /*for (int port = 8080; port < 8089; port++) {
      RequestResponse lookup = new RequestResponse(host, port);
      try (Socket socket = new Socket(lookup.host, lookup.port);
           Scanner scanner = new Scanner(socket.getInputStream())) {
        lookup.response = scanner.next();
        System.out.println(lookup.host + ": " + lookup.port + " " + lookup.response);
      } catch (NoSuchElementException | IOException e) {
        System.out.println("Error talking to " + host + ": " + port);
      }
    }*/

    ExecutorService es = Executors.newCachedThreadPool();
    Map<RequestResponse, Future<RequestResponse>> callables = new HashMap<>();
    for (int port = 8080; port < 8089; port++) {
      RequestResponse lookup = new RequestResponse(host, port);
      NetworkClientCallable callable = new NetworkClientCallable(lookup);
      Future<RequestResponse> future = es.submit(callable);
      callables.put(lookup, future);
    }
    es.shutdown();
    System.out.println(Runtime.getRuntime().availableProcessors());
    try {
      es.awaitTermination(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      System.out.println("Stopped waiting early");
    }

    for (RequestResponse lookup : callables.keySet()) {
      Future<RequestResponse> future = callables.get(lookup);
      try {
        lookup = future.get();
        System.out.println(lookup.host + ":" + lookup.port + " " + lookup.response);
      } catch (ExecutionException | InterruptedException e) {
        System.out.println("Error talking to " + lookup.host + ": " + lookup.port);
      }
    }
  }
}
