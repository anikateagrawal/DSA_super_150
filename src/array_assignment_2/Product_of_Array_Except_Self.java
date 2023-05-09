package array_assignment_2;

import java.util.Scanner;
/*
Given an array arr of n integers where n > 1, return an array output such that output[i] is equal to the product of all the elements of arr except arr[i].

Input Format
First line contains integer N as size of array.
Next line contains a N integer as element of array.

Constraints
arr[i]<=10000000

Output Format
print output array

Sample Input
4
1 2 3 4
Sample Output
24 12 8 6
 */
public class Product_of_Array_Except_Self {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long a[]=new long[n];
        for(int i=0;i<n;i++)a[i]=sc.nextLong();
        long b[]=productExceptSelf(a);
        for(int i=0;i<n;i++)System.out.print(b[i]+" ");

    }
    public static long[] productExceptSelf(long[] nums) {
        long l[]=new long[nums.length];
        long r[]=new long[nums.length];
        l[0]=1;r[nums.length-1]=1;
        for(int i=1;i<nums.length;i++)l[i]=l[i-1]*nums[i-1];
        for(int i=nums.length-2;i>=0;i--)r[i]=r[i+1]*nums[i+1];
        for(int i=0;i<nums.length;i++)nums[i]=l[i]*r[i];
        return nums;
    }
}
