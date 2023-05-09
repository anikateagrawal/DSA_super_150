package stack_queue_assignment_5;

import java.util.Scanner;
/*
A knight is a piece used in the game of chess. The chessboard itself is square array of cells. Each time a knight moves, its resulting position is two rows and one column, or two columns and one row away from its starting position. Thus a knight starting on row r, column c – which we’ll denote as (r,c) – can move to any of the squares (r-2,c-1), (r-2,c+1), (r-1,c-2), (r-1,c+2), (r+1,c-2), (r+1,c+2), (r+2,c-1), or (r+2,c+1). Of course, the knight may not move to any square that is not on the board.

Suppose the chessboard is not square, but instead has rows with variable numbers of columns, and with each row offset zero or more columns to the right of the row above it. The figure to the left illustrates one possible configuration. How many of the squares in such a modified chessboard can a knight, starting in the upper left square (marked with an asterisk), not reach in any number of moves without resting in any square more than once? Minimize this number.

Imgur

If necessary, the knight is permitted to pass over regions that are outside the borders of the modified chessboard, but as usual, it can only move to squares that are within the borders of the board.

Input Format
First line contains an integer n, representing the side of square of chess board. The next n line contains n integers separated by single spaces in which jjth integer is 1 if that cell(i,j) is part of chessboard and 0 otherwise.

Constraints
The maximum dimensions of the board will be 10 rows and 10 columns. That is, any modified chessboard specified by the input will fit completely on a 10 row, 10 column board.

Output Format
Print the minimum number of squares that the knight can not reach.

Sample Input
3
1 1 1
1 1 1
1 1 1
Sample Output
1
 */
public class FunkyChessBoard {
    static int min=Integer.MAX_VALUE;
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int b[][]=new int[n][n];
        boolean bo[][]=new boolean[n][n];
        bo[0][0]=true;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                b[i][j]=sc.nextInt();
                if(b[i][j]==1)count++;
            }
        }
        travel(b,0,0,bo,count);
        System.out.println(min);
    }
    static void travel(int b[][],int r,int c,boolean bo[][],int count){
        if(r<0||r>=b.length||c<0||c>=b.length||b[r][c]==0){
            return;
        }
        bo[r][c]=true;
        b[r][c]=0;
        travel(b,r-2,c-1,bo,count);
        travel(b,r-2,c+1,bo,count);
        travel(b,r-1,c-2,bo,count);
        travel(b,r-1,c+2,bo,count);
        travel(b,r+1,c-2,bo,count);
        travel(b,r+1,c+2,bo,count);
        travel(b,r+2,c-1,bo,count);
        travel(b,r+2,c+1,bo,count);
        update(bo,count);
        bo[r][c]=false;
        b[r][c]=1;
    }
    static void update(boolean bo[][],int count){
        int c=0;
        for(int i=0;i<bo.length;i++){
            for(int j=0;j<bo.length;j++){
                if(bo[i][j]){
                    c++;
                }
            }
        }
        min=Math.min(min,count-c);
    }
}
