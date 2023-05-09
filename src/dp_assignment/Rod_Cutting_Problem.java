package dp_assignment;

/*
Given a rod of length n and a list of prices of rods of length of i, where 1<=i<=n, find the optimal way to cut the rod into smaller rods to maximize profit.The rod of length i has a value price[i-1].

Input Format
An integer N representing length of prices array. Prices array. An integer n representing rod length

Constraints
1<=n<=1000
1<=prices[i]<=1000

Output Format
An integer representing maximum profit

Sample Input
8
1 5 8 9 10 17 17 20
4
Sample Output
10
Explanation
Best: Cut the rod into two pieces of length 2 each to gain revenue of 5 + 5 = 10

Cut Profit 4 9 1, 3 (1 + 8) = 9 2, 2 (5 + 5) = 10 3, 1 (8 + 1) = 9 1, 1, 2 (1 + 1 + 5) = 7 1, 2, 1 (1 + 5 + 1) = 7 2, 1, 1 (5 + 1 + 1) = 7 1, 1, 1, 1 (1 + 1 + 1 + 1) = 4
 */
import java.util.*;
public class Rod_Cutting_Problem {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int k=sc.nextInt();
        Integer dp[]=new Integer[k+1];
        System.out.println(fun(a,k,dp));
    }
    static int fun(int a[],int k,Integer dp[]){
        if(k==0)return 0;
        if(k<0)return Integer.MIN_VALUE;
        if(dp[k]!=null)return dp[k];
        int ans=0;
        for(int i=1;i<=a.length;i++){
            ans=Math.max(ans,a[i-1]+fun(a,k-i,dp));
        }
        return dp[k]=ans;
    }
}
