package array_assignment_2;

import java.util.Scanner;
/*
Implement squareroot(x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x)).
Note: DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY

Input Format
An integer A .

Constraints
0 <= A <10000000000

Output Format
Squareroot of A.

Sample Input
25
Sample Output
5
 */
public class FindSquareRoot {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextInt();
        System.out.println(root(n));
    }
    public static long root(long n){
        long lo=1;
        long hi=n;
        long ans=0;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(mid*mid<=n){
                ans=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return ans;
    }
}
