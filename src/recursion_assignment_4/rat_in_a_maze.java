/*
You are given an N*M grid. Each cell (i,j) in the grid is either blocked, or empty. The rat can move from position (i,j), down or right on the grid.
Initially rat is on the position (1,1). It wants to reach position (N,M). Find the rightmost path through which, rat can reach this position. A path is rightmost, if the rat is at position (i,j), it will always move to (i,j+1), if there exists a path from (i,j+1) to (N,M).

Input Format
First line contains 2 integers, N and M, denoting the rows and columns in the grid. Next N line contains. M characters each. An 'X' in position (i,j) denotes that the cell is blocked and ans 'O' denotes that the cell is empty.

Constraints
1<=N,M<=1000 GRID(i,j)='X' or 'O'

Output Format
If a solution exists: Print N lines, containing M integers each. A 1 at a position (i,j) denotes that the (i,j)th cell is covered in the path and a 0 denotes that the cell is not covered in the path.
If solution doesn't exist, just print "-1".

Sample Input
5 4
OXOO
OOOX
OOXO
XOOO
XXOO
Sample Output
1 0 0 0
1 1 0 0
0 1 0 0
0 1 1 1
0 0 0 1
 */
package recursion_assignment_4;

import java.util.Scanner;

public class rat_in_a_maze {
    static int f;
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        char a[][]=new char[m][n];
        for(int i=0;i<m;i++){
            String s=sc.next();
            for(int j=0;j<n;j++){
                a[i][j]=s.charAt(j);
            }
        }
        rat(a,new int[m][n],0,0);
        if(f==0) System.out.println("-1");
    }
    static void rat(char [][]a,int m[][],int i,int j){
        if(i<0||i>=a.length||j<0||j>=a[0].length||a[i][j]=='X'){
            return;
        }
        m[i][j]=1;
        if(i==a.length-1&& j==a[0].length-1)
        {
            f=1;
            for (int k = 0; k < m.length; k++) {
                for (int l = 0; l < m[0].length; l++) {
                    System.out.print(m[k][l]+" ");
                }
                System.out.println();
            }
            return;
        }
        a[i][j]='X';
        rat(a,m,i,j+1);
        if(f==0)
            rat(a,m,i+1,j);
        if(f==0)
            rat(a,m,i-1,j);
        if(f==0)
            rat(a,m,i,j-1);
        m[i][j]=0;
        a[i][j]='O';
    }
}
