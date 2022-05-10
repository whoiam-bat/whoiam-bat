package rbTree;

import binTree.Node;

import java.util.NoSuchElementException;
import java.util.prefs.NodeChangeEvent;

public class RBTree {
    public NodeRB root;
    private NodeRB TNULL;

    public RBTree() {
        TNULL = new NodeRB();
        TNULL.setColor(Color.BLACK);
        TNULL.setLeft(null);
        TNULL.setRight(null);
        this.root = TNULL;
    }

    public void insert(NodeRB node) {
        traverseAndInsert(node);
    }

    private void traverseAndInsert(NodeRB node) {
        NodeRB insertingNode = new NodeRB(node);
        insertingNode.setParent(null);
        insertingNode.setLeft(TNULL);
        insertingNode.setRight(TNULL);

        NodeRB x = root;
        NodeRB y = null;

        while(x != TNULL) {
            y = x;
            if (insertingNode.getPlace() < x.getPlace()) {
                x = x.getLeft();
            } else if (insertingNode.getPlace() > x.getPlace()) {
                x = x.getRight();
            }
        }

        insertingNode.setParent(y);
        if(y == null) {
            root = insertingNode;
        } else if(insertingNode.getPlace() < y.getPlace()) {
            y.setLeft(insertingNode);
        } else if(insertingNode.getPlace() > y.getPlace()) {
            y.setRight(insertingNode);
        }

        if(insertingNode.getParent() == null) {
            insertingNode.setColor(Color.BLACK);
            return;
        }
        if(insertingNode.getParent().getParent() == null) {
            return;
        }
        insertingBalance(insertingNode);
    }
    private void insertingBalance(NodeRB node) {
        NodeRB uncle;

        while (node != root && node.getParent().getColor() == Color.RED) {
            if (node.getParent() == node.getParent().getParent().getRight()) {
                uncle = node.getParent().getParent().getLeft();

                if(uncle.getColor() == Color.RED) {
                    flipColor(node, uncle);
                } else {
                    if(node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rightRotate(node);
                    }
                    node.getParent().setColor(Color.BLACK);
                    node.getParent().getParent().setColor(Color.RED);
                    leftRotate(node.getParent().getParent());
                }

            }
            else if (node.getParent() == node.getParent().getParent().getLeft()) {
                uncle = node.getParent().getParent().getRight();

                if (uncle.getColor() == Color.RED) {
                    flipColor(node, uncle);
                } else {
                    if (node == node.getParent().getRight()) {
                        node = node.getParent();
                        leftRotate(node);
                    }
                    node.getParent().setColor(Color.BLACK);
                    node.getParent().getParent().setColor(Color.RED);
                    rightRotate(node.getParent().getParent());
                }
            }

            if(node == root) {
                break;
            }
        }
        root.setColor(Color.BLACK);
    }
    private void leftRotate(NodeRB newNode) {
        NodeRB tempRoot = newNode.getRight();
        newNode.setRight(tempRoot.getLeft());

        if(tempRoot.getLeft() != TNULL) {
            tempRoot.getLeft().setParent(newNode);
        }
        tempRoot.setParent(newNode.getParent());

        if(newNode.getParent() == null) {
            this.root = tempRoot;
        } else if(newNode == newNode.getParent().getLeft()) {
            newNode.getParent().setLeft(tempRoot);
        } else {
            newNode.getParent().setRight(tempRoot);
        }
        tempRoot.setLeft(newNode);
        newNode.setParent(tempRoot);
    }
    private void rightRotate(NodeRB newNode) {
        NodeRB tempRoot = newNode.getLeft();
        newNode.setLeft(tempRoot.getRight());

        if(tempRoot.getRight() != TNULL) {
            tempRoot.getRight().setParent(newNode);
        }
        tempRoot.setParent(newNode.getParent());
        if(newNode.getParent() == null) {
            this.root = tempRoot;
        } else if(newNode == newNode.getParent().getLeft()) {
            newNode.getParent().setLeft(tempRoot);
        } else {
            newNode.getParent().setRight(tempRoot);
        }
        tempRoot.setRight(newNode);
        newNode.setParent(tempRoot);
    }
    private void flipColor(NodeRB node, NodeRB uncle) {
        uncle.setColor(Color.BLACK);
        node.getParent().setColor(Color.BLACK);
        node.getParent().getParent().setColor(Color.RED);
        node = node.getParent().getParent();
    }

    public void delete(int key) {
        deleteNode(this.root, key);
    }
    private void deleteNode(NodeRB node, int key) {
        if(node == null) throw new NoSuchElementException("Tree is empty");

        Color color;
        NodeRB deletedNode = TNULL;
        while(node != TNULL) {
            if(node.getPlace() == key) {
                deletedNode = node;
                color = node.getColor();
            } else if(node.getPlace() < key) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }

        //If node is leaf without children and its color is red
        if(deletedNode.getRight() == TNULL && deletedNode.getLeft() == TNULL && deletedNode.getColor() == Color.RED) {
            if(deletedNode == deletedNode.getParent().getLeft()) {
                deletedNode.getParent().setLeft(TNULL);
            } else if(deletedNode == deletedNode.getParent().getRight()) {
                deletedNode.getParent().setRight(TNULL);
            }
        }
        //If node has only one child and its color is red
        //else if()

    }


    public void preOrderTraverse(NodeRB node) {
        if (node == TNULL) return;
        System.out.println(node);
        preOrderTraverse(node.getLeft());
        preOrderTraverse(node.getRight());
    }
    public void postOrderTraverse(NodeRB node) {
        if (node == TNULL) return;
        postOrderTraverse(node.getLeft());
        postOrderTraverse(node.getRight());
        System.out.println(node);

    }
    public void inOrderTraverse(NodeRB node) {
        if (node == TNULL) return;
        inOrderTraverse(node.getLeft());
        System.out.println(node);
        inOrderTraverse(node.getRight());
    }


    public boolean isValidTree() {
        return true;
    }
}
