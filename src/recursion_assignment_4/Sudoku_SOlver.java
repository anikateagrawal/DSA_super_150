package recursion_assignment_4;

import java.util.Scanner;
/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.<br.

Input Format
First line contains a single integer N. Next N lines contains N integers each, where jth integer int ith line denotes the value at ith row and jth column in sudoku grid. This value is 0, if the cell is empty.

Constraints
N=9
At least one solution does exists for input matrix.

Output Format
Print N lines containing N integers each, where jth integer int ith line denotes the value at ith row and jth column in sudoku grid, such that all cells are filled.

Sample Input
9
5 3 0 0 7 0 0 0 0
6 0 0 1 9 5 0 0 0
0 9 8 0 0 0 0 6 0
8 0 0 0 6 0 0 0 3
4 0 0 8 0 3 0 0 1
7 0 0 0 2 0 0 0 6
0 6 0 0 0 0 2 8 0
0 0 0 4 1 9 0 0 5
0 0 0 0 8 0 0 7 9
Sample Output
5 3 4 6 7 8 9 1 2
6 7 2 1 9 5 3 4 8
1 9 8 3 4 2 5 6 7
8 5 9 7 6 1 4 2 3
4 2 6 8 5 3 7 9 1
7 1 3 9 2 4 8 5 6
9 6 1 5 3 7 2 8 4
2 8 7 4 1 9 6 3 5
3 4 5 2 8 6 1 7 9
 */
public class Sudoku_SOlver {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                s[i][j]=sc.nextInt();
            }
        }
        sudoku(s,0,0);
    }
    static void sudoku(int [][]s,int row,int col){
        if(row==8 && col==9){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(s[i][j]+" ");
                }System.out.println();
            }
            return;
        }
        if(col==9){
            col=0;
            row+=1;
        }
        if(s[row][col]!=0){
            sudoku(s,row,col+1);
        }
        else {
            for(int k=1;k<=9;k++){
                if(isSafe(s,row,col,k)){
                    s[row][col]=k;
                    sudoku(s,row,col+1);
                    s[row][col]=0;
                }
            }
        }
    }
    static boolean isSafe(int [][]s,int row,int col,int k){
        for(int i=0;i<9;i++){
            if(s[i][col]==k)return false;
            if(s[row][i]==k)return false;
        }
        int i=row - row%3;
        int j=col - col % 3;
        for (int r = i;r <i+3; r++)
        {
            for (int d =j;d < j + 3; d++)
            {
                if (s[r][d] == k)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
