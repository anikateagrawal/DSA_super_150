package recursion_assignment_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Take as input N, a number. Take N more inputs and store that in an array.

a. Write a recursive function which counts the number of ways the array could be split in two groups, so that the sum of items in both groups is equal. Each number in the array must belong to one of the two groups. Print the value returned.

b. Write a recursive function which keeps track of ways an array could be split in two groups, so that the sum of items in both groups is equal. Each number in the array must belong to one of the two groups. Return type of function should be void. Print the two groups, each time you find a successful split.

Input Format
Take as input N, a number. Take N more inputs and store that in an array.

Constraints
None

Output Format
Display all the groups in a comma separated manner and display the number of ways the array can be split

Sample Input
6
1
2
3
3
4
5
Sample Output
1 2 3 3 and 4 5
1 3 5 and 2 3 4
1 3 5 and 2 3 4
2 3 4 and 1 3 5
2 3 4 and 1 3 5
4 5 and 1 2 3 3
6
 */
public class split_array {
    static int c=0;
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int s=0;
        for(int i=0;i<n;i++){a[i]=sc.nextInt();s+=a[i];}
        if(s%2!=0){
            System.out.println("0");
            return;
        }
        fun(a,0,new ArrayList<Integer>(),new ArrayList<Integer>(),0,0);
        System.out.println(c);
    }
    static void fun(int a[], int i, List<Integer> l1, List<Integer> l2, int sum1, int sum2){
        if(i==a.length){
            if(sum1==sum2&&sum1!=0){
                for(int j=0;j<l1.size();j++)System.out.print(a[l1.get(j)]+" ");
                System.out.print("and ");
                for(int j=0;j<l2.size();j++)System.out.print(a[l2.get(j)]+" ");
                c++;
                System.out.println();
            }
            return;
        }
        l1.add(i);
        fun(a,i+1,l1,l2,sum1+a[i],sum2);
        l1.remove(Integer.valueOf(i));
        l2.add(i);
        fun(a,i+1,l1,l2,sum1,sum2+a[i]);
        l2.remove(Integer.valueOf(i));
    }
}
