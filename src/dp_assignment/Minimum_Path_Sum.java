package dp_assignment;

/*
Josh is stuck in a m*n grid. He has to travel from top left to bottom right.For every cell to pass, there is a specific amount of money josh has to pay. Your task is to find out minimum amount of money josh has to pay to reach bottom right.

Input Format
First line contains two space separated integers m and n i.e number of rows and columns of grid. m lines follow each containing n integers, denoting the cost of which josh has to pay to pass through that cell.

Constraints
None

Output Format
A single integer denoting minimum cost josh has to pay.

Sample Input
3 3
1 3 1
1 5 1
4 2 1
Sample Output
7
Explanation
Josh will take 1→3→1→1→1 path to minimize the amount he has to pay
 */
import java.util.*;
public class Minimum_Path_Sum {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j==0){
                    dp[i][j]=sc.nextInt();
                }
                else if(i==0){
                    dp[i][j]=sc.nextInt()+dp[i][j-1];
                }
                else if(j==0){
                    dp[i][j]=sc.nextInt()+dp[i-1][j];
                }
                else dp[i][j]=sc.nextInt()+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
