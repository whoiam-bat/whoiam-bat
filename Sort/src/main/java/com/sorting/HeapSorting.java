package com.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSorting implements Sortingable{
    private int[] ar;
    private int size;


    public HeapSorting(int size) {
        this.size = size;
        ar = new int[size];
    }
    public HeapSorting(int[] ar) {
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
        for (int i = getSize() / 2 - 1; i >= 0; i--) {
            heapify(getSize(), i);
        }
        for (int i = getSize() - 1; i >= 0; i--) {
            int temp = ar[0];
            ar[0] = ar[i];
            ar[i] = temp;

            heapify(i, 0);
        }
    }
    private void heapify(int count, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < count && ar[left] > ar[largest]) {
            largest = left;
        }
        if(right < count && ar[right] > ar[largest]) {
            largest = right;
        }
        if(largest != i) {
            int temp = ar[i];
            ar[i] = ar[largest];
            ar[largest] = temp;

            heapify(count, largest);
        }
    }

    @Override
    public String toString() {
        return "com.sorting.HeapSorting{ar=" +
                Arrays.toString(ar) +
                ", size=" + size +
                '}';
    }
}
