package com.queue;
import com.Node;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


public class QueueDemo {
    private final static int CAPACITY;
    private int size;
    private Node head;
    private Node tail;

    static {
        System.out.print("Enter initial capacity for queue: ");
        CAPACITY = new Scanner(System.in).nextInt();
    }

    public QueueDemo() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean enqueue(long var) {
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

    public boolean dequeue() {
        if(isEmpty()) return false;

        head = head.next;
        if(head == null) {
            tail = null;
            return isEmpty();
        }

        size--;
        return true;
    }

    public double average() {
        return Arrays.stream(mapQ()).average().orElseThrow(IllegalArgumentException::new);
    }

    private long min() {
        return Arrays.stream(mapQ()).min().orElseThrow(IllegalArgumentException::new);
    }

    private long max() {
        return Arrays.stream(mapQ()).max().orElseThrow(IllegalArgumentException::new);
    }

    public String getMinMax() {
        return String.format("Min { " + min() + " }%nMax { " + max() + " }");
    }

    public Long getLeftNeighbourToMin() {
        Node iter = head;

        Optional<Long> tempValue = Optional.empty();

        while (iter != null) {
            if(iter.data == min()) break;
            tempValue = Optional.of(iter.data);
            iter = iter.next;
        }
        return tempValue.orElse(-1L);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == CAPACITY;
    }

    public long[] mapQ() {
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
        StringBuilder sb = new StringBuilder(Arrays.stream(mapQ())
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]")));
        return "QueueDemo: " + sb;
    }

}
