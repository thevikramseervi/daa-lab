import java.util.Scanner;
import java.util.Random;

public class prg3 {

    static int sortCount = 0;

    static void merge(int[] a, int left, int mid, int right) {
        int[] b = new int[mid - left + 1];
        int[] c = new int[right - mid];

        for (int i = 0; i < b.length; i++) {
            b[i] = a[i + left];
        }

        for (int i = 0; i < c.length; i++) {
            c[i] = a[i + mid + 1];
        }

        int i = 0, j = 0, k = left;

        while (i < b.length && j < c.length) {
            sortCount++;
            if (b[i] <= c[j]) {
                a[k++] = b[i++];
            } else {
                a[k++] = c[j++];
            }
        }

        while (i < b.length) {
            a[k++] = b[i++];
        }

        while (j < c.length) {
            a[k++] = c[j++];
        }

    }

    static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Enter the no of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10000);
        }

        mergeSort(a, 0, n - 1);

        System.out.println("Sorted Elements are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.println("No of basic operations for merge sort: " + sortCount);

        sc.close();
    }
}
