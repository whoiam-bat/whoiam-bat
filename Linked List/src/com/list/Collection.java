package com.list;

public interface Collection {

    /**
     * Clear the whole list by tracing from head to tail and using the temp Node which refers to the next Node
     * after trav Node
     */
    void clear();

    int size();

    /**
     * Checking whether list has 0 size
     * @return boolean
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Adds element to the tail of list
     * @param elem element which will be assigned to the Node's data field
     * @see DoublyList#addLast(double)
     */
    void add(double elem);

    /**
     * Adds element to the head of list
     * @param element element which will be assigned to the Node's data field
     */
    void addFirst(double element);

    void addLast(double element);

    /**
     * @param index of searched value
     * @return double value of node
     */
    double peekAt(int index);

    /**
     * Remove first node in the list
     * @return double value of removed node
     * @throws RuntimeException() if list is empty
     */
    public double removeFirst();

    /**
     * Remove last node in the list
     * @return double value of removed node
     * @throws RuntimeException() if list is empty
     */
    public double removeLast();

    /**
     * Removes element from index and returns its double value
     * @param index of removing element
     * @return double value of node
     * @throws IndexOutOfBoundsException() if index is out of bounds of list
     * @see com.list.DoublyList#remove(com.list.Node index)
     */
    public double removeAt(int index);

    /**
     * Defines location of node and delete it
     *
     * @param node node of list
     * @return double value of deleted node
     * @see DoublyList#removeAt(int)
     */
    public double remove(Node node);

    /**
     * Method swaps two nodes that are located side by side
     *
     * @param index1 index first node
     * @param index2 index second node
     *                  index1 must be less than index2
     * If first index equals to 0
     * @see com.list.DoublyList#replaceWithHead(int)
     * <p>
     * If second index equals to list length - 1
     * @see com.list.DoublyList#replaceWithTail(int)
     * <p>
     * Else
     * @see com.list.DoublyList#replace(int, int)
     */
    public void swap(int index1, int index2);

    void replaceWithHead(int index2);

    void replaceWithTail(int index1);

    void replace(int index1, int index2);

    /**
     * Method searches index of node which has a double field
     *
     * @param searchedValue searched value
     * @return index of searched value. Is there is no nodes with such field returns -1
     */
    int indexOf(double searchedValue);

    /**
     * Checks is list contain node with searched double value
     *
     * @param searchedValue searched value
     * @return bolean true if list has a node otherwise false
     */
    boolean contains(double searchedValue);
}
