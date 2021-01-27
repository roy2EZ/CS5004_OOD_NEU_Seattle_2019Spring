package edu.neu.ccs.cs5004.problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Represent a CsvReader class to read the csv data file.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class CsvReader implements IcsvReader {

  public CsvReader() {

  }

  /**
   * To read the csv data file.
   * @param input the file name of csv file.
   * @param map a map to restore first line of the csv file as an title line.
   * @param allInformation a array of strings which contains all data from the csv file.
   */
  @Override
  public void readCsvInformation(String input, Map<Integer, String> map, String[] allInformation) {
    BufferedReader inputFile = null;
    int index = 0;
    try {
      inputFile = new BufferedReader(new FileReader(input));
      String line;
      line = inputFile.readLine();
      line = line.substring(1, line.length() - 1);
      String[] categories = line.split("\",\"");

      for (int i = 0; i < categories.length; i++) {
        map.put(i, "[[" + categories[i] + "]]");
      }
      while ((line = inputFile.readLine()) != null) {
        allInformation[index] = line;
        index++;
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
    } finally {
      if (inputFile != null) {
        try {
          inputFile.close();
        } catch (IOException e) {
          System.out.println("Failed to close input stream");
        }
      }
    }
  }
}
