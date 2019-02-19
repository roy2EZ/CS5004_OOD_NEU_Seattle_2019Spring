package edu.neu.ccs.cs5004.problem2.listOfStrings;

public class Empty implements ListOfStrings {

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    else return true;
  }

  @Override
  public String toString() {
    return "Empty{}";
  }

  /**
   * @return Returns true if empty and false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * @return the total number of elements in the list of ListOfStrings
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * consumes a String, and checks if the String is in the list or not. checks if the String is in
   * the list or not.
   *
   * @param string checks if the String is in the list or not.
   * @return returns true if the String is in the list, and false otherwise.
   */
  @Override
  public Boolean contains(String string) {
    return null;
  }

  /**
   * consumes another list of Strings, and checks that all elements of this list are in the list
   * passed as argument.
   *
   * @param list a list of strings which need to be checked
   * @return returns true if all elements of this list are in the list passed as argument and false
   * otherwise
   */
  @Override
  public Boolean containsAll(ListOfStrings list) {
    return null;
  }

  /**
   * takes the maximum String length, and returns a list with all list elements whose length is
   * greater than the maximum length removed.
   *
   * @param maxStringLen the max string length as filter
   * @return a list with all elements whose length is greater than the maximum length.
   */
  @Override
  public ListOfStrings filterLagerThan(Integer maxStringLen) {
    return null;
  }

  /**
   * check if the list has at least one duplicate element.
   *
   * @return true if the list has at least one duplicate element and false otherwise.
   */
  @Override
  public Boolean hasDuplicates() {
    return null;
  }

  /**
   * returns the list with all duplicates removed.
   *
   * @return returns the list with all duplicates removed.
   */
  @Override
  public ListOfStrings removeDuplicates() {
    return null;
  }
}
