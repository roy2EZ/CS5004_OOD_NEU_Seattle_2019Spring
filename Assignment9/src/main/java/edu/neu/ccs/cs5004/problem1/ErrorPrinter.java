package edu.neu.ccs.cs5004.problem1;

/**
 * Represent an error printer class for printing related error message.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class ErrorPrinter implements IErrorPrinter {

  public ErrorPrinter() {
  }

  /**
   * To print related error message when needed.
   */
  @Override
  public void printError() {
    System.out.println("Error: template and category do not match\n"
        + "Usage:\n"
        + " --email only generate email messages\n"
        + " --email-template <file> accept a filename that holds the\n"
        + "email template.\n"
        + " Required if --email is used\n"
        + " --letter only generate letters\n"
        + " --letter-template <file> accept a filename that holds\n"
        + "the email template.\n"
        + " Required if --letter is used\n"
        + " --output-dir <path> accept the name of a folder, all\n"
        + "output is placed in this folder\n"
        + " --csv-file <path> accept the name of the csv file to\n"
        + "process"
        + "Examples:\n"
        + " --email --email-template email-template.txt --output-dir\n"
        + "emails --csv-file customer.csv\n"
        + " --letter --letter-template letter-template.txt "
        + "--outputdir letters --csv-file customer.csv");
  }
}
