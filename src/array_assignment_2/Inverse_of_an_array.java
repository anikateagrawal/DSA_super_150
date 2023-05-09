package array_assignment_2;

import java.util.Arrays;
import java.util.Scanner;
/*
Take as input N, a number. Take N more inputs and store that in an array. Write a recursive function which inverses the array. Print the values of inverted array

Input Format
Enter a number N and take N more inputs

Constraints
None

Output Format
Display the values of the inverted array in a space separated manner

Sample Input
5
0 2 4 1 3
Sample Output
0 3 1 4 2
Explanation
Swap element with index

for eg : element 4 at index 2 becomes element 2 at index 4
 */
public class Inverse_of_an_array {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int [n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int b[]= Arrays.copyOf(a,n);
        fun(a,b,0);
        for(int i=0;i<n;i++)System.out.print(b[i]+" ");
    }
    static void fun(int a[],int b[],int i){
        if(i==a.length)return;
        fun(a,b,i+1);
        //System.out.println(Arrays.toString(a));
        int e=a[i];
        b[e]=i;
    }
}
