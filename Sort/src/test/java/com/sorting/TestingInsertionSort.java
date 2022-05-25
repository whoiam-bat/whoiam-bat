package com.sorting;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class TestingInsertionSort {
    InsertionSorting test;

    @Test
    public void testInsertionSortingSourceUnsortedArrayWith10Elements() {
        int[] expected = new int[10];
        int[] actual = new int[10];

        try(Scanner sc = new Scanner(new File("unsorted.txt"))) {
            for (int i = 0; i < actual.length; i++) {
                int value = sc.nextInt();
                actual[i] = value;
                expected[i] = value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(expected);
        test = new InsertionSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortingSourceUnsortedArrayWith100Elements() {
        int[] expected = new int[100];
        int[] actual = new int[100];

        try(Scanner sc = new Scanner(new File("unsorted.txt"))) {
            for (int i = 0; i < actual.length; i++) {
                int value = sc.nextInt();
                actual[i] = value;
                expected[i] = value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(expected);
        test = new InsertionSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortingSourceUnsortedArrayWith1000Elements() {
        int[] expected = new int[1000];
        int[] actual = new int[1000];

        try(Scanner sc = new Scanner(new File("unsorted.txt"))) {
            for (int i = 0; i < actual.length; i++) {
                int value = sc.nextInt();
                actual[i] = value;
                expected[i] = value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(expected);
        test = new InsertionSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortingSourceUnsortedArrayWith10000Elements() {
        int[] expected = new int[10000];
        int[] actual = new int[10000];

        try(Scanner sc = new Scanner(new File("unsorted.txt"))) {
            for (int i = 0; i < actual.length; i++) {
                int value = sc.nextInt();
                actual[i] = value;
                expected[i] = value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(expected);
        test = new InsertionSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortingSourceAscendingArrayWith10Elements() {
        int[] expected = new int[10];
        int[] actual = new int[10];

        try(Scanner sc = new Scanner(new File("ascending.txt"))) {
            for (int i = 0; i < actual.length; i++) {
                int value = sc.nextInt();
                actual[i] = value;
                expected[i] = value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(expected);
        test = new InsertionSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortingSourceAscendingArrayWith100Elements() {
        int[] expected = new int[100];
        int[] actual = new int[100];

        try(Scanner sc = new Scanner(new File("ascending.txt"))) {
            for (int i = 0; i < actual.length; i++) {
                int value = sc.nextInt();
                actual[i] = value;
                expected[i] = value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(expected);
        test = new InsertionSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortingSourceAscendingArrayWith1000Elements() {
        int[] expected = new int[1000];
        int[] actual = new int[1000];

        try(Scanner sc = new Scanner(new File("ascending.txt"))) {
            for (int i = 0; i < actual.length; i++) {
                int value = sc.nextInt();
                actual[i] = value;
                expected[i] = value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(expected);
        test = new InsertionSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortingSourceAscendingArrayWith10000Elements() {
        int[] expected = new int[10000];
        int[] actual = new int[10000];

        try(Scanner sc = new Scanner(new File("ascending.txt"))) {
            for (int i = 0; i < actual.length; i++) {
                int value = sc.nextInt();
                actual[i] = value;
                expected[i] = value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(expected);
        test = new InsertionSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortingSourceDescendingArrayWith10Elements() {
        int[] expected = new int[10];
        int[] actual = new int[10];

        try(Scanner sc = new Scanner(new File("descending.txt"))) {
            for (int i = 0; i < actual.length; i++) {
                int value = sc.nextInt();
                actual[i] = value;
                expected[i] = value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(expected);
        test = new InsertionSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortingSourceDescendingArrayWith100Elements() {
        int[] expected = new int[100];
        int[] actual = new int[100];

        try(Scanner sc = new Scanner(new File("descending.txt"))) {
            for (int i = 0; i < actual.length; i++) {
                int value = sc.nextInt();
                actual[i] = value;
                expected[i] = value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(expected);
        test = new InsertionSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortingSourceDescendingArrayWith1000Elements() {
        int[] expected = new int[1000];
        int[] actual = new int[1000];

        try(Scanner sc = new Scanner(new File("descending.txt"))) {
            for (int i = 0; i < actual.length; i++) {
                int value = sc.nextInt();
                actual[i] = value;
                expected[i] = value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(expected);
        test = new InsertionSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortingSourceDescendingArrayWith10000Elements() {
        int[] expected = new int[10000];
        int[] actual = new int[10000];

        try(Scanner sc = new Scanner(new File("descending.txt"))) {
            for (int i = 0; i < actual.length; i++) {
                int value = sc.nextInt();
                actual[i] = value;
                expected[i] = value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(expected);
        test = new InsertionSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }
}
