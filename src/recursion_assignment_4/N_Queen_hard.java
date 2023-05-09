package recursion_assignment_4;

import java.util.Scanner;

/*
You are given an empty chess board of size N*N. Find the number of ways to place N queens on the board, such that no two queens can kill each other in one move. A queen can move vertically, horizontally and diagonally.

Input Format
A single integer N, denoting the size of chess board.

Constraints
1 ≤ N < 15

Output Format
A single integer denoting the count of solutions.

Sample Input
4
Sample Output
2
 */
public class N_Queen_hard {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean[][] board=new boolean[n][n];
        System.out.println("\n"+N_Queen(board,n,0));
    }
    static int N_Queen(boolean [][]board,int tq,int row){
        if(tq==0){
            // display(board);
            return 1;
        }
        int c=0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board,row,col)==true){
                board[row][col]=true;
                c+=N_Queen(board,tq-1,row+1);
                board[row][col]=false;
            }
        }
        return c;
    }
    static boolean isSafe(boolean [][]b,int row,int col){
        for (int i = row; i >=0 ; i--) {
            if(b[i][col])return false;
        }
        for (int i = row,j=col; i >=0 && j>=0; i--,j--) {
            if(b[i][j])return false;
        }
        for (int i = row,j=col; i >=0 && j<b[0].length; i--,j++) {
            if(b[i][j])return false;
        }
        return true;
    }
}
