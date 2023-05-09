package stack_queue_assignment_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
The Game is as follows You have given a binary array, where 1 denotes push operation and 0 denotes a pop operation in a queue. The task is to check if the possible set of operations are valid or not.
Print Valid if the set of Operations are Valid Otherwise Print Invalid.

Input Format
The First Line contains an Integer T, as the number of Test cases.
The Next Line contains an Integer N, as the Size of the Array.
The Next Line contains N Binary numbers separated by space.

Constraints
Output Format
Print Valid If the set of operations are valid Otherwise Print Invalid for each Test Case separated by a new Line.

Sample Input
2
5
1 1 0 0 1
5
1 1 0 0 0
Sample Output
Valid
Invalid
 */
public class TheQueueGame {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            try{
                Queue<Integer> q=new LinkedList<Integer>();
                int a[]=new int[n];
                for(int i=0;i<n;i++)a[i]=sc.nextInt();
                for(int i=0;i<n;i++){
                    if(a[i]==1){
                        q.add(0);
                    }
                    else {
                        q.remove();
                    }
                }
                System.out.println("Valid");
            }
            catch(Exception e){
                System.out.println("Invalid");
            }
        }
    }
}
