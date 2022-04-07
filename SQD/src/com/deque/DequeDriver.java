package com.deque;

import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DequeDriver {
    private static void menu() {
        System.out.println("\t1. Add at the front;");
        System.out.println("\t2. Add at the back;");
        System.out.println("\t3. Remove first;");
        System.out.println("\t4. Remover last;");
        System.out.println("\t5. Get by index;");
        System.out.println("\t6. Is empty;");
        System.out.println("\t7. Is full;");
        System.out.println("\t8. Get size;");
        System.out.println("\t9. Print deque;");
        System.out.println("\t10. Write file;");
        System.out.println("\t11. Exit.");

    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        DequeDemo deque = new DequeDemo();

        menu();
        while(true) {
            System.out.print("Make choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element: ");
                    deque.offerFirst(scanner.nextLong());
                }
                case 2 -> {
                    System.out.print("Enter element: ");
                    deque.offerLast(scanner.nextLong());
                }
                case 3 -> deque.removeFirst();
                case 4 -> deque.removeLast();
                case 5 -> {
                    System.out.print("Enter index of element: ");
                    System.out.println("Element { " + deque.peekAt(scanner.nextInt()) + " }");
                }
                case 6 -> System.out.println(deque.isEmpty());
                case 7 -> System.out.println(deque.isFull());
                case 8 -> System.out.println("Size { " + deque.getSize() + " }");
                case 9 -> System.out.println(deque);
                case 10 -> {
                    try (FileWriter file = new FileWriter("deque.txt", true)) {
                        file.write(deque.toString());
                        file.append("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("File is not exist ==> " + e.getMessage());
                    }
                }
                case 11 -> System.exit(0);
                default -> throw new NoSuchElementException("There is no command with such index");
            }
        }
    }
}
