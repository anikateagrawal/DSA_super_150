package dp_assignment;

/*
You are packing for a vacation on the sea side and you are going to carry only one bag with capacity S (1 <= S <= 1000). You also have N (1<= N <= 1000) items that you might want to take with you to the sea side. Unfortunately you can not fit all of them in the knapsack so you will have to choose. For each item you are given its size and its value. You want to maximize the total value of all the items you are going to bring. What is this maximum total value?

Input Format
On the first line you are given N and S.
Second line contains N space separated integer where ith integer denotes the size of ith item. Third line contains N space seperated integers where ith integer denotes the value of ith item.

Constraints
1 <= S,N <= 1000

Output Format
Output a single integer showing the maximum value that can be obtained by optimally choosing the items.

Sample Input
5 4
1 2 3 2 2
8 4 0 5 3
Sample Output
13
Explanation
Total capacity = 4.
Pick size 1 with value 8 and size 2 with value 5.
 */
import java.util.*;
public class _0_1_Knapsack {
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
                if(a[i-1][1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-a[i-1][1]]+a[i-1][0]);
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
}
