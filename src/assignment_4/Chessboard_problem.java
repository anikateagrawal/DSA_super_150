package assignment_4;

import java.util.Scanner;
/*
Take as input N, a number. N represents the size of a chess board. We’ve a piece standing in top-left corner and it must reach the bottom-right corner. The piece moves as follows –

a. In any cell, the piece moves like a knight. But out of the possible 8 moves for a knight, only the positive ones are valid i.e. both row and column must increase in a move.

b. On the walls (4 possible walls), the piece can move like a rook as well (in addition of knight moves). But, only the positive moves are allowed i.e. as a rook, piece can move any number of steps horizontally or vertically but in a manner, such that row or column must increase.

c. On the diagonals (2 possible diagonals), the piece can move like a bishop as well (in addition to the knight and possibly rook moves). But, only the positive moves are allowed i.e. as a bishop, piece can move in a way such that row and column must increase.

You are supposed to write the following functions

a. Write a recursive function which returns the count of different distinct ways this board can be crossed. Print the value returned.

b. Write a recursive function which prints all valid paths (void is the return type for function).

Input Format
Enter the size of the chessboard N

Constraints
None

Output Format
Display the total number of valid paths and print all the valid paths in a space separated manner

Sample Input
3
Sample Output
{0-0}K{2-1}R{2-2} {0-0}K{1-2}R{2-2} {0-0}R{0-1}K{2-2} {0-0}R{0-1}R{0-2}R{1-2}R{2-2} {0-0}R{0-1}R{0-2}R{2-2} {0-0}R{0-1}R{1-1}B{2-2} {0-0}R{0-1}R{2-1}R{2-2} {0-0}R{0-2}R{1-2}R{2-2} {0-0}R{0-2}R{2-2} {0-0}R{1-0}K{2-2} {0-0}R{1-0}R{1-1}B{2-2} {0-0}R{1-0}R{1-2}R{2-2} {0-0}R{1-0}R{2-0}R{2-1}R{2-2} {0-0}R{1-0}R{2-0}R{2-2} {0-0}R{2-0}R{2-1}R{2-2} {0-0}R{2-0}R{2-2} {0-0}B{1-1}B{2-2} {0-0}B{2-2}
18
 */
public class Chessboard_problem {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=chess(n,0,0,"{0-0}");
        System.out.println("\n"+c);
    }
    static int chess(int n,int i,int j,String ans){
        if(i==n-1 && j==n-1){
            System.out.print(ans+" ");
            return 1;
        }
        if(i>=n||j>=n)return 0;
        int c=0;
        c+=chess(n,i+2,j+1,ans+"K{"+(i+2)+"-"+(j+1)+"}");
        c+=chess(n,i+1,j+2,ans+"K{"+(i+1)+"-"+(j+2)+"}");
        if(i==0||i==n-1||j==0||j==n-1){
            for(int k=j+1;k<n;k++){
                c+=chess(n,i,k,ans+"R{"+i+"-"+k+"}");
            }
            for(int k=i+1;k<n;k++){
                c+=chess(n,k,j,ans+"R{"+k+"-"+j+"}");
            }
        }
        if(i==j||i+j==n-1){
            for(int k=1;k<n-i;k++){
                c+=chess(n,i+k,j+k,ans+"B{"+(i+k)+"-"+(j+k)+"}");
            }
        }
        return c;
    }
}
