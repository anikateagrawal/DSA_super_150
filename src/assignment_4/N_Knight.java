package assignment_4;

import java.util.Scanner;
/*
Take as input N, the size of a chess board. We are asked to place N number of Knights in it, so that no knight can kill other.

a. Write a recursive function which returns the count of different distinct ways the knights can be placed across the board. Print the value returned.

b.Write a recursive function which prints all valid configurations (void is the return type for function).

Input Format
Enter the size of the chessboard N

Constraints
None

Output Format
Display the number of ways a knight can be placed and print all the possible arrangements in a space separated manner

Sample Input
2
Sample Output
{0-0} {0-1}  {0-0} {1-0}  {0-0} {1-1}  {0-1} {1-0}  {0-1} {1-1}  {1-0} {1-1}
6
 */
public class N_Knight {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean[][] board=new boolean[n][n];
        System.out.println("\n"+N_Queen(board,n,0,0));
    }
    static int N_Queen(boolean [][]board,int tq,int row,int cc){
        if(tq==0){
            display(board);
            return 1;
        }
        int c=0;
        int k=cc;
        for(int i=row;i<board.length;i++){
            if(i!=row)k=0;
            for (int col = k; col < board.length; col++) {
                if (isSafe(board,i,col)==true){
                    board[i][col]=true;
                    c+=N_Queen(board,tq-1,i,col+1);
                    board[i][col]=false;
                }
            }
        }
        return c;
    }
    static  void display(boolean [][]b){
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j <b[0].length ; j++) {
                if(b[i][j])
                    System.out.print("{"+i+"-"+j+"} ");
            }
        }
        System.out.print(" ");
    }
    static boolean isSafe(boolean [][]b,int row,int col){
        if(row>0 && col>1 && b[row-1][col-2])return false;
        if(row>0 && col+2<b.length && b[row-1][col+2])return false;
        if(row>1 && col>0 && b[row-2][col-1])return false;
        if(row>1 && col+1<b.length && b[row-2][col+1])return false;
        return true;
    }
}
