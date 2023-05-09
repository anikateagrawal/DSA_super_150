package dp_assignment;

/*
You are provided an integers N. You need to count all possible distinct binary strings of length N such that there are no consecutive 1’s.

Input Format
First line contains integer t which is number of test case. For each test case, it contains an integer n which is the the length of Binary String.

Constraints
1<=t<=100 1<=n<=90

Output Format
Print the number of all possible binary strings.

Sample Input
2
2
3
Sample Output
3
5
Explanation
1st test case : 00, 01, 10 2nd test case : 000, 001, 010, 100, 101
 */
import java.util.*;
public class Count_Number_of_Binary_Strings {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Long dp[]=new Long[n+1];
            System.out.println(fun(n,0,dp));
        }
    }
    static long fun(int n,int i,Long dp[]){
        if(i>=n)return 1L;
        if(dp[i]!=null)return dp[i];
        return dp[i]=fun(n,i+2,dp)+fun(n,i+1,dp);
    }
}
