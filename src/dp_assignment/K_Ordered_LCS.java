package dp_assignment;

/*
Any programmer worth his salt would be familiar with the famous Longest Common Subsequence problem. Mancunian was asked to solve the same by an incompetent programmer. As expected, he solved it in a flash. To complicate matters, a twist was introduced in the problem.

In addition to the two sequences, an additional parameter k was introduced. A k-ordered LCS is defined to be the LCS of two sequences if you are allowed to change atmost k elements in the first sequence to any value you wish to. Can you help Mancunian solve this version of the classical problem?

Input Format
The first line contains three integers N, M and k, denoting the lengths of the first and second sequences and the value of the provided parameter respectively. The second line contains N integers denoting the elements of the first sequence. The third line contains M integers denoting the elements of the second sequence.

Constraints
1 <= N, M <= 2000
1 <= k <= 5
1 <= element in any sequence <= 109

Output Format
Print the answer in a new line.

Sample Input
5 5 1
1 2 3 4 5
5 3 1 4 2
Sample Output
3
 */
import java.util.*;
public class K_Ordered_LCS {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[m];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        for(int i=0;i<m;i++)b[i]=sc.nextInt();
        Integer dp[][][]=new Integer[n][m][k+1];
        System.out.println(lcs(a,b,0,0,k,dp));
    }
    static int lcs(int a[],int b[],int i,int j,int k,Integer dp[][][]){
        if(i==a.length||j==b.length)return 0;
        if(dp[i][j][k]!=null)return dp[i][j][k];
        int ans=0;
        if(a[i]==b[j]){
            ans=1+lcs(a,b,i+1,j+1,k,dp);
        }
        else{
            ans=lcs(a,b,i+1,j,k,dp);
            ans=Math.max(lcs(a,b,i,j+1,k,dp),ans);
            if(k>0){
                ans=Math.max(ans,1+lcs(a,b,i+1,j+1,k-1,dp));
            }
        }
        return dp[i][j][k]=ans;
    }
}
