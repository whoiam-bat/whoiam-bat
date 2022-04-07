package com.queue;

import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QueueDriver {
    private static void menu() {
        System.out.println("\t1. Enqueue an element;");
        System.out.println("\t2. Dequeue an element;");
        System.out.println("\t3. Get average;");
        System.out.println("\t4. Find min and max;");
        System.out.println("\t5. Get left neighbour of minimal element;");
        System.out.println("\t6. Get size;");
        System.out.println("\t7. Is empty;");
        System.out.println("\t8. Is full;");
        System.out.println("\t9. Print queue;");
        System.out.println("\t10. Write file;");
        System.out.println("\t11. Exit.");
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        QueueDemo queue = new QueueDemo();

        menu();
        while(true) {
            System.out.print("Make choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element: ");
                    queue.enqueue(scanner.nextLong());
                }
                case 2 -> queue.dequeue();
                case 3 -> System.out.println("Average { " + queue.average() + " }");
                case 4 -> System.out.println(queue.getMinMax());
                case 5 -> System.out.println("Left neighbour of min { " + queue.getLeftNeighbourToMin() + " }");
                case 6 -> System.out.println("Size { " + queue.getSize() + " }");
                case 7 -> System.out.println(queue.isEmpty());
                case 8 -> System.out.println(queue.isFull());
                case 9 -> System.out.println(queue);
                case 10 -> {
                    try (FileWriter file = new FileWriter("queue.txt", true)){
                        file.write(queue.toString());
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
