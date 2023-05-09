package dp_assignment;

/*
You've heard of 0-1 knapsack. Below is the problem statement for the same.

Given weights and values of n items, put these items in a knapsack of capacity cap to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. Also given an integer cap which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to cap. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
There is a little twist for 0-N knapsack. You can pick an element more than once. Now you have to find maximum value multi subset of val[] such that sum of the weights of this subset is smaller than or equal to cap.

Note: Maximum value subset means the sunset with maximum sum of all the values in subset.

Input Format
The first line contains two integers, representing n(size of val[]) and cap respectively. The subsequent line contains n integers representing the wt[] array. The next line, again, contains n integers representing the val[] array.

Constraints
1 <= n,cap <= 1000 1 <= wt[i] <= cap 1 <= val[i] <= 100000

Output Format
Print a single integer, the answer to the problem.

Sample Input
5 11
3 2 4 5 1
4 3 5 6 1
Sample Output
16
Explanation
We take second item 4 times and fifth item one time to make the total values 16.
 */
import java.util.*;
public class _0_N_Knapsack {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int capacity=sc.nextInt();
        int a[][]=new int[n][2];
        for(int i=0;i<n;i++)a[i][1]=sc.nextInt();
        for(int i=0;i<n;i++)a[i][0]=sc.nextInt();
        Arrays.sort(a,(i1,i2)->i1[1]-i2[1]);
        int dp[][]=new int[a.length+1][capacity+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                for(int k=1;k*a[i-1][1]<=j;k++){
                    if(k*a[i-1][1]<=j){
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*a[i-1][1]]+k*a[i-1][0]);
                    }
                    else {
                        dp[i][j]=dp[i-1][j];
                    }
                }

            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
}