package com.sorting;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class TestingShakerSort {
    ShakerSorting test;

    @Test
    public void testShakerSortingSourceUnsortedArrayWith10Elements() {
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
        test = new ShakerSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShakerSortingSourceUnsortedArrayWith100Elements() {
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
        test = new ShakerSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShakerSortingSourceUnsortedArrayWith1000Elements() {
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
        test = new ShakerSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShakerSortingSourceUnsortedArrayWith10000Elements() {
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
        test = new ShakerSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShakerSortingSourceAscendingArrayWith10Elements() {
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
        test = new ShakerSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShakerSortingSourceAscendingArrayWith100Elements() {
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
        test = new ShakerSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShakerSortingSourceAscendingArrayWith1000Elements() {
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
        test = new ShakerSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShakerSortingSourceAscendingArrayWith10000Elements() {
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
        test = new ShakerSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShakerSortingSourceDescendingArrayWith10Elements() {
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
        test = new ShakerSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShakerSortingSourceDescendingArrayWith100Elements() {
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
        test = new ShakerSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShakerSortingSourceDescendingArrayWith1000Elements() {
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
        test = new ShakerSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShakerSortingSourceDescendingArrayWith10000Elements()   {
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
        test = new ShakerSorting(actual);
        test.sort();
        actual = test.getAr();
        assertArrayEquals(expected, actual);
    }
}
