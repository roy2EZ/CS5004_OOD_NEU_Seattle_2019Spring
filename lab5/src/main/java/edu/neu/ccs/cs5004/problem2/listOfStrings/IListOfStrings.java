package edu.neu.ccs.cs5004.problem2.listOfStrings;


/**
 * Represents a List of Integers
 * @author Rongyi Chen
 * @version 1.0
 */
public interface IListOfStrings<String> {

  /**
   * Given a new element {@code element} prepend it to this list
   * @param element new element to add to the list
   * @return updated list with {@code element} prepended
   */
  void add(String  element);

  /**
   * add the string element at the index location.
   * @param index the index where the element need to be added
   * @param element the string element which need to be added
   */
  void add(int index,String element);

  /**
   * clear the whole list to an empty list.
   */
  void clear();

  /**
   * Remove a string from the list and returns true;
   * If no such element exists, return false.
   * @param element
   * @return
   */
  Boolean remove(String element);

  /**
   * remove the element at index place and return the removed element.
   * @param index the index where the element at.
   * @return the removed element
   */
  String remove(int index);

  /**
   * set the element at index location.
   * @param index
   * @param element
   * @return
   */
  IListOfStrings set(int index,String element);

  /**
   * consumes a String, and checks if the String is in the list or not.
   * @param element the string need to be check
   * @return true if string in the list and false otherwise
   */
  Boolean contains(String element);


  /**
   * get the string at index
   * @param index of the string
   * @return the string at the index
   */
  String elementAt(int index);

  /**
   * get the index of a string element
   * @param element a string element
   * @return the index of a string element
   */
  int indexOf(String element);

  /**
   * return the last index of the string in list which is the same string with element
   * @param element the to be checked string
   * @return the last same string's index
   */
  int lastIndexOf(String element);

  /**
   * Returns true if empty and false otherwise
   */
  Boolean isEmpty();

  /**
   * @return number of how many elements in the list
   */
  int size();

  /**
   * consumes another list of Strings, and checks that all elements of
   * this list are in the list passed as argument.
   * @param list a list of strings which need to be checked
   * @return returns true if all elements of this list are in the list passed as argument
   * and false otherwise
   */
  Boolean containsAll(IListOfStrings list);

  /**
   * takes the maximum String length, and returns a list with all
   * list elements whose length is greater than the maximum length removed.
   * @param maxStringLen the max string length as filter
   * @return a list with all elements whose length is greater than the maximum length.
   */
  IListOfStrings filterLagerThan(Integer maxStringLen);

  /**
   * check if the list has at least one duplicate element.
   * @return true if the list has at least one duplicate element and false otherwise.
   */
  Boolean hasDuplicates();

  /**
   * returns the list with all duplicates removed.
   * @return returns the list with all duplicates removed.
   */
  IListOfStrings removeDuplicates();

}
