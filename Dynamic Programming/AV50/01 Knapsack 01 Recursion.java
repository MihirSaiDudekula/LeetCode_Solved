import java.util.Scanner;

public class Knapsack {

    public static int knapsack(int[] wt, int[] val, int W, int n) {
        // Base case
        if (n == 0 || W == 0) {
            return 0;
        }

        // Choices
        if (wt[n - 1] <= W) 
        {
            return Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1),knapsack(wt, val, W, n - 1));
        } 
        else {
            return knapsack(wt, val, W, n - 1);
        }
    }

    class Solution{
    public int cutRod(int price[], int n) 
    {
        //code here
        if(n==0)
        {
            return 0;
        }
        if(n>0)
        {
            return Math.max(price[n - 1] + cutRod(price,, n),knapsack(wt, val, W, n - 1));
        }
    }
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

        int result = knapsack(wt, val, W, n);
        System.out.println("Maximum value in Knapsack = " + result);

        scanner.close();
    }
}
