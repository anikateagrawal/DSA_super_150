package dynamic_programming;

import java.util.Scanner;

public class fibo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fibo(n));
        int dp[]=new int[n+1];
        System.out.println(fibo2(n,dp));
        //bottom up dp
        int dp2[]=new int[n+1];
        dp2[1]=1;
        for (int i = 2; i <= n; i++) {
            dp2[i]=dp2[i-1]+dp2[i-2];
        }
        System.out.println(dp2[n]);
    }
    //recursive
    static int fibo(int n){
        if(n==0||n==1)return n;
        return fibo(n-1)+fibo(n-2);
    }
    //memoization top down dp
    static int fibo2(int n,int dp[]){
        if(n==0||n==1)return n;
        if(dp[n]!=0)return dp[n];
        dp[n]=fibo2(n-1,dp)+fibo2(n-2,dp);
        return dp[n];
    }
}
