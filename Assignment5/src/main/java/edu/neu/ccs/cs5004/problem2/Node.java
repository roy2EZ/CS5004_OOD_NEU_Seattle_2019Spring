package edu.neu.ccs.cs5004.problem2;

/**
 * Represents a Node class as a linked list's node for the BagOfWords ADT.
 */
public class Node {
  // the data in this node which is a string.
  String element;

  // the next node of this node
  Node next;

  public Node(String str){
    element = str;
  }

}
