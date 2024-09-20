import java.util.Scanner;

public class KnapsackDP {

    private static final int D = 1000; // DP matrix dimension
    private static int[][] t = new int[D][D]; // DP matrix

    public static int knapsack(int[] wt, int[] val, int W, int n) {
        // Base case
        if (n == 0 || W == 0) {
            return 0;
        }

        // If already calculated
        if (t[n][W] != -1) {
            return t[n][W];
        }

        // Else calculate
        if (wt[n - 1] <= W) {
            t[n][W] = Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1),
                               knapsack(wt, val, W, n - 1));
        } else {
            t[n][W] = knapsack(wt, val, W, n - 1);
        }

        return t[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] val = new int[n];
        int[] wt = new int[n];

        System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Weight of item " + (i + 1) + ": ");
            wt[i] = scanner.nextInt();
        }

        System.out.println("Enter the values of the items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            val[i] = scanner.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int W = scanner.nextInt();

        // Matrix initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                t[i][j] = -1; // Initialize matrix with -1
            }
        }

        int result = knapsack(wt, val, W, n);
        System.out.println("Maximum value in Knapsack = " + result);

        scanner.close();
    }
}
