package rbTree;

enum Color {
    RED,
    BLACK;

    @Override
    public String toString() {
        return "color = " + this.name();
    }
}

public class NodeRB {
    private String surname;
    private int place;
    private double luggageWeight;

    public NodeRB parent;
    private NodeRB left;
    private NodeRB right;
    private Color color;


    public NodeRB() {

    }

    public NodeRB(String surname, int place, double luggageWeight) {
        this.surname = surname;
        this.place = place;
        this.luggageWeight = luggageWeight;
        this.color = Color.RED;
    }

    public NodeRB(NodeRB node) {
        this.surname = node.surname;
        this.place = node.place;
        this.luggageWeight = node.luggageWeight;
        this.color = node.getColor();
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

    public void setLeft(NodeRB left) {
        this.left = left;
    }

    public void setRight(NodeRB right) {
        this.right = right;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public NodeRB getParent() {
        return parent;
    }

    public void setParent(NodeRB parent) {
        this.parent = parent;
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

    public NodeRB getLeft() {
        return left;
    }

    public NodeRB getRight() {
        return right;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NodeRB)) return false;

        NodeRB nodeRB = (NodeRB) o;

        if (getPlace() != nodeRB.getPlace()) return false;
        if (Double.compare(nodeRB.getLuggageWeight(), getLuggageWeight()) != 0) return false;
        if (!getSurname().equals(nodeRB.getSurname())) return false;
        return getColor() == nodeRB.getColor();
    }

    @Override
    public String toString() {
        return "RBTree[surname=" + surname +
                ", place=" + place +
                ", weight=" + luggageWeight +
                ", color=" + color + "]";
    }
}
