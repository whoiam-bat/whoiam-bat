package com.list;

import java.util.Arrays;
import java.util.NoSuchElementException;


/**
 *Super class which implements a cycle doubly linked list
 * Implements:
 * @see com.list.Collection
 * @author Oleksii_Drabchak
 */
public class CycleList implements Collection{
    private int size = 0;
    private Node head;
    private Node tail;

    @Override
    public void clear() {
        Node trav = head;
        while (trav != null) {
            Node next = trav.next;
            trav.prev = trav.next = null;
            trav.variable = 0;
            trav = next;
        }
        trav = head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(double element) {
        addLast(element);
    }

    @Override
    public void addFirst(double element) {
        if (!isEmpty()) {
            //Previous reference of head refers on the new node and new node refer to the head
            head.prev = new Node(element, head, null);
            //Making new node the head of list
            head = head.prev;
            head.prev = tail.next;
        } else {
            head = tail = new Node(element, null, null);
        }
        size++;
    }

    @Override
    public void addLast(double element) {
        if (!isEmpty()) {
            tail.next = new Node(element, null, tail);
            tail = tail.next;
            tail.next = head.prev;
        } else {
            head = tail = new Node(element, null, null);
        }
        size++;
    }

    @Override
    public double peekAt(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("No such element whit index: " + index);
        if (size() == 0) throw new RuntimeException("List is empty");

        if(index == 0) return head.variable;
        if(index == size() - 1) return tail.variable;

        Node temp = head;
        while (temp != null) {
            temp = temp.next;
        }
        return temp.variable;
    }

    @Override
    public double removeFirst() {
        if (size() == 0) throw new RuntimeException("List is empty");

        double result = head.variable;
        head = head.next;
        size--;

        //If list is empty after deleting the head than tail refers to null
        if (isEmpty()) tail = null;

        //If list ain't empty after deleting the head than delete old head
        else head.prev = tail.next;
        return result;
    }

    @Override
    public double removeLast() {
        if (size() == 0) throw new RuntimeException("List is empty");

        double result = tail.variable;
        tail = tail.prev;
        size--;

        //If list is empty after deleting the tail than head refers to null
        if (isEmpty()) head = null;

            //If list ain't empty after deleting the tail than delete old tail
        else tail.next = head.prev;

        return result;
    }

    @Override
    public double removeAt(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("No such element whit index: " + index);

        int i = 0;
        Node res;
        //Go to the Node with index (index) end assign it to the result Node
        if (index < size / 2) {
            for (i = 0, res = head; i != index; i++) {
                res = res.next;
            }
        } else {
            for (i = size - 1, res = tail; i != index; i--) {
                res = res.prev;
            }
        }
        //Pass current node to remove method
        return remove(res);
    }

    @Override
    public double remove(Node node) {
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        node.prev.next = node.next;
        node.next.prev = node.prev;

        double result = node.variable;

        node.next = node.prev = node = null;

        size--;
        return result;
    }

    @Override
    public void swap(int index1, int index2) {
        if (size() == 0) throw new RuntimeException("List is empty");
        if(index1 == 0 &     index2 == size() - 1) {
            replaceHeadTail();
        } else if (index1 == 0 & index2 != size() - 1) {
            replaceWithHead(index2);
        } else if (index1 != 0 & index2 == size - 1) {
            replaceWithTail(index1);
        } else {
            replace(index1, index2);
        }
    }

    @Override
    public void replaceWithHead(int index2) {
        Node temp = head.next;
        head.prev = head.next;
        head.next = head.next.next;
        temp.prev = null;
        temp.next.prev = head;
        temp.next = head;
        head = temp;
        head.prev = tail;
    }

    @Override
    public void replaceWithTail(int index1) {
       double temp = tail.variable;
       tail.variable = tail.prev.variable;
       tail.prev.variable = temp;
    }
    
    public void replaceHeadTail() {
        double temp = head.variable;
        head.variable = tail.variable;
        tail.variable = temp;
    }

    @Override
    public void replace(int index1, int index2) {
        if (index1 < 0 || index1 >= index2 || index2 > size - 1) throw new IllegalArgumentException("Incorrect input");
        Node left = new Node(head.variable, head, null);
        Node right = new Node(head.variable, head, null);

        for (int i = 0; i <= index1; i++) {
            left = left.next;
        }
        for (int i = 0; i <= index2; i++) {
            right = right.next;
        }

        right.prev = left.prev;
        left.prev.next = left.next;
        left.prev = right;
        left.next = right.next;
        right.next.prev = left;
        right.next = left;
    }

    @Override
    public int indexOf(double searchedValue) {
        if (size() == 0) throw new RuntimeException("List is empty");
        int i;
        Node trav;
        for (i = 0, trav = head; trav != null; trav = trav.next, i++) {
            if (trav.variable == searchedValue) return i;
        }
        return -1;
    }

    @Override
    public boolean contains(double searchedValue) {
        return indexOf(searchedValue) != -1;
    }

    /** Concat two list and writes result in third list
     * @param curr first list
     * @param other second list
     * @return new List which created by union two lists
     * @throws NoSuchElementException() if one of list or both of lists are empty
     */
    public CycleList concat(CycleList curr, CycleList other) {
        if (curr.isEmpty() || other.isEmpty()) throw new NoSuchElementException("One of list is empty");
        CycleList result = new CycleList();

        //Rewrite first list
        Node tempThis = curr.head;
        while (tempThis != null) {
            result.add(tempThis.variable);
            tempThis = tempThis.next;
        }
        //Rewrite second list
        tempThis = other.head;
        while (tempThis != null) {
            result.add(tempThis.variable);
            tempThis = tempThis.next;
        }

        //Assign the previous field of head reference at tail
        //Assign the next field of tail reference at tail
        result.head.prev = tail;
        result.tail.next = head;
        return result;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node trav = head;

        while (trav != null) {
            stringBuilder.append(trav.variable + " ");
            trav = trav.next;
        }
        return Arrays.toString(stringBuilder.toString().strip().split(" "));
    }
}
