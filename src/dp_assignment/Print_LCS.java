package dp_assignment;

/*
A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. For example, the sequence {A,B,D} is a subsequence of {A,B,C,D,E,F}, obtained after removal of elements C, E and F.

Given two strings A and B of size n and m respectively, you have to print the Longest Common Subsequence(LCS) of strings A and B, where LCS is the longest sequence present in both A and B.

Note: It is gauranteed that there is only one unique longest common subsequence

Input Format
Two strings A and B.

Constraints
1 <= n,m <= 10^3

Output Format
Output the LCS of A and B.

Sample Input
abc
acd
Sample Output
ac
 */
import java.util.*;
public class Print_LCS {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        int dp[][]=new int[a.length()+1][b.length()+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        String ans="";
        int i=dp.length-1,j=dp[0].length-1;
        while(i>0&&j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                ans=a.charAt(i-1)+ans;
                i--;
                j--;
            }
            else if(dp[i][j]==dp[i][j-1]){
                j--;
            }
            else i--;
        }
        System.out.println(ans);
    }
}

