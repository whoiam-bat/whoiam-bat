package com.list;

/**
 * Class which describes a node of a doubly linked list
 * @author Oleksii_Drabchak
 */
public class Node {
    public double variable;
    Node next;
    Node prev;

    public Node(double variable, Node next, Node prev) {
        this.variable = variable;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node{" + "variable=" + variable + ", next=" + next + ", prev=" + prev + '}';
    }
}