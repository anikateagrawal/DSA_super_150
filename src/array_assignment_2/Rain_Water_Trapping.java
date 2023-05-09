package array_assignment_2;

import java.util.Scanner;
/*
You are given an input array whose each element represents the height of a line towers. The width of every tower is 1. It starts raining. Water is filled between the gap of towers if possible. You need to find how much water filled between these given towers.

Example : Imgur

Input Format
The first line consists of number of test cases T. Each test case consists an integer N as number of towers and next line contains the N space separated integers.

Constraints
1 <= N <= 1000000 1 <= t <= 10 0 <= A[i] <= 10000000

Output Format
Print how much unit of water collected among towers for each test case.

Sample Input
2
6
3  0  0  2  0  4
12
0  1  0  2  1  0  1  3  2  1  2  1
Sample Output
10
6
 */
public class Rain_Water_Trapping {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)a[i]=sc.nextInt();
            System.out.println(trap(a));
        }
    }
    public static int trap(int[] h) {
        int l[]=new int[h.length];
        int r[]=new int[h.length];
        l[0]=h[0];r[h.length-1]=h[h.length-1];
        for(int i=1;i<h.length;i++){
            l[i]=Math.max(l[i-1],h[i]);
        }
        for(int i=h.length-2;i>=0;i--){
            r[i]=Math.max(r[i+1],h[i]);
        }
        int s=0;
        for(int i=0;i<h.length;i++){
            s+=Math.min(l[i],r[i])-h[i];
        }
        return s;
    }
}
