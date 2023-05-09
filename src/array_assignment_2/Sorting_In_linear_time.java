package array_assignment_2;

import java.util.Scanner;
/*
Given an array having n elements representing balls of various colours like red, white or blue, sort them in-place so that balls of the same colour are adjacent, with the colours in the order red, white and blue.
To represent the colour red, white, and blue we will use the integers 0, 1, and 2 respectively.
Note:You are not suppose to use the sort function for this problem.

Input Format
First line contains integer n as size of array. Next n lines contains a single integer as element of array.

Constraints
None

Output Format
Print the balls in order so that balls of same colour are adjacent.

Sample Input
6
2 0 2 1 1 0
Sample Output
0 0 1 1 2 2
 */
public class Sorting_In_linear_time {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int oi=0,ei=0,ki=0;
        for(int i=0;i<n;i++){int nn=sc.nextInt();
            if(nn==0)oi++;
            else if(nn==1)ei++;
            else ki++;
        }
        for(int i=0;i<ei;i++)a[oi+i]=1;
        for(int i=0;i<ki;i++)a[oi+ei+i]=2;
        for(int i=0;i<n;i++)System.out.print(a[i]+" ");
    }
}
