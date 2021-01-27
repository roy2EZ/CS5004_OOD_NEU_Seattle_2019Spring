package edu.neu.ccs.cs5004.problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Represents a ReadAndWriter class.
 * To read the template file, and write outputs with that template and related data from csv file.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class ReadAndWriter implements IReadAndWriter {

  public ReadAndWriter() {
  }

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
  @Override
  public void readAndWriteTemplate(String templateName, int indexOfData, String[] allInformation,
      String category, Map<Integer, String> map, String outPath) {
    BufferedReader template = null;
    BufferedWriter outputFile = null;
    try {
      template = new BufferedReader(new FileReader(templateName));
      outputFile = new BufferedWriter(new FileWriter(outPath + indexOfData + category + ".txt"));
      String lineTemplate;
      while ((lineTemplate = template.readLine()) != null) {
        String temp = lineTemplate;
        String[] stringB = allInformation[indexOfData].substring(1,
            allInformation[indexOfData].length() - 1).split("\",\"");
        while (temp.indexOf("[[") != -1) {
          int start = temp.indexOf("[[");
          int end = temp.indexOf("]]");
          String stringA = temp.substring(start, end + 2);
          for (int x: map.keySet()) {
            if (map.get(x).equals(stringA)) {
              temp = temp.replace(stringA, stringB[x]);
            }
          }
        }
        outputFile.write(temp);
        outputFile.newLine();
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    } finally {
      if (template != null) {
        try {
          template.close();
        } catch (IOException e) {
          System.out.println("errString");
          e.printStackTrace();
        }
      }
      if (outputFile != null) {
        try {
          outputFile.close();
        } catch (IOException e) {
          System.out.println("errString");
          e.printStackTrace();
        }
      }
    }
  }
}
