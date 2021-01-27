package edu.neu.ccs.cs5004.problem1;

import java.util.List;

/**
 * Represent a class to check what category of the arguments is for creating email or letter.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class CategoryClassifier implements ICategoryClassifier{

  public CategoryClassifier() {

  }

  /**
   * To classify what category ( letter or email) output it required from commend arguments.
   * @param args arguments in the command
   * @param list a list to restore each keyword in the command arguments
   * @return a ArgumentType class with the needed arguments
   */
  @Override
  public ArgumentType classifyCategory(String[] args, List<String> list) {
    String outputDir = "";
    String templateType = "";
    String templateFileName = "";
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("--output-dir")) {
        outputDir = args[i + 1];
      }
    }
    if (list.contains("--email") && list.contains("--email-template")) {
      templateType = "--email";
      templateFileName = "email-template.txt";
    } else if (list.contains("--letter") && list.contains("--letter-template")) {
      templateType = "--letter";
      templateFileName = "letter-template.txt";
    } else {
      ErrorPrinter errorPrinter = new ErrorPrinter();
      errorPrinter.printError();
      System.exit(0);
    }
    return new ArgumentType(templateType, templateFileName, outputDir);
  }
}
