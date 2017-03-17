package com.cgi.serializable;

import static java.lang.System.exit;
import static java.lang.System.out;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by ychang on 7/10/2016.
 */
public class SerializeTest {

  public static void main(String[] args) {
    Object cart = null;
    String cartFile = args[0];
    try (FileOutputStream fos = new FileOutputStream(cartFile);
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(cart);
    } catch (IOException e) {
      out.println("Exception serializing " + cartFile + ": " + e);
      exit(-1);
    }
    out.println("Successfully serialized shopping cart with ID: ");
  }

}
