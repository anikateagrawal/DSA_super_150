package array_assignment_2;

import java.util.Scanner;
/*
You are given two integers n and k. Find the greatest integer x, such that, x^k <= n.

Input Format
First line contains number of test cases, T. Next T lines contains integers, n and k.

Constraints
1<=T<=10
1<=N<=10^15
1<=K<=10^4

Output Format
Output the integer x

Sample Input
2
10000 1
1000000000000000 10
Sample Output
10000
31
Explanation
For the first test case, for x=10000, 10000^1=10000=n
 */
public class Kth_Root {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long n=sc.nextLong();
            int k=sc.nextInt();
            System.out.println(find(n,k));
        }
    }
    static long find(long n,int k){
        long l=1,h=n,mid;
        long ans=0;
        while(l<=h){
            mid=(l+h)/2;
            if(Math.pow(mid,k)<=n){
                ans=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return ans;
    }
}
