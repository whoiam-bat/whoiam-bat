package com.deque;
import com.Node;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DequeDemo {
    private final static int CAPACITY;
    private int size;
    private Node head;
    private Node tail;


    static {
        System.out.print("Enter initial capacity for queue: ");
        CAPACITY = new Scanner(System.in).nextInt();
    }

    public DequeDemo() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean offerFirst(long var) {
        if(isFull()) return false;

        if(isEmpty()) {
            head = tail = new Node(var, null);
            size++;
            return true;
        }

        head = new Node(var, head);
        size++;
        return true;
    }

    public boolean offerLast(long var) {
        if(isFull()) return false;

        if(isEmpty()) {
            head = tail = new Node(var, null);
            size++;
            return true;
        }

        tail.next = new Node(var, null);
        tail = tail.next;
        size++;
        return true;
    }

    public boolean removeFirst() {
        if(isEmpty()) return false;

        head = head.next;

        size--;
        if(head == null) {
            tail = null;
            return isEmpty();
        }
        return true;
    }

    public boolean removeLast() {
        if(isEmpty()) return false;

        Node temp = head;
        for (int i = 0; temp != null; i++) {
            if (temp.next == tail) {
                temp.next = null;
                tail = temp;
                break;
            }
            if (head == tail) {
                head = null;
                break;
            }
            temp = temp.next;
        }

        size--;
        return true;
    }

    public long peekAt(int index) {
        if(isEmpty()) throw new IllegalArgumentException("Deque is empty");

        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        if(index == 0) {
            return getFirst();
        } else if(index == size) {
            return getLast();
        }
        Node temp = head;
        long result = 0L;
        for (int i = 0; temp != null; i++) {
            if(i == index) {
                result = temp.data;
                break;
            }
            temp = temp.next;
        }

        return result;
    }

    private long getFirst() {
        return head.data;
    }

    private long getLast() {
        return tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == CAPACITY;
    }

    public int getSize() {
        return size;
    }

    public long[] map() {
        Node iter = head;
        long[] temp = new long[getSize()];
        for (int i = 0; iter != null; i++) {
            temp[i] = iter.data;
            iter = iter.next;
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(Arrays.stream(map())
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]")));
        return "DequeDemo: " + sb;
    }
}
