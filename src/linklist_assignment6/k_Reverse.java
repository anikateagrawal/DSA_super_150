package linklist_assignment6;

import java.util.Scanner;
/*
Given a head to Linked List L, write a function to reverse the list taking k elements at a time. Assume k is a factor of the size of List.

You need not have to create a new list. Just reverse the old one using head.

Input Format
The first line contains 2 space separated integers N and K

The next line contains N space separated integral elements of the list.

Constraints
0 <= N <= 10^6 0 <= K <= 10^6

Output Format
Display the linkedlist after reversing every k elements

Sample Input
9 3
9 4 1 7 8 3 2 6 5
Sample Output
1 4 9 3 8 7 5 6 2
Explanation
N = 9 & K = 3

Original LL is : 9 -> 4 -> 1 -> 7 -> 8 -> 3 -> 2 -> 6 -> 5

After k Reverse : 1 -> 4 -> 9 -> 3 -> 8 -> 7 -> 5 -> 6 -> 2
 */
public class k_Reverse {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int s=0;
        for(int i=k-1;i<n;i+=k){
            rev(a,s,i);
            s=i+1;
        }
        for(int i=0;i<n;i++)System.out.print(a[i]+" ");

    }
    static void rev(int a[],int s,int l){
        while(s<l){
            int t=a[s];
            a[s]=a[l];
            a[l]=t;
            s++;
            l--;
        }
    }
}
