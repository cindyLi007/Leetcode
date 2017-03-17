package com.cgi.stream;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 7/15/2016.
 */
public class SalesTxn {
  private State state;
  private String product;
  private double transactionTotal;
  private String txnId;
  private String buyerName;

  public SalesTxn(State state, String product, double transactionTotal, String txnId, String buyerName) {
    this.state = state;
    this.product = product;
    this.transactionTotal = transactionTotal;
    this.txnId = txnId;
    this.buyerName = buyerName;
  }

  public static List<SalesTxn> createTxnList() {
    List<SalesTxn> list = new LinkedList<>();
    list.add(new SalesTxn(State.CA, "Widget", 132_293.34, "Id_wz", "Grace CA"));
    list.add(new SalesTxn(State.CA, "Widget", 32_293.34, "Id_xa", "Grace CA"));
    list.add(new SalesTxn(State.VA, "Widget Pro", 453_829.54, "Id_i", "Grace VA"));
    list.add(new SalesTxn(State.CA, "Widget Pro", 1_232_453.34, "Id_wa", "Yi Washington"));
    list.add(new SalesTxn(State.CA, "Widget Pro", 2_193_290.34, "Id_ya", "Grace Chang CA"));
    list.add(new SalesTxn(State.VA, "Widget", 8_429.54, "Id_a", "Grace VA"));
    list.add(new SalesTxn(State.VA, "Widget", 429.54, "Id_bd", "Grace VA"));
    list.add(new SalesTxn(State.CA, "Widget Pro", 332_451.34, "Id_ba", "Wei Zhang"));
    return list;
  }

  public State getState() {
    return state;
  }

  public String getProduct() {
    return product;
  }

  public double getTransactionTotal() {
    return transactionTotal;
  }

  public String getTxnId() {
    return txnId;
  }

  public String getBuyerName() {
    return buyerName;
  }
}
