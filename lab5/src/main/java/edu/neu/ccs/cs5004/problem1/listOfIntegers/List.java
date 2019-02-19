package edu.neu.ccs.cs5004.problem1.listOfIntegers;

/**
 * Represents a List of Integers
 */
public interface List {

    /**
     * Returns the total number of elements in the list.
     *
     * @return number of elements in this list
     */
    Integer size();                                // <1>


    /**
     * Returns true if empty and false otherwise
     *
     */
    Boolean isEmpty();

    /**
     * Given a new element {@code element} prepend it to this list
     *
     * @param element new element to add to the list
     * @return updated list with {@code element} prependeds
     */
    List add(Integer element);


    /**
     * Return the last element of this list.
     *
     * @return the last element of this list.
     */
    Integer last();

    /**
     * returns true if element is in the list and false otherwise.
     * @param element the element to be searched
     * @return true if element is in the list and false otherwise.
     */
    Boolean contains(Integer element);

    /**
     * returns the element found at index in the list.
     * should deal with the situations where the value
     * of index provided is outside the bounds of list
     * @param index
     * @return
     */
    Integer elementAt(Integer index) throws IndexOutOfBoundsException;


    Integer getFirst();

    List getRest();
}
