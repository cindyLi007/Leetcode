package com.cgi.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by ychang on 7/15/2016.
 */
public class LazyTest {
  public static void main(String[] arges) {
    List<SalesTxn> tList = SalesTxn.createTxnList();
    Consumer<SalesTxn> quartReport = t -> System.out.printf("Seller: " + t.getBuyerName()
        + " Buyer: " + t.getBuyerName() + " -- Quantity: %,9.0f%n", t.getTransactionTotal());

    System.out.println("*** Widget Pro Sales Tax in CA ***");

    Predicate<SalesTxn> salesTxnPredicate = t -> t.getState().equals(State.CA);
    tList.stream().peek(t -> System.out.println("From beginning: " + t.getBuyerName()))
        .filter(salesTxnPredicate)
        .peek(t -> System.out.println("after filter state: " + t.getBuyerName()))
        .filter(t -> t.getProduct().equals("Widget Pro"))
        .peek(quartReport) // peek will NOT execute in the middle, only when forEach execute, add it
        .filter(t -> t.getBuyerName().contains("hang"))
        .map(t -> t.getTransactionTotal() * TaxRate.byState(t.getState()))
        .forEach(amt -> System.out.printf("Tax tax: $%,9.2f%n", amt));

    System.out.println("*** Widget Pro Sales Tax in CA (First Find)***");

    Optional<SalesTxn> first = tList.stream().peek(t -> System.out.println("From beginning: " + t.getBuyerName()))
        .filter(salesTxnPredicate)
        .peek(t -> System.out.println("after filter state: " + t.getBuyerName()))
        .filter(t -> t.getProduct().equals("Widget Pro"))
        .peek(quartReport) // peek will NOT execute in the middle, only when forEach execute, add it
        .filter(t -> t.getBuyerName().contains("hang"))
        .findFirst();

    if (first.isPresent()) {
      quartReport.accept(first.get());
    }

    Optional<SalesTxn> tLarge = tList.stream().filter(t -> t.getBuyerName().contains("Grace"))
        // A new static method in Comparator, pass a function returning a field of object
        .max(Comparator.comparing(SalesTxn::getTransactionTotal));

    if (tLarge.isPresent()) {
      // Consumer accept the generic object
      quartReport.accept(tLarge.get());
    }
  }

}
