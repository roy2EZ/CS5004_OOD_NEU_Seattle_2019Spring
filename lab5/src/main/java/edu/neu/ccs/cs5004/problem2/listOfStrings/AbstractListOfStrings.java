package edu.neu.ccs.cs5004.problem2.listOfStrings;

public abstract class AbstractListOfStrings<String> implements IListOfStrings<String> {
  protected int size = 0;

  public AbstractListOfStrings() {

  }

  protected AbstractListOfStrings(String[] objects){
    for(int i=1;i<objects.length;i++)
      add(objects[i]);
  }

  @Override
  public void add(String element) {
    add(size,element);
  }

  @Override
  public void add(int index, String element) {

  }

  @Override
  public void clear() {

  }

  @Override
  public Boolean remove(String element) {
    if(indexOf(element) >= 0) {
      remove(indexOf(element));
      return true;
    }
    else return false;
  }

  @Override
  public String remove(int index) {
    return null;
  }

  @Override
  public ListOfStrings set(int index, String element) {
    return null;
  }

  @Override
  public String elementAt(int index) {
    return null;
  }

  @Override
  public int indexOf(String element) {
    return 0;
  }

  @Override
  public int lastIndexOf(String element) {
    return 0;
  }

  @Override
  public Boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

}
