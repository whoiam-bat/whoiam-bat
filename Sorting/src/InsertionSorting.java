import java.util.Arrays;
import java.util.Scanner;

public class InsertionSorting implements Sortingable{
    private int[] ar;
    private int size;

    public InsertionSorting(int size) {
            this.size = size;
            ar = new int[size];
    }
    public InsertionSorting(int[] ar) {
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
        for (int i = 0; i < getSize(); i++) {
            int val = ar[i];
            int iter = i - 1;
            for (; iter >= 0; iter--) {
                if(val < ar[iter]) {
                    ar[iter + 1] = ar[iter];
                } else break;
            }
            ar[iter + 1] = val;
        }
    }

    @Override
    public String toString() {
        return "InsertionSorting{ar=" +
                Arrays.toString(ar) +
                ", size=" + size +
                '}';
    }
}
