package edu.neu.ccs.cs5004.problem1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The main class to do the whole process for generating the output reports (emails or letters).
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */

public class ReportGenerator {

  public static final Integer NUM_OF_USERS = 500;

  /**
   * Main function to do the whole process for generating the output reports (emails or letters).
   * @param args the arguments of command
   */
  public static void main(String[] args) {

    // input as the csv file which is with all data
    String input = "insurance_company_members.csv";
    // create an array of strings to save all data in the csv file later
    String[] allInformation = new String[NUM_OF_USERS + 1];

    // a map to restore first line in the csv file,
    // and use it later when replace keyword in templates
    Map<Integer, String> map = new HashMap<>();

    // a list to hold all keywords from the command arguments
    List<String> list = Arrays.asList(args);

    // To use a CategoryClassifier class to find what category of the template should be used.
    CategoryClassifier categoryClassifier = new CategoryClassifier();
    String category = categoryClassifier.classifyCategory(args, list).category;
    String templateName = categoryClassifier.classifyCategory(args, list).templateName;
    String outPath = categoryClassifier.classifyCategory(args, list).outPath;

    // To use a CsvReader class to read the csv data file to get all data
    CsvReader csv = new CsvReader();
    csv.readCsvInformation(input, map, allInformation);

    // To use a ReadAndWriter class to read the template file,
    // and write output files to specified output path.
    ReadAndWriter readAndWriter = new ReadAndWriter();
    for (int i = 0; i < NUM_OF_USERS; i++) {
      readAndWriter.readAndWriteTemplate(templateName, i, allInformation, category, map, outPath);
    }
  }
}
