package dp_assignment;

/*
Given a gold mine (M) of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down) that is from a given cell, the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. Your task is to find out maximum amount of gold which he can collect.

Input Format
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer n and m denoting the size of the matrix. Then in the next line are n*m space separated values of the matrix.

Constraints
1<=T<=100

1<=n,m<=20

1<=M[][]<=100

Output Format
For each test case in a new line print an integer denoting the max gold the miner could collect.

Sample Input
2
3 3
1 3 3 2 1 4 0 6 4
2 2
1 2 3 4
Sample Output
12
7
 */
import java.util.*;
public class GOLDMINE_PROBLEM  {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[][]=new int[m][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    a[j][i]=sc.nextInt();
                }
            }
            for(int i=1;i<m;i++){
                for(int j=0;j<n;j++){
                    if(n==1){
                        a[i][j]+=a[i-1][j];
                        continue;
                    }
                    if(j==0){
                        a[i][j]+=Math.max(a[i-1][j],a[i-1][j+1]);
                    }
                    else if(j==n-1){
                        a[i][j]+=Math.max(a[i-1][j],a[i-1][j-1]);
                    }
                    else{
                        a[i][j]+=Math.max(a[i-1][j-1],Math.max(a[i-1][j],a[i-1][j+1]));
                    }
                }
            }
            int min=a[m-1][0];
            for(int i=0;i<n;i++){
                min=Math.max(min,a[m-1][i]);
            }
            System.out.println(min);
        }
    }
}
