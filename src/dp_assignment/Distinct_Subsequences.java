package dp_assignment;

/*
Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, “ACE” is a subsequence of “ABCDE” while “AEC” is not).

Input Format
Input number of test cases The first argument of input contains a string, A. The second argument of input contains a string, B.

Constraints
1<=T<=100
1 <= length(A), length(B) <= 100

Output Format
Return an integer representing the answer as described in the problem statement.

Sample Input
1
rabbbit
rabbit
Sample Output
3
Explanation
These are the possible removals of characters:
    => A = "ra_bbit"
    => A = "rab_bit"
    => A = "rabb_it"
 */
import java.util.*;
public class Distinct_Subsequences {
    public static void main(String[] args) {
        Scanner cin =  new Scanner(System.in);

        int test = cin.nextInt();
        cin.nextLine();

        for(int i=0;i<test;i++){
            String s = cin.nextLine();
            String t = cin.nextLine();

            System.out.println(distinctSubsequence(s, t));
        }
    }


    public static long distinctSubsequence(String s, String t) {
// Write Code here
        long dp[][]=new long[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++)dp[i][0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                dp[i][j]+=dp[i-1][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];

    }

}
