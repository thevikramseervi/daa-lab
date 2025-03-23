import java.util.Scanner;

public class prg5 {

    static void prim(int[][] cost, int n, int source) {
        int[] tvertex = new int[n];
        tvertex[source] = 1;

        int a = 0, b = 0, min, mincost = 0, ne = 0;

        while (ne < n - 1) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (tvertex[i] == 1) {
                    for (int j = 0; j < n; j++) {
                        if (tvertex[j] == 0 && cost[i][j] < min) {
                            min = cost[i][j];
                            a = i;
                            b = j;
                        }
                    }
                }
            }
            tvertex[b] = 1;
            mincost += min;
            ne++;
            System.out.println("Edge(" + a + ", " + b + ") -> cost = " + min);
        }
        System.out.println("Mincost: " + mincost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the no of vertices: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];

        System.out.println("Enter the cost matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
                if (cost[i][j] == 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        System.out.println("Enter the source vertex: ");
        int source = sc.nextInt();

        prim(cost, n, source);
        sc.close();
    }
}
