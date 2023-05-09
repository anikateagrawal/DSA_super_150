package recursion_assignment_4;

import java.util.Scanner;
/*
Take as input N, a number. Write a recursive function which prints counting from 0 to N in lexicographical order. In lexicographical (dictionary) order 10, 100 and 109 will be printed before 11.

Input Format
Enter a number N.

Constraints
None

Output Format
Display all the numbers upto N in a lexicographical order

Sample Input
10
Sample Output
0 1 10 2 3 4 5 6 7 8 9
 */
public class Recursion_lexicographical_order {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        lexi(0,n);
    }
    public static void lexi(int start,int end)
    {
        if(start>end)return;
        int i=0;
        if(start==0)i=1;
        System.out.print(start+" ");
        while(i<10)
        {
            lexi(start*10+i,end);
            i++;
        }
    }
}
