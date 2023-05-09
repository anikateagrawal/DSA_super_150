package string_assignment_3;

import java.util.Scanner;
/*
Given an array of positive numbers, the task is to find the number of possible contiguous subarrays having a product less than a given number k.

Input Format
First line contains Integer where N is the Size of Array
Second line contains Integer k
Next N Line Contains an Integer which denotes element of array

Constraints
1<=n<=10^5
1<=k<=10^15
1<=a[i]<=10^5

Output Format
Print number of possible contiguous subarrays having product less than a given number k.

Sample Input
4
10
1
2
3
4
Sample Output
7
Explanation
The contiguous subarrays are {1}, {2}, {3}, {4} {1, 2}, {1, 2, 3} and {2, 3} whose count is 7.
 */
public class Subarrays_Having_Product_less_than_k {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int a[]=new int[n];
        int ei=0,si=0,sum=0,p=1;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        while(ei<a.length){
            p*=a[ei];
            while(si<=ei&&p>=k){
                p/=a[si++];
            }
            sum+=ei-si+1;ei++;
        }
        System.out.println(sum);
    }
}
