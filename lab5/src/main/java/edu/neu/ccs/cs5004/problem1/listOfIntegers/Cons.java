package edu.neu.ccs.cs5004.problem1.listOfIntegers;


import java.util.concurrent.atomic.AtomicReference;

/**
 * Represents a non-emty list of integers
 *
 */
public class Cons implements List {
    private Integer first;
    private List rest;

    /**
     * Given an integer and a list create a new list with the
     * same elements as {@code rest} and with {@code first} prepended.
     *
     * @param first new element to add to the beginning of the list
     * @param rest the list we are going to use to add our new element
     */
    public Cons(Integer first, List rest) {
        this.first = first;
        this.rest = rest;
    }

    /**
     * Getter for property 'first'.
     *
     * @return Value for property 'first'.
     */
    public Integer getFirst() {
        return first;
    }

    /**
     * Getter for property 'rest'.
     *
     * @return Value for property 'rest'.
     */
    public List getRest() {
        return rest;
    }

    @Override
    public Integer size() {
        return 1 + this.getRest().size();
    }

    @Override
    public Boolean isEmpty() {
        return false;
    }

    @Override
    public List add(Integer element) {
        return new Cons(element, this);
    }

    @Override
    public Integer last() {
        if (this.rest.isEmpty()) {
            return this.first;
        } else {
            return this.rest.last();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cons cons = (Cons) o;

        if (getFirst() != null ? !getFirst().equals(cons.getFirst()) : cons.getFirst() != null)
            return false;
        return getRest() != null ? getRest().equals(cons.getRest()) : cons.getRest() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirst() != null ? getFirst().hashCode() : 0;
        result = 31 * result + (getRest() != null ? getRest().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cons{"
            + "first=" + first
            + ", rest=" + rest
            + '}';
    }

    /**
     * returns true if element is in the list and false otherwise.
     *
     * @param element the element to be searched
     * @return true if element is in the list and false otherwise.
     */
    @Override
    public Boolean contains(Integer element) {
        if (element.equals(this.first)) {
            return true;
        } else if (this.rest.isEmpty()){
            return false;
        } else {
            return this.rest.contains(element);
        }
    }

    /**
     * returns the element found at index in the list. should deal with the situations where the value
     * of index provided is outside the bounds of list
     */
    @Override
    public Integer elementAt(Integer index) throws IndexOutOfBoundsException {
        AtomicReference<Cons> tempList = new AtomicReference<>(
            new Cons(this.getFirst(), this.getRest()));
        AtomicReference<Integer> temp = new AtomicReference<>(tempList.get().getFirst());
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException(String.format(("Index should between 0 and %d"), this.size() - 1));
        } else for (int i = 0; i <= index; i++) {
            if (!this.getRest().isEmpty()){
                 temp.set(tempList.get().getFirst());
                 tempList.set(new Cons(tempList.get().getRest().getFirst(),
                     tempList.get().getRest().getRest()));
            }
        }
        return temp.get();
    }
}
