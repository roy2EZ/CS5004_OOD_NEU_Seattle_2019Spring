package edu.neu.ccs.cs5004.problem1.listOfIntegers;

/**
 * Represents the empty list of integers.
 */


public class Empty implements List {


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        else return true;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public String toString() {
        return "Empty{}";
    }


    @Override
    public Integer size() {      // <2>
        return 0;                
    }

    @Override
    public Boolean isEmpty() {
        return true;
    }

    @Override
    public List add(Integer element) {
        return new Cons(element, this);
    }

    @Override
    public Integer last() throws InvalidCallException {
        throw new InvalidCallException("Called last() on empty!");
    }

    @Override
    public Boolean contains(Integer element) {
        return false;
    }

    /**
     * returns the element found at index in the list. should deal with the situations where the value
     * of index provided is outside the bounds of list
     */
    @Override
    public Integer elementAt(Integer index) throws IndexOutOfBoundsException {
        throw new IndexOutOfBoundsException("Called elementAt() on empty!");
    }

    @Override
    public Integer getFirst() {
        return null;
    }

    @Override
    public List getRest() {
        return null;
    }
}
