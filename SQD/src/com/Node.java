package com;

public class Node {
    public long data;
    public Node next;

    public Node(long data, Node next) {
        this.data = data;
        this.next = next;
    }


    @Override
    public String toString() {
        return "Node { data = " + data + ", next = " + next + '}';
    }
}
