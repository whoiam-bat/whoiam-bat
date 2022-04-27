import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(new Node("", 52, 12), true);
        tree.insert(new Node("", 15, 3), true);
        tree.insert(new Node("", 56, 15), true);
        tree.insert(new Node("", 9, 6), true);
        tree.insert(new Node("",   16, 18), true);
        tree.insert(new Node("", 54, 20), true);
        tree.insert(new Node("", 3, 2), true);
        tree.insert(new Node("", 10, 9), true);
        tree.insert(new Node("", 65, 45), true);
        tree.insert(new Node("", 72, 67), true);
        tree.insert(new Node("", 61, 50), true);

        tree.inOrderTraverse(tree.root);
        System.out.println("\n\n");


        //res.root = tree.createNewTree(tree.BreadthFirstSearch(tree.root));

        tree = tree.createNewTree(false);
        tree.inOrderTraverse(tree.root);

    }
}
