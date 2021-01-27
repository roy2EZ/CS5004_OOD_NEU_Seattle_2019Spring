package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ErrorPrinterTest {
  ErrorPrinter ep;

  @Before
  public void setUp() throws Exception {
     ep = new ErrorPrinter();
  }

  @Test
  public void printError() {
      ep.printError();
  }
}