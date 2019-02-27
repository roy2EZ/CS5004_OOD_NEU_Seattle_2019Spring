package edu.neu.ccs.cs5004.problem2;

import java.util.Objects;


public class BagOfWords extends AbstractBagOfWords {
  private Node head, tail;

  /**
   * Constructs an empty bag
   */
  public BagOfWords() {
  }

  /**
   * Constructs a bag with a string array
   * that add each string elements in the array into the bag.
   */
  public BagOfWords(String[] strings) {
    super(strings);
  }

  // ---------- Homework required methods ----------

  /**
   * Creates an empty BagOfWords.
   *
   * @return an empty BagOfWords
   */
  @Override
  public BagOfWords emptyBagOfWords() {
    return new BagOfWords();
  }

  /**
   * Calling isEmpty() on an empty BagOfWords returns true. Calling isEmpty() on a non-empty
   * BagOfWords tedBag returns false.
   *
   * @return true if BagOfWords is empty, false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return this.size() == 0;
  }

  /**
   * return number of how many elements in the bag.
   *
   * @return number of how many elements in the bag
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * Given a new string and add it to this bag of words.
   *
   * @param string new string to add to the bag of words
   * @return updated BagOfWords with string prepended
   */
  @Override
  public BagOfWords add(String string) {
    this.add(0,string);
    return this;
  }

  /**
   * consumes a String, and checks if the String is in the list or not.
   * @param element the string need to be check
   * @return true if string in the list and false otherwise
   */
  @Override
  public Boolean contains(String element) {
    Node current = head;
    for(int i = 0; i < size; i++){
      if(current.element.equals(element)){
        return true;
      } else {
        current = current.next;
      }
    }
    return false;
  }

  // ---------- other functions I design and implement from AbstractBagOfWords ----------

  public String get(int index) {
    if (index < 0 || index >= size) return null;
    else if (index == 0) return head.element;
    else if (index == size - 1) return tail.element;
    else{
      Node current = this.head;
      for(int i = 1; i < index; i++) {
        current = current.next;
      }
      Node temp = current.next;
      return temp.element;
    }
  }

  public void add(int index,String string){
    if(index==0) addFirst(string);
    else if(index>=size) addLast(string);
    else{
      Node current = head;
      for(int i=1;i<index;i++)
        current = current.next;
      Node temp = current.next;
      current.next=new Node(string);
      (current.next).next=temp;
      size++;
    }
  }

  public String remove(int index){
    if(index<0||index>=size) return null;
    else if(index==0) return removeFirst();
    else if(index==size-1) return removeLast();
    else{
      Node previous;
      previous = this.head;
      for (int i = 1;i < index;i++) {
        previous = previous.next;
      }
      Node current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }

  public String getFirst() {
    if (size == 0) {
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
    Node newNode = new Node(element);
    newNode.next=head;
    head=newNode;
    size++;
    if (tail == null) {
      tail = head;
    }
  }

  public void addLast(String element){
    Node newNode = new Node(element);
    if (tail == null) {
      head = tail = newNode;
    }
    else{
      tail.next = newNode;
      tail = tail.next;
    }
    size++;
  }

  public String removeFirst(){
    if (size == 0) return null;
    else if (size == 1) {
      Node temp = head;
      head = tail = null;
      size = 0;
      return temp.element;
    }
    else{
      Node temp = head;
      head = head.next;
      size--;
      return temp.element;
    }
  }

  public String removeLast(){
    if (size == 0)return null;
    else if(size == 1){
      Node temp = head;
      head=tail=null;
      size=0;
      return temp.element;
    }
    else{
      Node current=head;
      for(int i=0;i<size-2;i++){
        current=current.next;
      }
      Node temp=tail;
      tail=current;
      tail.next=null;
      size--;
      return temp.element;
    }
  }








}
