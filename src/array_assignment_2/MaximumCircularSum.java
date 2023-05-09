package array_assignment_2;

import java.util.Scanner;
/*
You are provided n numbers (both +ve and -ve). Numbers are arranged in a circular form. You need to find the maximum sum of consecutive numbers.

Input Format
First line contains integer t which is number of test case.
For each test case, it contains an integer n which is the size of array and next line contains n space separated integers denoting the elements of the array.

Constraints
1<=t<=100
1<=n<=1000
|Ai| <= 10000

Output Format
Print the maximum circular sum for each testcase in a new line.

Sample Input
1
7
8 -8 9 -9 10 -11 12
Sample Output
22
Explanation
Maximum Circular Sum = 22 (12 + 8 - 8 + 9 - 9 + 10)
 */
public class MaximumCircularSum {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)a[i]=sc.nextInt();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                int s=0;
                int j=i;
                for(int k=0;k<n;k++){
                    s+=a[j];
                    if(s>max)max=s;
                    j=(j+1)%n;
                }
            }
            System.out.println(max);
        }
    }
}
