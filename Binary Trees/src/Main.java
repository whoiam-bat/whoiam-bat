import binTree.Node;
import rbTree.NodeRB;
import rbTree.RBTree;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //BinaryTree tree = new BinaryTree();
        RBTree tree = new RBTree();

        ArrayList<NodeRB> info = new ArrayList<>();


        info.add(new NodeRB("", 52, 12));
        info.add(new NodeRB("", 15, 3));
        info.add(new NodeRB("", 56, 15));
        info.add(new NodeRB("", 9, 6));
        info.add(new NodeRB("",   16, 18));
        info.add(new NodeRB("", 54, 20));
        info.add(new NodeRB("", 3, 2));
        info.add(new NodeRB("", 10, 9));
        info.add(new NodeRB("", 65, 45));
        info.add(new NodeRB("", 72, 67));
        info.add(new NodeRB("", 61, 50));

        for (NodeRB it : info) {
            tree.insert(it);
        }

        tree.preOrderTraverse(tree.root);

        tree.delete(65);

        System.out.println("\n");
        tree.preOrderTraverse(tree.root);

        /*tree.inOrderTraverse(tree.root);
        System.out.println("\n\n");


        //res.root = tree.createNewTree(tree.BreadthFirstSearch(tree.root));

        tree = tree.createNewTree(false);
        tree.inOrderTraverse(tree.root);*/

    }
}
