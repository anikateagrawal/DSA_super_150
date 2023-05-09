package dp_assignment;

/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, In how many ways can we make the change? The order of coins doesn’t matter.

Input Format
First line of input contain two space separated integers N and M. Second line of input contains M space separated integers - value of coins.

Constraints
1<=N<=250 1<=m<=50 1 <= Si <= 50

Output Format
Output a single integer denoting the number of ways to make the given change using given coin denominations.

Sample Input
10 4
2 5 3 6
Sample Output
5
Explanation
2 2 2 2 2
2 2 3 3
2 2 6
2 3 5
5 5

Total 5 ways
 */
import java.util.*;
public class Coin_Change {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int n=sc.nextInt();
        int coins[]=new int[n];
        for(int i=0;i<n;i++)coins[i]=sc.nextInt();
        System.out.println(change(a,coins));

    }
    public static int change(int amount, int[] coins) {
        int dp[][]=new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++)dp[i][0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int inc=0,exc=0;
                if(coins[i-1]<=j){
                    inc=dp[i][j-coins[i-1]];
                }
                exc=dp[i-1][j];
                dp[i][j]=inc+exc;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}

