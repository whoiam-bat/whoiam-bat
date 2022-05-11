import java.io.*;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static void menu() {
        System.out.println("1. Console input;");
        System.out.println("2. From file;");
        System.out.println("3. Print array;");
        System.out.println("4. Heap sorting;");
        System.out.println("5. Insertion sorting;");
        System.out.println("6. Shaker sorting;");
        System.out.println("7. Fill file;");
        System.out.println("8. Exit");
    }
    public static void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] ar = new int[0];
        Sortingable s = null;
        menu();
        boolean predicate = true;
        while (true) {
            System.out.print("Make your choice: ");
            int temp = scanner.nextInt();
            switch (temp) {
                case 1 -> {
                    System.out.print("Input size of array: ");
                    ar = new int[scanner.nextInt()];
                    System.out.println("\nInput an array:");
                    for (int i = 0; i < ar.length; i++) {
                        ar[i] = scanner.nextInt();
                    }
                }
                case 2 -> {
                    System.out.print("Input size of array: ");
                    ar = new int[scanner.nextInt()];
                    try(Scanner sc = new Scanner(new File("source data.txt"))) {
                        for (int i = 0; i < ar.length; i++) {
                            ar[i] = sc.nextInt();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                case 3 -> System.out.println(Arrays.toString(ar));
                case 4 -> {
                    s = new HeapSorting(ar);
                    s.sort();
                }
                case 5 -> {
                    s = new InsertionSorting(ar);
                    s.sort();
                }
                case 6 -> {
                    s = new ShakerSorting(ar);
                    s.sort();
                }
                case 7 -> {
                    try(FileWriter file = new FileWriter("arr.txt", true)){
                        file.write(s.getClass().getSimpleName() + Arrays.toString(ar));
                        file.append("\n\n");
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
