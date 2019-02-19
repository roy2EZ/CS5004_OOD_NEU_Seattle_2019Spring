package edu.neu.ccs.cs5004.problem2.listOfStrings;

public class ListOfStrings<String> extends AbstractListOfStrings<String> {
  private Node<String> head, tail;

  public ListOfStrings() {

  }

  public ListOfStrings(String[] objects) {
    super(objects);
  }

  public String getFirst() {
    if(size == 0) {
      return null;
    } else {
      return head.element;
    }
  }

  public String getLast() {
    if (size == 0) {
      return null;
    } else {
      return tail.element;
    }
  }

  public void addFirst(String element){
    Node<String> newNode = new Node<String>(element);
    newNode.next=head;
    head=newNode;
    size++;
    if (tail == null) {
      tail = head;
    }
  }

  public void addLast(String element){
    Node<String> newNode=new Node<String>(element);
    if (tail == null) {
      head = tail = newNode;
    }
    else{
      tail.next = newNode;
      tail = tail.next;
    }
    size++;
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
  public Boolean containsAll(IListOfStrings list) {
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
  public IListOfStrings filterLagerThan(Integer maxStringLen) {
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
  public IListOfStrings removeDuplicates() {
    return null;
  }
}
