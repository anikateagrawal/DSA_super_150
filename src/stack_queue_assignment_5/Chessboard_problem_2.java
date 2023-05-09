package stack_queue_assignment_5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*
Take as input N, a number. N represents the size of a chess board. The cells in board are numbered. The top-left cell is numbered 1 and numbering increases from left to right and top to bottom. E.g. The following is the chessboard for a value of n=4.

1     2    3    4

5     6    7    8

9     10   11   12

13    14   15   16
Prime numbers act as mines and ports alternately i.e. first prime number is a mine while second is a port and so on. Piece can go over a mine but cannot stop on it. Piece can directly move from a port to the destination (but may not chose to).

We’ve a piece standing in top-left corner and it must reach the bottom-right corner. The piece moves as follows –

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
Display the total number of ways to cross the board and display all the possible paths in a space separated manner

Sample Input
3
Sample Output
{0-0}K{2-1}R{2-2} {0-0}K{1-2}R{2-2} {0-0}R{0-2}P{2-2} {0-0}R{0-2}R{1-2}R{2-2} {0-0}R{0-2}R{2-2} {0-0}R{1-0}K{2-2} {0-0}R{1-0}R{1-2}R{2-2} {0-0}R{1-0}R{2-0}P{2-2} {0-0}R{1-0}R{2-0}R{2-1}R{2-2} {0-0}R{1-0}R{2-0}R{2-2} {0-0}R{2-0}P{2-2} {0-0}R{2-0}R{2-1}R{2-2} {0-0}R{2-0}R{2-2} {0-0}B{2-2}
14
 */
public class Chessboard_problem_2 {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> p=new LinkedList<Integer>();
        primeSieve(n*n,p);
        // System.out.println(p);
        int c=chess(n,0,0,"{0-0}",p);
        System.out.println("\n"+c);
    }
    static int chess(int n,int i,int j,String ans,List<Integer> p){
        if(i==n-1 && j==n-1){
            System.out.print(ans+" ");
            return 1;
        }
        // System.out.println(p.indexOf(n*i+j+1));
        if(i>=n||j>=n||p.indexOf(n*i+j+1)%2==0)return 0;
        int c=0;
        if(p.indexOf(n*i+j+1)%2==1)c+=chess(n,n-1,n-1,ans+"P{"+(n-1)+"-"+(n-1)+"}",p);
        c+=chess(n,i+2,j+1,ans+"K{"+(i+2)+"-"+(j+1)+"}",p);
        c+=chess(n,i+1,j+2,ans+"K{"+(i+1)+"-"+(j+2)+"}",p);
        if(i==0||i==n-1||j==0||j==n-1){
            for(int k=j+1;k<n;k++){
                c+=chess(n,i,k,ans+"R{"+i+"-"+k+"}",p);
            }
            for(int k=i+1;k<n;k++){
                c+=chess(n,k,j,ans+"R{"+k+"-"+j+"}",p);
            }
        }
        if(i==j||i+j==n-1){
            for(int k=1;k<n-i;k++){
                c+=chess(n,i+k,j+k,ans+"B{"+(i+k)+"-"+(j+k)+"}",p);
            }
        }
        return c;
    }
    public static void primeSieve(int n, List<Integer> p){
        boolean a[]=new boolean[n+1];
        a[0]=a[1]=true;
        for (int i = 2; i*i <=n ; i++) {
            if(!a[i]){
                for (int j = 2; i*j <=n ; j++) {
                    a[i*j]=true;
                }
            }
        }
        for (int i = 0; i < n+1; i++) {
            if(!a[i])
                p.add(i);
        }
    }
}
