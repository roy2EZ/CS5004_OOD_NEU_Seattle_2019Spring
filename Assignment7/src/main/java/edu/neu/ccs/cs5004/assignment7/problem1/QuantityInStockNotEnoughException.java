package edu.neu.ccs.cs5004.assignment7.problem1;

/**
 * Represents the exception when customer purchase amount is bigger than items' quantity in stock.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class QuantityInStockNotEnoughException extends Exception {
  public QuantityInStockNotEnoughException(String msg) {
    super(msg);
  }
}
