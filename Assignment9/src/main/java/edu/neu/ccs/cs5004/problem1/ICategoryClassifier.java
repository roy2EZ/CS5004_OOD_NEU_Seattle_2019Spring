package edu.neu.ccs.cs5004.problem1;

import java.util.List;

/**
 * Represent a interface of CategoryClassifier class.
 * To check what category of the arguments is (for creating email or letter).
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public interface ICategoryClassifier {

  /**
   * To classify what category ( letter or email) output it required from commend arguments.
   * @param args arguments in the command
   * @param list a list to restore each keyword in the command arguments
   * @return a ArgumentType class with the needed arguments
   */
  ArgumentType classifyCategory(String[] args, List<String> list);

}
