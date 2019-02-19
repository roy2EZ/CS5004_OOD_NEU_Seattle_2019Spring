package edu.neu.ccs.cs5004.problem2.listOfStrings;

import edu.neu.ccs.cs5004.problem1.listOfIntegers.List;

/**
 * Represents a List of Integers
 * @author Rongyi Chen
 * @version 1.0
 */
public interface ListOfStrings {

  /**
   * @return Returns true if empty and false otherwise
   */
  Boolean isEmpty();

  /**
   * @return the total number of elements in the list of ListOfStrings
   */
  Integer size();

  /**
   * consumes a String, and checks if the String is in the list or not.
   * checks if the String is in the list or not.
   * @param string checks if the String is in the list or not.
   * @return returns true if the String is in the list, and false otherwise.
   */
  Boolean contains(String string);

  /**
   * consumes another list of Strings, and checks that all elements of
   * this list are in the list passed as argument.
   * @param list a list of strings which need to be checked
   * @return returns true if all elements of this list are in the list passed as argument
   * and false otherwise
   */
  Boolean containsAll(ListOfStrings list);

  /**
   * takes the maximum String length, and returns a list with all
   * list elements whose length is greater than the maximum length removed.
   * @param maxStringLen the max string length as filter
   * @return a list with all elements whose length is greater than the maximum length.
   */
  ListOfStrings filterLagerThan(Integer maxStringLen);

  /**
   * check if the list has at least one duplicate element.
   * @return true if the list has at least one duplicate element and false otherwise.
   */
  Boolean hasDuplicates();

  /**
   * returns the list with all duplicates removed.
   * @return returns the list with all duplicates removed.
   */
  ListOfStrings removeDuplicates();

}
