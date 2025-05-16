import java.util.Scanner;

class prg10 {

    static void dpknapsack(int n, int[] w, int[] p, int m) {
        int[][] v = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    v[i][j] = 0;
                } else if (j < w[i]) {
                    v[i][j] = v[i - 1][j];
                } else {
                    v[i][j] = Math.max(v[i - 1][j], p[i] + v[i - 1][j - w[i]]);
                }
            }
        }

        System.out.println();
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int optimalProfit = v[n][m];
        System.out.println("Optimal Profit is: " + optimalProfit);

        System.out.println("Items Selected: ");
        while (n != 0 && m != 0) {
            if (v[n][m] != v[n - 1][m]) {
                System.out.print(n + " ");
                m -= w[n];
            }
            n--;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the no. of products: ");
        int n = sc.nextInt();

        int[] weights = new int[n + 1];
        int[] profits = new int[n + 1];

        System.out.println("Enter the weights of n products: ");
        for (int i = 1; i < n + 1; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.println("Enter the profits of n products: ");
        for (int i = 1; i < n + 1; i++) {
            profits[i] = sc.nextInt();
        }

        System.out.println("Enter the capacity of knapsack: ");
        int capacity = sc.nextInt();

        dpknapsack(n, weights, profits, capacity);

        sc.close();
    }
}
