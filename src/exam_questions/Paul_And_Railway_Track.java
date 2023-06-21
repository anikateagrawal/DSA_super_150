package exam_questions;

/*
A railway track is made with the help of two horizontal rails and railway sleepers as seen in figure.

Drag Racing

There are two horizontal rails X and Y. On railway line X, N numbers are written and on railway line Y, M numbers are written

Paul works as an engineer in the railway department. Paul was tasked to join these two rails with sleepers to complete the railway track.

But there is a condition to join the rails with sleepers. The sleepers will be put on the position i and j such that -

The number written on X at ith position i.e X[i] should be equal to the number written on Y at jth position i.e Y[j].

The sleepers should not intersect or cross each other at all.

A sleeper X[i] can only be combined with a single Y[j].

Return the maximum number of sleepers that Paul has to connect to complete the railway track.

Input Format
First line contains two integers N and M i.e the count of numbers written on each rail X and Y. Second line contains N numbers that are written on rail X. Third line contains M numbers that are written on rail Y.

Constraints
1 <= N <= 500
1 <= M <= 500

Output Format
A single integer, the maximum number of sleepers that Paul has to connect to complete the railway track.

Sample Input
6 5
1 3 7 1 7 5
1 9 2 5 1
Sample Output
2
Explanation
We can combine X[0] and Y[0], then we can combine X[3] and Y[4].

However, if we will also try to connect X[5] and Y[3] the will intersect with the connection X[3] and Y[4], thus we can choose only one out of these two.

Thus the answer is 2.
 */
import java.util.*;
public class Paul_And_Railway_Track {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[m];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int j=0;j<m;j++){
            b[j]=sc.nextInt();
        }
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1]==b[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
