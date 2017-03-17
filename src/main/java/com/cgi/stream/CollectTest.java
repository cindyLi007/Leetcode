package com.cgi.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ychang on 7/20/2016.
 */
public class CollectTest {

  public static void main(String[] args) {
    List<SalesTxn> txnList = SalesTxn.createTxnList(), rList;

    System.out.println("+++++ Transactions over $300k ++++++");
    rList = txnList.stream().filter(t -> t.getTransactionTotal() > 300_000)
        .sorted(Comparator.comparing(SalesTxn::getTransactionTotal).reversed())
        .collect(Collectors.toList());

    rList.stream().forEach(t -> System.out.printf("Id: " + t.getTxnId()
        + " Seller: " + t.getBuyerName().substring(0, 6) + " Buyer: " +
        t.getBuyerName().substring(6) + "   Amt: $%,9.2f%n", t.getTransactionTotal()));


  }

}
