package com.sorting;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestingHeapSort {
    HeapSorting test;

    @Test
    public void testHeapSortingSourceUnsortedArrayWith10Elements() {
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
        test = new HeapSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHeapSortingSourceUnsortedArrayWith100Elements() {
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
        test = new HeapSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHeapSortingSourceUnsortedArrayWith1000Elements() {
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
        test = new HeapSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHeapSortingSourceUnsortedArrayWith10000Elements() {
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
        test = new HeapSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHeapSortingSourceAscendingArrayWith10Elements() {
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
        test = new HeapSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHeapSortingSourceAscendingArrayWith100Elements() {
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
        test = new HeapSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHeapSortingSourceAscendingArrayWith1000Elements() {
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
        test = new HeapSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHeapSortingSourceAscendingArrayWith10000Elements() {
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
        test = new HeapSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHeapSortingSourceDescendingArrayWith10Elements() {
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
        test = new HeapSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHeapSortingSourceDescendingArrayWith100Elements() {
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
        test = new HeapSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHeapSortingSourceDescendingArrayWith1000Elements() {
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
        test = new HeapSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHeapSortingSourceDescendingArrayWith10000Elements() {
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
        test = new HeapSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

}
