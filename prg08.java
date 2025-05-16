import java.util.Arrays;
import java.util.Scanner;

public class prg08 {

    static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    static void dijkstra(int[][] cost, int n, int source) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        int max = Integer.MAX_VALUE;

        Arrays.fill(dist, max);
        dist[source] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && cost[u][v] < max && dist[u] < max && dist[u] + cost[u][v] < dist[v]) {
                    dist[v] = dist[u] + cost[u][v];
                }
            }
        }

        System.out.println("The Shortest Travel time");
        for (int i = 0; i < n; i++) {
            System.out.println("from " + source + " city to " + i + " city is " + dist[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the no of cities: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];
        System.out.println("Enter the travel time in hours in between every two cities: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
                if (cost[i][j] == 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        System.out.println("Enter the source city: ");
        int source = sc.nextInt();

        dijkstra(cost, n, source);

        sc.close();
    }
}