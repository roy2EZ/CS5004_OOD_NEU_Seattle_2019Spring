package edu.neu.ccs.cs5004.problem1;

import java.util.Map;

/**
 * Represent a interface of CsvReader class to read the csv data file.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public interface IcsvReader {

  /**
   * To read the csv data file.
   * @param input the file name of csv file.
   * @param map a map to restore first line of the csv file as an title line.
   * @param allInformation a array of strings which contains all data from the csv file.
   */
  void readCsvInformation(String input, Map<Integer, String> map, String[] allInformation);

}
