package binTree;

public class Node {
    private String surname;
    private int place;
    private double luggageWeight;

    private Node left;
    private Node right;

    public Node(String surname, int place, double luggageWeight) {
        this.surname = surname;
        this.place = place;
        this.luggageWeight = luggageWeight;
    }


    public String getSurname() {
        return surname;
    }

    public int getPlace() {
        return place;
    }

    public double getLuggageWeight() {
        return luggageWeight;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }


    public void setData(Node node) {
        this.setSurname(node.getSurname());
        this.setPlace(node.getPlace());
        this.setLuggageWeight(node.getLuggageWeight());
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setLuggageWeight(double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }


    public boolean hasNextLeft() {
        return left != null;
    }

    public boolean hasNextRight() {
        return right != null;
    }

    @Override
    public String toString() {
        return "[surname = " + surname +
                ", place = " + place +
                ", luggage = " + luggageWeight + "]";
    }
}
