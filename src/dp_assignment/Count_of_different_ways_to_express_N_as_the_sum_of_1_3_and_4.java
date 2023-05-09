package dp_assignment;

/*
Given N, count the number of ways to express N as sum of 1, 3 and 4.

Input Format
First line contains the size of the array. Next line contains array elements.

Constraints
1 <= N <= 108

Output Format
Print the integer answer.

Sample Input
4
Sample Output
4
Explanation
1+1+1+1
1+3
3+1
4
 */

import java.util.*;
public class Count_of_different_ways_to_express_N_as_the_sum_of_1_3_and_4{
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int coins[]=new int[3];
        Long dp[]=new Long[n+1];
        coins[0]=1;coins[1]=3;coins[2]=4;
        System.out.println(change(n,coins,dp));
    }
    public static long change(int amount, int[] coins,Long dp[]) {
        if(amount==0)return 1;
        if(dp[amount]!=null)return dp[amount];
        long ans=0;
        for(int i=0;i<3;i++){
            if(amount-coins[i]>=0){
                ans+=change(amount-coins[i],coins,dp);
            }
        }
        return dp[amount]=ans;
    }
}

