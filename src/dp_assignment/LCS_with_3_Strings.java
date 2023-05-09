package dp_assignment;

/*
Given 3 strings ,the task is to find the longest common sub-sequence in all three given sequences.

Input Format
First line contains first string . Second line contains second string. Third line contains the third string.

Constraints
The length of all strings is |s|< 200

Output Format
Output an integer denoting the length of longest common subsequence of above three strings.

Sample Input
GHQWNV
SJNSDGH
CPGMAH
Sample Output
2
Explanation
"GH" is the longest common subsequence
 */
import java.util.*;
public class LCS_with_3_Strings{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        String c=sc.next();
        Integer dp[][][]=new Integer[a.length()][b.length()][c.length()];
        System.out.println(lcs(a,b,c,0,0,0,dp));
    }
    static int lcs(String a,String b,String c,int i,int j,int k,Integer dp[][][]){
        if(i==a.length()||j==b.length()||k==c.length())return 0;
        if(dp[i][j][k]!=null)return dp[i][j][k];
        int ans=0;
        if(a.charAt(i)==b.charAt(j)&&a.charAt(i)==c.charAt(k)){
            ans=1+lcs(a,b,c,i+1,j+1,k+1,dp);
        }
        else{
            ans=lcs(a,b,c,i,j,k+1,dp);
            ans=Math.max(ans,lcs(a,b,c,i,j+1,k,dp));
            ans=Math.max(ans,lcs(a,b,c,i+1,j,k,dp));
        }
        return dp[i][j][k]=ans;
    }
}
