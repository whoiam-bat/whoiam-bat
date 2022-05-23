package rbTree;

import binTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class RBTree{
    public NodeRB root;
    private NodeRB TNULL;
    public static final int COUNT = 20;

    public RBTree() {
        TNULL = new NodeRB();
        TNULL.setColor(Color.BLACK);
        TNULL.setLeft(null);
        TNULL.setRight(null);
        root = TNULL;
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
        return;
    }
    private void insertingBalance(NodeRB node) {
        NodeRB uncle;
        while (node.getParent().getColor() == Color.RED) {
            if (node.getParent() == node.getParent().getParent().getRight()) {
                uncle = node.getParent().getParent().getLeft();
                if(uncle.getColor() == Color.RED) {
                    uncle.setColor(Color.BLACK);
                    node.getParent().setColor(Color.BLACK);
                    node.getParent().getParent().setColor(Color.RED);
                    node = node.getParent().getParent();
                } else {
                    if(node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rightRotate(node);
                    }
                    node.getParent().setColor(Color.BLACK);
                    node.getParent().getParent().setColor(Color.RED);
                    leftRotate(node.getParent().getParent());
                }
            } else {
                uncle = node.getParent().getParent().getRight();
                if (uncle.getColor() == Color.RED) {
                    uncle.setColor(Color.BLACK);
                    node.getParent().setColor(Color.BLACK);
                    node.getParent().getParent().setColor(Color.RED);
                    node = node.getParent().getParent();
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
            if(node == root) break;
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


    public void delete(int key) {
        NodeRB parent = null;
        NodeRB node = findWithParent(key, parent);
        NodeRB z = TNULL;
        NodeRB x, y;
        while(node != TNULL) {
            if(node.getPlace() == key) {
                z = node;
            }
            if(node.getPlace() <= key) {
                node = node.getRight();
            } else {
                node = node.getLeft();
            }
        }
        if(z == TNULL) {
            System.out.println("Couldn't find key in the tree");
            return;
        }
        y = z;
        Color ordinaryColor = y.getColor();
        if(z.getLeft() == TNULL) {
            x = z.getRight();
            rbTransplant(z, z.getRight());
        } else if(z.getRight() == TNULL) {
            x = z.getLeft();
            rbTransplant(z, z.getLeft());
        } else {
            y = minimum(z.getRight());
            ordinaryColor = y.getColor();
            x = y.getRight();
            if(y.getParent() == z) {
                x.setParent(y);
            } else {
                rbTransplant(y, y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }
            rbTransplant(z, y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
            y.setColor(z.getColor());
        }
        if(ordinaryColor == Color.BLACK) {
            deletingBalance(x);
        }
    }
    private NodeRB findWithParent(int key, NodeRB parent) {
        if(root.getPlace() == key) {
            return root;
        }
        NodeRB curr = root;
        while(curr != null) {
            if(curr.getPlace() == key) return curr;
            parent = curr;
            if(key < curr.getPlace()) {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
        }
        return null;
    }
    private void deletingBalance(NodeRB x) {
        NodeRB s = null;
        while(x != root && x.getColor() == Color.BLACK) {
            if (x == x.getParent().getLeft()) {
                s = x.getParent().getRight();
                if(s.getColor() == Color.RED) {
                    //case 3.1
                    s.setColor(Color.BLACK);
                    x.getParent().setColor(Color.RED);
                    leftRotate(x.getParent());
                    s = x.getParent().getRight();
                }
                if(s.getLeft().getColor() == Color.BLACK && s.getRight().getColor() == Color.BLACK){
                    //case 3.2
                    s.setColor(Color.RED);
                    x = x.getParent();
                } else {
                    if(s.getRight().getColor() == Color.BLACK) {
                        //case 3.3
                        s.getLeft().setColor(Color.BLACK);
                        s.setColor(Color.RED);
                        rightRotate(s);
                        s = x.getParent().getRight();
                    }

                    //case 3.4
                    s.setColor(x.getParent().getColor());
                    x.getParent().setColor(Color.BLACK);
                    s.getRight().setColor(Color.BLACK);
                    leftRotate(x.getParent());
                    x = root;
                }
            } else {
                s = x.getParent().getLeft();
                if(s.getColor() == Color.RED) {
                    //case 3.1
                    s.setColor(Color.BLACK);
                    x.getParent().setColor(Color.RED);
                    rightRotate(x.getParent());
                    s = x.getParent().getLeft();
                }
                if(s.getLeft().getColor() == Color.BLACK && s.getRight().getColor() == Color.BLACK){
                    //case 3.2
                    s.setColor(Color.RED);
                    x = x.getParent();
                } else {
                    if(s.getLeft().getColor() == Color.BLACK) {
                        //case 3.3
                        s.getRight().setColor(Color.BLACK);
                        s.setColor(Color.RED);
                        leftRotate(s);
                        s = x.getParent().getLeft();
                    }
                    //case 3.4
                    s.setColor(x.getParent().getColor());
                    x.getParent().setColor(Color.BLACK);
                    s.getLeft().setColor(Color.BLACK);
                    rightRotate(x.getParent());
                    x = root;
                }
            }
        }
        x.setColor(Color.BLACK);
    }
    private NodeRB minimum(NodeRB node) {
        while (node.getLeft() != TNULL) {
            node = node.getLeft();
        }
        return node;
    }
    private void rbTransplant(NodeRB u, NodeRB v) {
        if (u.getParent() == null) {
            root = v;
        } else if (u == u.getParent().getLeft()) {
            u.parent.setLeft(v);
        } else {
            u.parent.setRight(v);
        }
        v.parent = u.parent;
    }
    private void deleteLeaf(NodeRB leaf) {
        if(leaf != TNULL) {
            deleteLeaf(leaf.getRight());
            deleteLeaf(leaf.getLeft());
            leaf = TNULL;
        }
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

    public ArrayList<NodeRB> BreadthFirstSearch(NodeRB root) {
        ArrayList<NodeRB> ar = new ArrayList<NodeRB>();
        if(root==null) return ar;

        Queue<NodeRB> queue = new LinkedList<NodeRB>();
        queue.offer(root);

        while(!queue.isEmpty()){
            NodeRB temp = queue.poll();
            if(temp.getLeft() != null)
                queue.offer(temp.getLeft());
            if(temp.getRight() != null)
                queue.offer(temp.getRight());
            ar.add(temp);
        }

        for (NodeRB it : ar) {
            it.setRight(null);
            it.setLeft(null);
        }
        return ar;
    }
    public String forFileOutput(ArrayList<NodeRB> ar) {
        return print2DUtil(root, 0);//ar.stream().map(NodeRB::toString).collect(Collectors.joining("\n"));
    }
    public boolean isValidTree() {
        return true;
    }

    private String print2DUtil(NodeRB root, int space) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "";

        space += COUNT;

        sb.append(print2DUtil(root.getRight(), space));

        //System.out.println();
        sb.append("\n");
        for (int i = COUNT; i < space; i++) {
            sb.append(" ");
            //System.out.print(" ");
        }
        sb.append("surname = " + root.getSurname() + "\n");
        //System.out.println(root.getSurname());
        for (int i = COUNT; i < space; i++) {
            sb.append(" ");
            //System.out.print(" ");
        }
        sb.append("place = " + root.getPlace() + "\n");
        //System.out.println(root.getPlace());
        for (int i = COUNT; i < space; i++) {
            sb.append(" ");
            //System.out.print(" ");
        }
        sb.append("weight = " + root.getLuggageWeight() + "\n");
        //System.out.println(root.getLuggageWeight());
        for (int i = COUNT; i < space; i++) {
            sb.append(" ");
            //System.out.print(" ");
        }
        sb.append(root.getColor() + "\n");
        //System.out.println(root.getColor());

        sb.append(print2DUtil(root.getLeft(), space));
        return sb.toString();
    }
    public void prettyPrint() {
        System.out.println(print2DUtil(root, 0));
    }
}
