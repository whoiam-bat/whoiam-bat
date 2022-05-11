package binTree;

import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTree{
    public Node root;

    private int size;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(Node key, boolean predicate) {
        root = fillTree(root, key, predicate);
        size++;
    }

    private Node fillTree(Node root, Node key, boolean createByPlace) {
         if(root == null) {
             root = key;
             return root;
         }
         if(createByPlace) {
             if(key.getPlace() < root.getPlace()) {
                 root.setLeft(fillTree(root.getLeft(), key, true));
             } else if(key.getPlace() > root.getPlace()) {
                 root.setRight(fillTree(root.getRight(), key, true));
             }
         } else {
             if(key.getLuggageWeight() < root.getLuggageWeight()) {
                 root.setLeft(fillTree(root.getLeft(), key, false));
             } else if(key.getLuggageWeight() > root.getLuggageWeight()) {
                 root.setRight(fillTree(root.getRight(), key, false));
             }
         }
        return root;
    }

    public double average() {
        if(root == null) throw new NoSuchElementException("Empty tree!");
        return sum() / getSize();
    }

    private double sum() {
        Stack<Node> stack = new Stack<>();
        stack.push(this.root);

        double sum = 0.;

        while(!stack.empty()) {
            Node temp = stack.pop();
            sum += temp.getLuggageWeight();
            //System.out.println(temp);

            if(temp.hasNextLeft()) {
                stack.push(temp.getLeft());
            }
            if(temp.hasNextRight()) {
                stack.push(temp.getRight());
            }
        }
        return sum;
    }

    public boolean deleteTree() {
        if(root != null) root = null;
        size = 0;
        return true;
    }

    public boolean deleteLeftBranch() {
        if(root.getLeft() != null) root.setLeft(null);
        return true;
    }
    public boolean deleteRightBranch() {
        if(root.getRight() != null) root.setRight(null);
        return true;
    }

    public void delete(int place) {
        deleteNode(root, place);
    }
    private Node deleteNode(Node root, int place) {
        if(root == null) return root;

        //Recursively traversing by tree until not find the searching element
        if(place < root.getPlace()) {
            root.setLeft(deleteNode(root.getLeft(), place));
        } else if(place > root.getPlace()) {
            root.setRight(deleteNode(root.getRight(), place));
        }
        //When element has been found
        else {
            if(root.getLeft() == null) {
                return root.getRight();
            } else if(root.getRight() == null) {
                return root.getLeft();
            }

            root.setData(getMinAtRightSubtree(root.getRight()));
            root.setRight(deleteNode(root.getRight(), root.getPlace()));
        }
        size--;
        return root;
    }
    private Node getMinAtRightSubtree(Node root) {
        Node min = root;

        while(root.hasNextLeft()) {
            min = root.getLeft();
            root = root.getLeft();
        }
        return min;
    }

    public void preOrderTraverse(Node node) {
        if (node == null) return;
        System.out.println(node);
        preOrderTraverse(node.getLeft());
        preOrderTraverse(node.getRight());

    }
    public void postOrderTraverse(Node node) {
        if (node == null) return;
        postOrderTraverse(node.getLeft());
        postOrderTraverse(node.getRight());
        System.out.println(node);

    }
    public void inOrderTraverse(Node node) {
        if (node == null) return;
        inOrderTraverse(node.getLeft());
        System.out.println(node);
        inOrderTraverse(node.getRight());
    }

    public ArrayList<Node> BreadthFirstSearch(Node root) {
        ArrayList<Node> ar = new ArrayList<Node>();
        if(root==null) return ar;

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.getLeft() != null)
                queue.offer(temp.getLeft());
            if(temp.getRight() != null)
                queue.offer(temp.getRight());
            ar.add(temp);
        }

        for (Node it : ar) {
            it.setRight(null);
            it.setLeft(null);
        }
        return ar;
    }

    public BinaryTree createNewTree(boolean predicate) {
        ArrayList<Node> ar = this.BreadthFirstSearch(this.root);
        if(ar.isEmpty()) throw new ArrayStoreException("Array is empty");

        BinaryTree res = new BinaryTree();

        while(!ar.isEmpty()) {
            res.insert(ar.remove(0), predicate);
        }
        return res;
    }

    private int getSize() {
        return size;
    }

    public String forFileOutput(ArrayList<Node> ar) {
        return ar.stream().map(it -> it.toString()).collect(Collectors.joining("\n"));
    }
    @Override
    public String toString() {
        return "BinaryTree{" +
                "surname=" + root.getSurname() +
                ", place=" + root.getPlace() +
                ", weight=" + root.getLuggageWeight() +
                "\nleft=" + root.getLeft() +
                "\nright=" + root.getRight() +
                '}';
    }
}
