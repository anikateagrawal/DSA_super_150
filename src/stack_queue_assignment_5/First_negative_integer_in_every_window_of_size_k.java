package stack_queue_assignment_5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
/*
You are given given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k. If a window does not contain a negative integer, then print 0 for that window.

Input Format
First line contains integer t as number of test cases. Each test case contains two lines. First line contains two integers n and k where n is length of the array and k is the size of window and second line contains n space separated integer.

Constraints
1 < t < 10 1< n, k < 10000000

Output Format
For each test case you have to print the required output as given below.

Sample Input
2
8 3
12 -1 -7 8 -15 30 16 28
 8 4
12 -1 -7 8 -15 30 16 28
Sample Output
-1 -1 -7 -15 -15 0
-1 -1 -7 -15 -15
Explanation
For first test case : Subarray of window size 3 is ( 12 -1 -7), (-1, -7, 8), and so on.. Take first negative number from each window and print them.
 */
public class First_negative_integer_in_every_window_of_size_k {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)a[i]=sc.nextInt();
            Deque<Integer> dq=new LinkedList<Integer>();
            int ans[]=new int[n-k+1];
            for(int i=0;i<n;i++){
                if(a[i]<0)dq.add(i);
                while(!dq.isEmpty()&& dq.peek()<=i-k){
                    dq.remove();
                }
                if(i>=k-1){
                    if(!dq.isEmpty())
                        ans[i-k+1]=a[dq.peek()];
                    else ans[i-k+1]=0;
                }
            }
            for(int i=0;i<ans.length;i++)
                System.out.print(ans[i]+" ");
            System.out.println();
        }
    }
}
