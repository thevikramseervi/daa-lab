import java.util.Scanner;

class prg5 {
    static int n;
    static int[][] cost;
    static int[] indegree;

    static void calculate() {
        for (int i = 0; i < n; i++) {
            indegree[i] = 0;
            for (int j = 0; j < n; j++) {
                if (cost[j][i] == 1) {
                    indegree[i]++;
                }
            }
        }
    }

    static void sourceRemoval() {
        int[] removed = new int[n];
        calculate();
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (removed[j] == 0 && indegree[j] == 0) {
                    break;
                }
            }

            if (j == n) {
                System.out.println("Graph is cyclic. No solution");
                return;
            }

            System.out.print(j + " ");
            removed[j] = 1;
            for (int k = 0; k < n; k++) {
                if (cost[j][k] == 1) {
                    indegree[k]--;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices: ");
        n = sc.nextInt();

        cost = new int[n][n];
        indegree = new int[n];

        System.out.println("Enter adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        sourceRemoval();
        sc.close();
    }
}