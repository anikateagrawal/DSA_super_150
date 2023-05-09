package dp_assignment;

/*
Piyush and Nimit are playing a coin game. They are given n coins with values x1, x2 …. xn where 'n' is always even. They take alternate terms. In each turn, a player picks either the first coin or the last coin from the row and removes it from the row. The value of coin is received by that player. Determine the maximum value that Piyush can win with if he moves first. Both the players play optimally.

Input Format
First line contains the number of coins 'n'.
Second line contains n space separated integers where ith index denotes the value of ith coin.

Constraints
1 < N <= 10000 , N is always even
0 <= Ai <= 1000000

Output Format
Print a single line with the maximum possible value that Piyush can win with.

Sample Input
4
1 2 3 4
Sample Output
6
Explanation
Piyush will pick the coin 4. Then Nimit can pick either 1 or 3. In both the cases Piyush picks coin 2 and wins with a total of 6.
 */
import java.util.*;
public class Optimal_Game_Strategy_II {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        Long dp[][]=new Long[n][n];
        System.out.println(fun(a,0,n-1,dp));
    }
    static long fun(int a[],int i,int j,Long dp[][]){
        if(i>j)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        long f=a[i]+Math.min(fun(a,i+2,j,dp),fun(a,i+1,j-1,dp));
        long l=a[j]+Math.min(fun(a,i+1,j-1,dp),fun(a,i,j-2,dp));
        return dp[i][j]=Math.max(f,l);
    }
}

