package com.stack;
import com.Node;

import java.util.*;
import java.util.stream.Collectors;

public class StackDemo {
    private final static int CAPACITY;
    private int size;

    private Node top;
    private Node bottom;

    static {
        System.out.print("Enter initial capacity for stack: ");
        CAPACITY = new Scanner(System.in).nextInt();
    }

    public StackDemo() {
        this.size = 0;
        this.bottom = null;
        this.top = null;
    }

    public boolean push(long val) {
        if(isFull()) return false;

        if(isEmpty()) {
            bottom = top = new Node(val, null);
            size++;
            return true;
        }

        top = new Node(val, top);
        size++;
        return true;
    }

    public long pop() {
        if(isEmpty()) throw new NoSuchElementException("Stack is empty");

        long res = top.data;

        top = top.next;
        size--;
        return res;
    }

    public void swapFirsLast() {
        if(isEmpty()) throw new NoSuchElementException("Stack is empty");

        long temp = bottom.data;
        bottom.data = top.data;
        top.data = temp;
    }

    public void deleteOddIndexElements() {
        int i = 0;

        for (Node it = top; it != null; it = it.next) {
            if(i % 2 == 0) {
                it.next = it.next.next;
                size--;
            }
        }
    }

    public long max() {
        if(isEmpty()) throw new NoSuchElementException("Stack is empty");

        long max = Arrays.stream(map()).max().orElse(-1);

        for (Node it = top; it != null; it = it.next) {
            if(it.data == max) {
                it.next = new Node(0, it.next);
            }
        }
        size++;
        return max;
    }

    public long deleteMin() {
        if(isEmpty()) throw new NoSuchElementException("Stack is empty");
        long min = Arrays.stream(map()).min().orElse(-1);

        Node curr = top;
        Node prev = top;

        if(curr.data == min) {
            top = top.next;
            size--;
            return min;
        }

        while (curr != null) {
            if(curr.data == min) {
                prev.next = curr.next;
                size--;
            }
            prev = curr;
            curr = curr.next;
        }
        return min;
    }

    public void deleteExceptLast() {
        size -= (size - 1);
        top.next = null;
    }

    public void deleteExceptFirst() {
        size -= (size - 1);
        top = bottom;
    }

    public String insertSymbol() {
        StringBuilder sb = new StringBuilder("[");

        int edge = (size % 2 == 0) ? size / 2 : size / 2 + 1;
        Node it = top;
        for (int i = 0; i < edge; i++) {
            sb.append(it.data).append(", ");
            it = it.next;
        }
        sb.append("*, ");
        for (int i = edge + 1; i <= size; i++) {
            sb.append(it.data);
            if (i != size) {
                sb.append(", ");
            }
            it = it.next;
        }
        sb.append("]");
        return "StackDemo: " + sb;
    }

    public void reverseStack() {
        if(isEmpty()) throw new NoSuchElementException("Stack is empty");

        long[] temp = map();

        Node it = top;
        for (int i = temp.length - 1; it != null; i--, it = it.next) {
            it.data = temp[i];
        }
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
        Node iter = top;
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
        return "StackDemo: " + sb;
    }

}
