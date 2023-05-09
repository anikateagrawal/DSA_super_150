package recursion_assignment_4;

import java.util.Scanner;
/*
Take as input N, the size of array. Take N more inputs and store that in an array. Take as input M, a number. Write a recursive function which returns the last index at which M is found in the array and -1 if M is not found anywhere. Print the value returned.

Input Format
Enter a number N and add N more numbers to an array, then enter number M to be searched

Constraints
None

Output Format
Display the last index at which the number M is found

Sample Input
5
3
2
1
2
3
2
Sample Output
3
 */
public class last_index {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]= sc.nextInt();
        }
        int v= sc.nextInt();
        System.out.println(fun(a,a.length-1,v));
    }
    static int fun(int a[],int i,int v){
        if(i<0)return -1;
        if(a[i]==v)return i;
        return fun(a,i-1,v);
    }
}
