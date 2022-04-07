package com;

import com.deque.DequeDriver;
import com.queue.QueueDriver;
import com.stack.StackDriver;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\t1. Stack;");
        System.out.println("\t2. Queue;");
        System.out.println("\t3. Deque.");

        switch (scanner.nextInt()) {
            case 1 -> StackDriver.run();
            case 2 -> QueueDriver.run();
            case 3 -> DequeDriver.run();
        }
    }
}
