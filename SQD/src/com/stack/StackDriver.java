package com.stack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StackDriver {
    private static void menu() {
        System.out.println("\t1. Push an element;");
        System.out.println("\t2. Pop an element;");
        System.out.println("\t3. Swap first element with last;");
        System.out.println("\t4. Delete each second element;");
        System.out.println("\t5. Max;");
        System.out.println("\t6. Delete min;");
        System.out.println("\t7. Delete all elements except last;");
        System.out.println("\t8. Delete all elements except first;");
        System.out.println("\t9. Insert symbol;");
        System.out.println("\t10. Reverse stack;");
        System.out.println("\t11. Get size;");
        System.out.println("\t12. Is empty;");
        System.out.println("\t13. Is full;");
        System.out.println("\t14. Print stack;");
        System.out.println("\t15. Write file;");
        System.out.println("\t16. Exit.");
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        StackDemo stack = new StackDemo();

        menu();
        while(true) {
            System.out.print("Make choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element: ");
                    stack.push(scanner.nextLong());
                }
                case 2 -> stack.pop();
                case 3 -> stack.swapFirsLast();
                case 4 -> stack.deleteOddIndexElements();
                case 5 -> System.out.println("Max { " + stack.max() + " }");
                case 6 -> System.out.println("Min { " + stack.deleteMin() + " }");
                case 7 -> stack.deleteExceptLast();
                case 8 -> stack.deleteExceptFirst();
                case 9 -> System.out.println(stack.insertSymbol());
                case 10 -> stack.reverseStack();
                case 11 -> System.out.println("Size { " + stack.getSize() + " }");
                case 12 -> System.out.println(stack.isEmpty());
                case 13 -> System.out.println(stack.isFull());
                case 14 -> System.out.println(stack);
                case 15 -> {
                    try (FileWriter file = new FileWriter("stack.txt", true)){
                        file.write(stack.toString());
                        file.append("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("File is not exist ==> " + e.getMessage());
                    }
                }
                case 16 -> System.exit(0);
                default -> throw new NoSuchElementException("There is no command with such index");
            }
        }
    }
}
