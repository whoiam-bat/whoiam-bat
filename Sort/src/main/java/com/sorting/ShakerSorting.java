package com.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class ShakerSorting implements Sortingable{
    private int[] ar;
    private int size;


    public ShakerSorting(int size) {
        this.size = size;
        ar = new int[size];
    }

    public ShakerSorting(int[] ar) {
        this.ar = ar;
        this.size = ar.length;
    }

    @Override
    public int[] getAr() {
        return ar;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void fillArray() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < getSize(); i++) {
            ar[i] = scanner.nextInt();
        }
    }

    @Override
    public void sort() {
        int leftBorder = 1;
        int rightBorder = getSize() - 1;
        while(leftBorder <= rightBorder) {
            for (int i = rightBorder; i >= leftBorder; i--) {
                if (ar[i - 1] > ar[i]) {
                    int temp = ar[i - 1];
                    ar[i - 1] = ar[i];
                    ar[i] = temp;
                }
            }
            leftBorder++;
            for (int i = leftBorder; i <= rightBorder; i++) {
                if (ar[i - 1] > ar[i]) {
                    int temp = ar[i - 1];
                    ar[i - 1] = ar[i];
                    ar[i] = temp;
                }
            }
            rightBorder--;
        }
    }

    @Override
    public String toString() {
        return "com.sorting.ShakerSorting{" +
                "ar=" + Arrays.toString(ar) +
                ", size=" + size +
                '}';
    }
}
