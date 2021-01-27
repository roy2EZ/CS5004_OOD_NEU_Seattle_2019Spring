package edu.neu.ccs.cs5004.problem1;

import java.util.Map;

/**
 * Represents an interface of read and write class.
 * To read the template file, and write outputs with that template and related data from csv file.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public interface IReadAndWriter {

  /**
   * To read the template file, and write outputs with that template and related data from csv file.
   *
   * @param templateName the file name of the template
   * @param indexOfData the number of which data line in csv file
   * @param allInformation an array of strings to restore data from csv file
   * @param category the category of the template (email or letter)
   * @param map a map to restore first line in csv file as a title line
   * @param outPath the path of output files
   */
  void readAndWriteTemplate(String templateName, int indexOfData, String[] allInformation,
      String category, Map<Integer, String> map, String outPath);
}
