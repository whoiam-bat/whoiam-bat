package com.list;

import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ListDriver {
    private static void menu() {
        System.out.println("1. Add element;");
        System.out.println("2. Add at begin;");
        System.out.println("3. Remove element at index;");
        System.out.println("4. Swap;");
        System.out.println("5. Get size;");
        System.out.println("6. Peek at index;");
        System.out.println("7. Concat;");
        System.out.println("8. Clear;");
        System.out.println("9. Fill file;");
        System.out.println("10. Print list;");
        System.out.println("11. Exit");
    }
    private static void choseList() {
        System.out.println("1. Cycle doubly linked list");
        System.out.println("2. Doubly linked list");
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        choseList();
        int choice = scanner.nextInt();
        Collection list;
        list = (choice == 1) ? new CycleList() : new DoublyList();

        menu();
        while (true) {
            System.out.print("Make your choice: ");
            int temp = scanner.nextInt();
            switch (temp) {
                case 1 -> {
                    list.add((int)(Math.random() * 20));
                }
                case 2 -> {
                    list.addFirst((int)(Math.random() * 20));
                }
                case 3 -> {
                    System.out.println("Enter index of deleting element: ");
                    int index = scanner.nextInt();
                    list.removeAt(index);
                }
                case 4 -> {
                    int indexFirst = scanner.nextInt();
                    int indexSecond = scanner.nextInt();
                    list.swap(indexFirst, indexSecond);
                    System.out.println(list);
                    System.out.println();
                }
                case 5 -> {
                    System.out.println("Size of list: " + list.size());
                }
                case 6 -> {
                    int peekedIndex = scanner.nextInt();
                    System.out.println("Element: " + list.peekAt(peekedIndex));
                }
                case 7 -> {
                    DoublyList local = new DoublyList();
                    local.add(10);
                    local.add(20);
                    local.add(30);
                    System.out.println("Global list: " + list);
                    System.out.println("Local list: " + local);
                    System.out.println("Result: " + new DoublyList().concat((DoublyList) list, local));
                }
                case 8 -> list.clear();
                case 9 -> {
                    try {
                        FileWriter file = new FileWriter("list.txt", true);
                        file.write(list.toString());
                        file.append('\n');
                        file.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("File is not exist ==> " + e.getMessage());
                    }
                }
                case 10 -> {
                    System.out.println("List " + list);
                }
                case 11 -> {
                    System.exit(0);
                    break;
                }
                default -> throw new NoSuchElementException("There is no command with such index");
            }
        }

    }
    /*private Collection merge(Collection it, Collection other) {
        if (it.getClass().equals(other.getClass()))
            throw new ClassCastException("Object are located at different branches of inheritance");

        if (it instanceof CycleList) {
            CycleList temp = new CycleList();
            return temp.concat((CycleList) it, (CycleList) other);
        }
        DoublyList temp = new DoublyList();
        return temp.concat((DoublyList) it, (DoublyList) other);
    }*/
}
