package linklist_assignment6;
/*
Given two numbers represented by two linked lists, write a program that prints the sum list. The sum list is linked list representation of addition of two input numbers in linked lists. It is not allowed to modify the lists. Also, not allowed to use explicit extra space (Use Recursion).

Input Format
First line contains N,M, number of nodes in the 1st and 2nd list.
Next line contains N nodes of 1st list.
Next line contains M nodes of 2nd list.

Constraints
0<N<10^6

Output Format
Print the sum list after adding the two linked lists.

Sample Input
3 3
5 6 3
8 4 2
Sample Output
1 4 0 5
Explanation
After adding the two numbers represented by linked lists i.e. 563 + 842 =1405 is represented as sum list. Sum list =1 -> 4 -> 0 -> 5.
 */
import java.util.Scanner;

public class Sum_of_two_Linked_Lists {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        String s1="",s2="";
        String ns="";
        for(int i=0;i<a;i++)s1+=sc.nextInt();
        for(int i=0;i<b;i++)s2+=sc.nextInt();
        int sum=0;
        a--;
        b--;
        while(a>-1||b>-1){
            int d=0,d2=0;
            if(a>=0){
                d=s1.charAt(a)-'0';
                a--;
            }
            if(b>=0){
                d2=s2.charAt(b)-'0';
                b--;
            }
            sum+=d+d2;
            ns=sum%10+ns;
            sum/=10;
        }
        if(sum!=0)ns=sum+ns;
        for(int i=0;i<ns.length();i++){
            System.out.print(ns.charAt(i)+" ");
        }
    }
}
