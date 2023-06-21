package exam_questions;

/*
Recently, Nidhi experienced hiring process of a product based company. So, Monu bhaiya decided to take interview of Nidhi so that her interview experience can be shared with students which will be beneficial for them. So, Nidhi had a dedicated DSA round in which she was asked questions related to array but however she remembers only one question and the question is as follows:

She was given an integer array arr and an integer k, she was supposed to print the length of the shortest non-empty subarray of arr with a sum of at least k. If there is no such subarray, she had to print -1. A subarray is a contiguous part of an array.

Now, can you solve this question ???

Input Format
First line contains size of array
Second line contains element of array
Third line contains K

Constraints
1 <= arr.length <= 105

-105 <= arr[i] <= 105

1 <= k <= 109

Output Format
Integer

Sample Input
3
2 -1 2
3
Sample Output
3
Explanation
None
 */
import java.util.*;
class Nidhi_Interview_Experience{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int k=sc.nextInt();
        int s=0,e=0;
        int min=n+1;
        int sum=0;
        while(e<n){
            sum+=a[e++];
            while(s<e&&sum-a[s]>=k){
                sum-=a[s++];
            }
            if(sum>=k)
                min=Math.min(min,e-s);
        }
        if(min==n+1)min=-1;
        System.out.println(min);
    }
}
