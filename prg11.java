import java.util.Scanner;

class prg11 {

    static int n;
    static String[] categories;
    static int[] w;
    static int d;
    static int[] x;
    static int count = 0;

    static void sum_of_subsets(int s, int k, int rem) {
        x[k] = 1;
        if (s + w[k] == d) {
            System.out.println("subset = " + (++count));
            for (int i = 0; i < n; i++) {
                if (x[i] == 1) {
                    System.out.println(categories[i] + " : " + w[i]);
                }
            }
            System.out.println();
        }

        if (k + 1 < n && s + w[k] + w[k + 1] <= d) {
            sum_of_subsets(s + w[k], k + 1, rem - w[k]);
        }
        if (k + 1 < n && s + rem - w[k] >= d && s + w[k + 1] <= d) {
            x[k] = 0;
            sum_of_subsets(s, k + 1, rem - w[k]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the no of categories: ");
        n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the category names followed by their fixed budgets(in increasing order of budget): ");
        categories = new String[n];
        w = new int[n];
        x = new int[n];
        int rem = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Category " + (i + 1) + " name: ");
            categories[i] = sc.nextLine();
            System.out.print("Category " + (i + 1) + " budget: ");
            w[i] = sc.nextInt();
            sc.nextLine();
            rem += w[i];
        }

        System.out.println("Enter the budget to host the event: ");
        d = sc.nextInt();
        System.out.println("\n================================\n");

        sum_of_subsets(0, 0, rem);

        if (count == 0) {
            System.out.println("No subset found\n");
        }

        sc.close();
    }
}
