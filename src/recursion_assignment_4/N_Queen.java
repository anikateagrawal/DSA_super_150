package recursion_assignment_4;

import java.util.Scanner;
/*
Take as input N, the size of a chess board. We are asked to place N number of queens in it, so that no queen can kill other.

a. Write a recursive function which returns the count of different distinct ways the queens can be placed across the board. Print the value returned.

b. Write a recursive function which prints all valid configurations (void is the return type for function).

Input Format
Enter the number N(Size of the chessboard)

Constraints
None

Output Format
Display the number of possible ways of arranging N queens and print all the possible arrangements in a space separated manner

Sample Input
4
Sample Output
{1-2} {2-4} {3-1} {4-3}  {1-3} {2-1} {3-4} {4-2}
2
 */
public class N_Queen {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean[][] board=new boolean[n][n];
        System.out.println("\n"+N_Queen(board,n,0));
    }
    static int N_Queen(boolean [][]board,int tq,int row){
        if(tq==0){
            display(board);
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
    static  void display(boolean [][]b){
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j <b[0].length ; j++) {
                if(b[i][j])
                    System.out.print("{"+(i+1)+"-"+(j+1)+"} ");
            }
        }
        System.out.print(" ");
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
