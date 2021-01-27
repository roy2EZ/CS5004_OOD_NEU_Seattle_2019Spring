package edu.neu.ccs.cs5004.problem1;


import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class CSVReaderTest {
  String input;
  Map<Integer, String> map;
  String[] allInformation;


  @Before
  public void setUp() throws Exception {
    input= "invalid.csv";
    map = new HashMap<>();
    allInformation = new String[501];
  }

  @Test
  public void readCSVInformation() {
    CsvReader csv = new CsvReader();
    csv.readCsvInformation(input, map, allInformation);
  }
}