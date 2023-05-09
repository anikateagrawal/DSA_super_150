package stack_queue_assignment_5;

import java.util.Scanner;
import java.util.Stack;
/*
Given an array of patterns containing only I’s and D’s. I for increasing and D for decreasing. Devise an algorithm to print the minimum number following that pattern. Digits from 1-9 and digits can’t repeat.

Input Format
The First Line contains an Integer N, size of the array. Next Line contains N Strings separated by space.

Constraints
1 ≤ T ≤ 100 1 ≤ Length of String ≤ 8

Output Format
Print the minimum number for each String separated by a new Line.

Sample Input
4
D I DD II
Sample Output
21
12
321
123
Explanation
For the Given sample case, For a Pattern of 'D' print a decreasing sequence which is 2 1.
 */
public class form_minimum_Num_from_given_sequence {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            String s=sc.next();
            System.out.println(di(s));
        }

    }
    static String di(String pattern){
        int k=1;
        int a[]=new int[pattern.length()+1];
        Stack<Integer> s=new Stack<Integer>();
        for(int i=0;i<a.length;i++){
            if(i==pattern.length()||pattern.charAt(i)=='I'){
                a[i]=k++;
                while(!s.isEmpty()){
                    a[s.pop()]=k++;
                }
            }
            else s.push(i);
        }
        String ns="";
        for(int i=0;i<a.length;i++)ns+=a[i];
        return ns;
    }
}
