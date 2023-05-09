package dynamic_programming;

import java.util.Arrays;

public class knapsack_problem {
    public static void main(String[] args) {
        int a[][]={{1,2},{2,3},{5,4},{6,5}};
        Arrays.sort(a,(i1,i2)->i1[1]-i2[1]);
        int capacity=8;
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
        System.out.println("Max Profit= "+ dp[dp.length-1][dp[0].length-1]);
    }
}
