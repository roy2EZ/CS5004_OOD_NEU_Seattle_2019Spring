package edu.neu.ccs.cs5004.problem1;

/**
 * Represents ArgumentType class for returning related arguments.
 * That is in classifyCategory() function of CategoryClassifier class
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class ArgumentType {
  protected String category;
  protected String templateName;
  protected String outPath;

  /**
   * Constructs the ArgumentType class.
   * @param category category of the templates (email or letter)
   * @param templateName template file name
   * @param outPath the path of output files
   */
  public ArgumentType(String category, String templateName, String outPath) {
    this.category = category;
    this.templateName = templateName;
    this.outPath = outPath;
  }
}
