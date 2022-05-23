package binTree;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static void menu() {
        System.out.println("1. Add element;");
        System.out.println("2. Create tree from file;");
        System.out.println("3. Delete element;");
        System.out.println("4. Average;");
        System.out.println("5. Print tree;");
        System.out.println("6. Print pre-order;");
        System.out.println("7. Print post-order;");
        System.out.println("8. Print in-order;");
        System.out.println("9. Rewrite tree by other key;");
        System.out.println("10. Fill file;");
        System.out.println("11. Delete right branch;");
        System.out.println("12. Delete left branch;");
        System.out.println("13. Delete tree;");
        System.out.println("14. Exit");
    }
    public static void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
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
                    binaryTree.insert(new Node(surname, place, weight), predicate);
                }
                case 2 -> {
                    BufferedReader br = new BufferedReader(new FileReader(new File("input data.txt")));
                    String str;
                    while((str = br.readLine()) != null) {
                        String[] tempStr = str.split(" ");
                        binaryTree
                                .insert(
                                        new Node(tempStr[0], Integer.parseInt(tempStr[1]), Double.parseDouble(tempStr[2])), true);
                    }
                }
                case 3 -> {
                    System.out.print("Enter deleting node: ");
                    int place = scanner.nextInt();
                    binaryTree.delete(place);
                }
                case 4 -> System.out.println(binaryTree.average());
                case 5 -> binaryTree.prettyPrint();
                case 6 -> binaryTree.preOrderTraverse(binaryTree.root);
                case 7 -> binaryTree.postOrderTraverse(binaryTree.root);
                case 8 -> binaryTree.inOrderTraverse(binaryTree.root);
                case 9 -> {
                    if(predicate) predicate = false;
                    else predicate = true;
                    binaryTree = binaryTree.createNewTree(predicate);
                }
                case 10 -> {
                    try {
                        FileWriter file = new FileWriter("binaryTree.txt", false);
                        file.write(binaryTree.forFileOutput(binaryTree.BreadthFirstSearch(binaryTree.root)));
                        file.append('\n');
                        file.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("File is not exist ==> " + e.getMessage());
                    }
                }
                case 11 -> binaryTree.deleteRightBranch();
                case 12 -> binaryTree.deleteLeftBranch();
                case 13 -> binaryTree.deleteTree();
                case 14 -> System.exit(0);

                default -> throw new NoSuchElementException("There is no command with such index");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        run();
    }
}
