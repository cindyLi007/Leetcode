package com.cgi.concurrent.example.client;

/**
 * Created by ychang on 8/5/2016.
 */
public class RequestResponse {
  public String host;
  public int port;
  public String response;

  public RequestResponse(String host, int port) {
    this.host = host;
    this.port = port;
  }
}
