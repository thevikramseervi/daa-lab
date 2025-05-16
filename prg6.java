import java.util.Scanner;

public class prg6 {
    static int n;
    static int m;
    static int[] w;
    static int[] p;
    static int[] items;

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void sort() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if ((double) p[j + 1] / w[j + 1] > (double) p[j] / w[j]) {
                    swap(p, j, j + 1);
                    swap(w, j, j + 1);
                    swap(items, j, j + 1);
                }
            }
        }
    }

    static void knapsack() {
        sort();
        double[] x = new double[n];
        double u = m;

        int i;
        for (i = 0; i < n; i++) {
            if (w[i] > u) {
                break;
            }
            x[i] = 1.0;
            u -= w[i];
        }

        if (i < n) {
            x[i] = (double) u / w[i];
        }

        double totalProfit = 0;

        System.out.println("items included are: ");
        for (int j = 0; j < n; j++) {
            if (x[j] > 0.0) {
                System.out.println("(item, fraction) = (" + (items[j] + 1) + ", " + x[j] + ")");
                totalProfit += x[j] * p[j];
            }
        }

        System.out.println("Knapsack profit = " + totalProfit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of items: ");
        n = sc.nextInt();

        w = new int[n];
        p = new int[n];
        items = new int[n];

        System.out.println("Enter the weights of the items: ");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        System.out.println("Enter the profits of the items: ");
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        System.out.println("Enter the capacity of the knapsack: ");
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            items[i] = i;
        }

        knapsack();
        sc.close();
    }
}
