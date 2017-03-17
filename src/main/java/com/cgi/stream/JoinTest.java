package com.cgi.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ychang on 7/20/2016.
 */
public class JoinTest {

  public static void main(String[] args) {
    List<SalesTxn> txnList = SalesTxn.createTxnList(), rList;

    System.out.println("+++++ Sored Buyer's List ++++++");
    String result = txnList.stream().map(t -> t.getBuyerName())
        .distinct().sorted().collect(Collectors.joining(", "));

    System.out.println("Buyer LIst: " + result);

  }

}
