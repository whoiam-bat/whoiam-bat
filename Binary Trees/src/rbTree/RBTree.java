package rbTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class RBTree{
    public NodeRB root;
    private NodeRB TNULL;

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
            } else if (node.getParent() == node.getParent().getParent().getLeft()) {
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
    private void deletingBalance(NodeRB k) {
        NodeRB u;
        while(k.getParent().getColor() == Color.RED) {
            if(k.getParent() == k.getParent().getParent().getRight()) {
                u = k.getParent().getParent().getLeft(); //uncle
                if(u.getColor() == Color.RED) {
                    u.setColor(Color.BLACK);
                    k.getParent().setColor(Color.BLACK);
                    k.getParent().getParent().setColor(Color.RED);
                    k = k.getParent().getParent();
                } else {
                    if(k == k.getParent().getLeft()) {
                        k = k.getParent();
                        rightRotate(k);
                    }
                    k.getParent().setColor(Color.BLACK);
                    k.getParent().getParent().setColor(Color.RED);
                    leftRotate(k.getParent().getParent());
                }
            } else {
                u = k.getParent().getParent().getRight(); //uncle
                if(u.getColor() == Color.RED) {
                    u.setColor(Color.BLACK);
                    k.getParent().setColor(Color.BLACK);
                    k.getParent().getParent().setColor(Color.RED);
                    k = k.getParent().getParent();
                } else {
                    if(k == k.getParent().getRight()) {
                        k = k.getParent();
                        leftRotate(k);
                    }
                    k.getParent().setColor(Color.BLACK);
                    k.getParent().getParent().setColor(Color.RED);
                    leftRotate(k.getParent().getParent());
                }
            }
            if (k == root) {
                break;
            }
        }
        root.setColor(Color.BLACK);
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
        return ar.stream().map(NodeRB::toString).collect(Collectors.joining("\n"));
    }
    public boolean isValidTree() {
        return true;
    }
}
