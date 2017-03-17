package com.cgi.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Created by ychang on 7/10/2016.
 */
public class Stock implements Serializable {
  /* During serialization, a version number, serialVersionUID is used to associate teh serialized output with the class
     used in the serialization process.
     After deserialization, the serialVersionUID is checked to verify that the classes loaded are compatible with the
     object being de-serialized */
  private static final long serialVersionUID = 100L;
  private String symbol;
  private int shares;
  private double purchasedPrice;
  private transient double currPrice;

  /*
    this constructor is NOT called during deserialization
   */
  public Stock(String symbol, int shares, double purchasedPrice) {
    this.shares = shares;
    this.symbol = symbol;
    this.purchasedPrice = purchasedPrice;
    setStockPrice();
  }

  private void setStockPrice() {

  }

  /*
    this method is called post-deserialization
   */
  private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException{
    objectInputStream.defaultReadObject();
    // perform other initialization
    setStockPrice();
  }


}
