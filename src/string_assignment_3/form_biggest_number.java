package string_assignment_3;

import java.util.Scanner;
/*
You are provided an array of numbers. You need to arrange them in a way that yields the largest value.

Input Format
First line contains integer t which is number of test case.
For each test case, you are given a single integer n in the first line which is the size of array A[] and next line contains n space separated integers denoting the elements of the array A .

Constraints
1<=t<=100

1<=m<=100

1<=A[i]<=10^5

Output Format
Print the largest value.

Sample Input
1
4
54 546 548 60
Sample Output
6054854654
Explanation
Upon rearranging the elements of the array , 6054854654 is the largest possible number that can be generated.
 */
public class form_biggest_number {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            String a[]=new String[n];
            for(int i=0;i<n;i++){
                a[i]=sc.next();
            }
            for(int i=0;i<a.length;i++){
                for(int j=0;j<a.length-i-1;j++){
                    String ab=a[j]+a[j+1];
                    String ba=a[j+1]+a[j];
                    if(ab.compareTo(ba)<0){
                        String tmp=a[j];
                        a[j]=a[j+1];
                        a[j+1]=tmp;
                    }
                }
            }
            for(int i=0;i<n;i++){
                System.out.print(a[i]);
            }
            System.out.println();
        }
    }
}
