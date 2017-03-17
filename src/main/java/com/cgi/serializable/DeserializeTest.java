package com.cgi.serializable;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by ychang on 7/10/2016.
 */
public class DeserializeTest {

  public static void main(String[] args) {
    Object cart = null;
    String cartFile = args[0];
    try (FileInputStream fis = new FileInputStream(cartFile);
         ObjectInputStream ois = new ObjectInputStream(fis)) {
      ois.readObject();
    } catch (ClassNotFoundException | IOException e) {
      err.println("Exception de-serializing " + cartFile + ": " + e);
      exit(-1);
    }
    out.println("Successfully serialized shopping cart with ID: ");
  }

}
