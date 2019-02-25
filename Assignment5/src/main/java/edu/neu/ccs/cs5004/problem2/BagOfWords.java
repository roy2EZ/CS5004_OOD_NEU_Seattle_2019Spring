package edu.neu.ccs.cs5004.problem2;

import java.util.Objects;


public class BagOfWords<String> extends AbstractBagOfWords<String> {
  private Node<String> head, tail;

  public BagOfWords() {
  }

  public BagOfWords(String[] objects) {
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

  public String get(int index) {
    if (index < 0 || index >= size) return null;
    else if (index == 0) return head.element;
    else if (index == size - 1) return tail.element;
    else{
      Node<String> current = head;
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
      Node<String> current=head;
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
    if(size==0)return null;
    else if(size==1){
      Node<String> temp=head;
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
      Node<String> previous = head;
      for (int i = 1;i < index;i++){
        previous = previous.next;
      }
      Node<String> current = previous.next;
      previous.next=current.next;
      size--;
      return current.element;
    }
  }



  public java.lang.String toString(){
    StringBuilder result=new StringBuilder("[");
    Node<String> current=head;
    for(int i=0;i<size;i++){
      result.append(current.element);
      current=current.next;
      if(current!=null){
        result.append(",");
      }
      else{
        result.append("]");
      }
    }
    return result.toString();
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


  /**
   * check if the list has at least one duplicate element.
   *
   * @return true if the list has at least one duplicate element and false otherwise.
   */
  @Override
  public Boolean hasDuplicates() {
    BagOfWords tempList = new BagOfWords();
    Node<String> current = this.head;
    for (int i = 0; i < this.size(); i++) {
      tempList.add(current.element);
      current = current.next;
    }
    Node<String> temp = tempList.head;
    for (int i = 0; i < this.size(); i++) {
      tempList.removeFirst();
      if (tempList.contains(temp.element)) {
        return true;
      } else {
        temp = temp.next;
      }
    }
    return false;
  }

  /**
   * returns the list with all duplicates removed.
   *
   * @return returns the list with all duplicates removed.
   */
  @Override
  public BagOfWords removeDuplicates() {
    if (this.hasDuplicates()) {
      BagOfWords tempList = new BagOfWords();
      Node<String> current = this.head;
      while (!this.isEmpty()) {
        if (!tempList.contains(current.element)) {
          tempList.add(current.element);
        }
        this.remove(current.element);
        if (!this.isEmpty()) {
          current = current.next;
        }
      }
      // copy the no duplicates tempList back to this original list
      Node<String> temp = tempList.head;
      for (int i = 0; i < tempList.size(); i++) {
        this.add(temp.element);
        temp = temp.next;
      }

    }
    return this;
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
    return head.equals(that.head) &&
        tail.equals(that.tail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(head, tail);
  }
}
