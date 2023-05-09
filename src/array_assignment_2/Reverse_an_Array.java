package array_assignment_2;

import java.util.Scanner;
/*
Take as input N, the size of array. Take N more inputs and store that in an array. Write a function that reverses the array. Print the values in reversed array.

1.It reads a number N.
2.Take Another N numbers as input and store them in an Array.
3.Reverse the elements in the Array.
4.Print the reversed Array.

Input Format
First-line contains a single integer n denoting the size of the array.
Next, N line contains a single integer denoting the elements of the array.

Constraints
N cannot be Negative. Range of Numbers can be between -1000000000 to 1000000000.

Output Format
Print the elements of the reversed array

Sample Input
5
0
4
6
8
9
Sample Output
9
8
6
4
0
Explanation
In the sample case , arr=[0,4,6,8,9] is reversed to arr=[9,8,6,4,0].
 */
public class Reverse_an_Array {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long a[]=new long[n];
        for(int i=0;i<n;i++)a[i]=sc.nextLong();
        int ii=0,j=n-1;
        while(ii<j){
            long tmp=a[ii];
            a[ii]=a[j];
            a[j]=tmp;
            ii++;j--;
        }
        for(int i=0;i<n;i++)System.out.println(a[i]);
    }
}
