package edu.neu.ccs.cs5004.problem1;

/**
 * Represents elements of a PQ
 * which contains two properties
 */
public class Element {
  Integer priority;
  String value;

  public Element(Integer priority, String value) {
    this.priority = priority;
    this.value = value;
  }
}
