package edu.neu.ccs.cs5004.problem2;

public abstract class AbstractBagOfWords<String> implements IBagOfWords<String> {
  protected int size = 0;

  public AbstractBagOfWords() {

  }

  protected AbstractBagOfWords(String[] objects){
    for(int i=1;i<objects.length;i++) {
      add(objects[i]);
    }
  }

  @Override
  public BagOfWords emptyBagOfWords() {
    return new BagOfWords();
  }

  @Override
  public Boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }


  public void add(int index, String element) {

  }

  public Boolean remove(String element) {
    if(indexOf(element) >= 0) {
      remove(indexOf(element));
      return true;
    }
    else return false;
  }

  public String remove(int index) {
    return null;
  }

  public int indexOf(String element) {
    return 0;
  }

}
