package edu.neu.ccs.cs5004.problem2;

import java.util.Objects;


public class BagOfWords<String> extends AbstractBagOfWords<String> {
  private Node<String> head, tail;

  public BagOfWords() {
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

  public String get(int index) {
    if (index < 0 || index >= size) return null;
    else if (index == 0) return head.element;
    else if (index == size - 1) return tail.element;
    else{
      Node<String> current = this.head;
      for(int i = 1; i < index; i++) {
        current = current.next;
      }
      Node<String> temp = current.next;
      return temp.element;
    }
  }

  @Override
  public BagOfWords add(String string) {
    this.add(0,string);
    return this;
  }

  public void add(int index,String string){
    if(index==0) addFirst(string);
    else if(index>=size) addLast(string);
    else{
      Node<String> current = head;
      for(int i=1;i<index;i++)
        current=current.next;
      Node<String> temp=current.next;
      current.next=new Node<String>(string);
      (current.next).next=temp;
      size++;
    }
  }


  public String removeFirst(){
    if (size == 0) return null;
    else if (size == 1) {
      Node<String> temp = head;
      head = tail = null;
      size = 0;
      return temp.element;
    }
    else{
      Node<String> temp = head;
      head = head.next;
      size--;
      return temp.element;
    }
  }

  public String removeLast(){
    if (size == 0)return null;
    else if(size == 1){
      Node<String> temp = head;
      head=tail=null;
      size=0;
      return temp.element;
    }
    else{
      Node<String> current=head;
      for(int i=0;i<size-2;i++){
        current=current.next;
      }
      Node<String> temp=tail;
      tail=current;
      tail.next=null;
      size--;
      return temp.element;
    }
  }

  public String remove(int index){
    if(index<0||index>=size) return null;
    else if(index==0) return removeFirst();
    else if(index==size-1) return removeLast();
    else{
      Node<String> previous;
      previous = this.head;
      for (int i = 1;i < index;i++) {
        previous = previous.next;
      }
      Node<String> current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }


  /**
   * consumes a String, and checks if the String is in the list or not.
   * @param element the string need to be check
   * @return true if string in the list and false otherwise
   */
  @Override
  public Boolean contains(String element) {
    Node<String> current = head;
    for(int i = 0; i < size; i++){
      if(current.element.equals(element)){
        return true;
      } else {
        current = current.next;
      }
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BagOfWords)) {
      return false;
    }
    BagOfWords<?> that = (BagOfWords<?>) o;
    return head.equals(that.head)
        && tail.equals(that.tail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(head, tail);
  }

}
