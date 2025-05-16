import java.util.Scanner;

class prg9 {
    static void floydWarshall(int[][] d) {
        int n = d.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the no. of stations: ");
        int n = sc.nextInt();

        int[][] a = new int[n][n];
        System.out.println("Enter the travel time between subway lines: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (i != j && a[i][j] == 0) {
                    a[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        floydWarshall(a);

        System.out.println("\nShortest travel time between subway lines: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        sc.close();
    }
}
