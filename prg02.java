import java.util.Scanner;
import java.util.Random;

class prg02 {
    static int sortCount = 0;

    static int partition(int[] a, int left, int right) {
        int p = a[left];
        int i = left - 1;
        int j = right + 1;

        // i will point to a value >= p
        // j will point to a value <= p

        while (true) {
            do {
                i++;
                sortCount++;
            } while (a[i] < p);

            do {
                j--;
                sortCount++;
            } while (a[j] > p);

            if (i >= j) {
                break;
            }

            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        return j;
    }

    static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int s = partition(a, left, right);
            quickSort(a, left, s);
            quickSort(a, s + 1, right);
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

        quickSort(a, 0, n - 1);

        System.out.println("Sorted elements are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.println("No of basic operations for quick sort: " + sortCount);
        sc.close();
    }
}