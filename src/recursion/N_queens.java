package recursion;

import java.util.Scanner;

public class N_queens {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean[][] board=new boolean[n][n];
        N_Queen(board,n,0);
    }
    static void N_Queen(boolean [][]board,int tq,int row){
        if(tq==0){
            display(board);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board,row,col)==true){
                board[row][col]=true;
                N_Queen(board,tq-1,row+1);
                board[row][col]=false;
            }
        }
    }
    static  void display(boolean [][]b){
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j <b[0].length ; j++) {
                if(b[i][j])
                System.out.print("Q\t");
                else System.out.print(".\t");
            }
            System.out.println();
        }
        System.out.println();
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
