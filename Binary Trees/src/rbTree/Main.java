package rbTree;

import binTree.BinaryTree;
import binTree.Node;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static void menu() {
        System.out.println("1. Add element;");
        System.out.println("2. Create tree from file;");
        System.out.println("3. Delete element;");
        System.out.println("4. Print pre-order;");
        System.out.println("5. Print post-order;");
        System.out.println("6. Print in-order;");
        System.out.println("7. Fill file;");
        System.out.println("8. Exit");
    }

    public static void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        RBTree rbTree = new RBTree();
        menu();
        boolean predicate = true;
        while (true) {
            System.out.print("Make your choice: ");
            int temp = scanner.nextInt();
            switch (temp) {
                case 1 -> {
                    System.out.println("Enter [surname, place, luggage weight]");
                    String surname = scanner.next();
                    int place = scanner.nextInt();
                    double weight = scanner.nextDouble();
                    rbTree.insert(new NodeRB(surname, place, weight));
                }
                case 2 -> {
                    BufferedReader br = new BufferedReader(new FileReader(new File("input data.txt")));
                    String str;
                    while ((str = br.readLine()) != null) {
                        String[] tempStr = str.split(" ");
                        rbTree
                                .insert(
                                        new NodeRB(tempStr[0], Integer.parseInt(tempStr[1]), Double.parseDouble(tempStr[2])));
                    }
                }
                case 3 -> {
                    System.out.print("Enter deleting node: ");
                    int place = scanner.nextInt();
                    rbTree.delete(place);
                }
                case 4 -> rbTree.preOrderTraverse(rbTree.root);
                case 5 -> rbTree.postOrderTraverse(rbTree.root);
                case 6 -> rbTree.inOrderTraverse(rbTree.root);
                case 7 -> {
                    try {
                        FileWriter file = new FileWriter("rbTree.txt", false);
                        file.write(rbTree.forFileOutput(rbTree.BreadthFirstSearch(rbTree.root)));
                        file.append('\n');
                        file.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("File is not exist ==> " + e.getMessage());
                    }
                }
                case 8 -> System.exit(0);

                default -> throw new NoSuchElementException("There is no command with such index");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        run();
    }
}
