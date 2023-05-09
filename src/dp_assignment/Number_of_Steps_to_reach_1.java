package dp_assignment;

/*
Given a positive number N your task is to bring this number to 1 by performing only a set of operations. The operations can be either dividing the number by 2 only if the number is even or you can add or subtract 1 only if the number is odd.
More Precisely:
1) N=N/2 (if N is even)
2)N=N+1/ N=N-1 (if N is odd)
Your task is to minimize these number of operations.

Input Format
A single positive integer N

Constraints
n<=100000

Output Format
Print on a single line the minimum number of steps needed to reach 1 by performing the given operations.

Sample Input
8
Sample Output
3
Explanation
8->4->2->1
 */
import java.util.*;
class Number_of_Steps_to_reach_1
{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(op(n));
    }
    static int op(int n){
        if(n<=2)return n-1;
        int ans=0;
        if(n%2==0){
            ans=1+op(n/2);
        }
        else {
            ans=1+Math.min(op(n+1),op(n-1));
        }
        return ans;
    }
}
