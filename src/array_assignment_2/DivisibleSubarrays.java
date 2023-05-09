package array_assignment_2;

import java.util.Scanner;
/*
You are given N elements, a1,a2,a3….aN. Find the number of good sub-arrays.
A good sub-array is a sub-array [ai,ai+1,ai+2….aj] such that (ai+ai+1+ai+2+….+aj) is divisible by N.



Input Format
The first line contains the number of test cases T. First line of each test case contains an integer N denoting the number of elements. Second line of each test case contains N integers, a1, a2, a3….aN, where ai denotes the ith element of the array.

Constraints
1<=T<=10
1<=N<=10^5
|ai|<=10^9

Output Format
Output a single integer denoting the number of good sub-arrays.

Sample Input
2
5
1 1 1 1 1
5
5 5 5 5 5
Sample Output
1
15
Explanation
In first test case, there is only one sub-array [1, 1, 1, 1, 1], such that 1+1+1+1+1=5, which is divisible by N=5
 */
public class DivisibleSubarrays {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long s=0;
            long c[]=new long[n];
            for(int i=0;i<n;i++){
                s=(s+sc.nextInt());
                long in=s%n;
                if(in<0)in=n+in;
                c[(int)in]++;
            }
            c[0]++;
            long ct=0;
            for(int i=0;i<n;i++){
                if(c[i]>1){
                    ct+=(c[i]*(c[i]-1))/2;
                }
            }
            System.out.println(ct);
        }
    }
}
