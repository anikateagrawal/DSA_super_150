package assignment_4;

import java.util.Scanner;
/*
Take as input N1 and N2, both numbers. N1 and N2 is the number of rows and columns on a rectangular board. Our player starts in top-left corner of the board and must reach bottom-right corner. In one move the player can move 1 step horizontally (right) or 1 step vertically (down) or 1 step diagonally (south-east).

a. Write a recursive function which returns the count of different ways the player can travel across the board. Print the value returned.

b. Write a recursive function which prints moves for all valid paths across the board (void is the return type for function).

Input Format
Enter the number of rows N1 and number of columns N2

Constraints
None

Output Format
Display the total number of paths and print all the possible paths in a space separated manner

Sample Input
3
3
Sample Output
VVHH VHVH VHHV VHD VDH HVVH HVHV HVD HHVV HDV DVH DHV DD
13
 */
public class MazePath_d {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int c=maze(m,n,0,0,"");
        System.out.println("\n"+c);
    }
    static int maze(int m,int n,int i,int j,String ans){
        if(i==m-1 && j==n-1){
            System.out.print(ans+" ");
            return 1;
        }
        int c=0;
        if(i<m){
            c+=maze(m,n,i+1,j,ans+"V");
        }
        if(j<n){
            c+=maze(m,n,i,j+1,ans+"H");
        }
        if(i<m && j<n){
            c+=maze(m,n,i+1,j+1,ans+"D");
        }
        return c;

    }
}
