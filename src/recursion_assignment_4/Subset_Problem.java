/*Take as input N, a number. Take N more inputs and store that in an array. Take as input target, a number

        a. Write a recursive function which counts the number of subsets of the array which sum to target. Print the value returned.

        b. Write a recursive function which prints subsets of the array which sum to target. Return type of functions is void.

        Input Format
        Take as input N, a number. Take N more inputs and store that in an array.Take as input target, a number

        Constraints
        None

        Output Format
        Display the number of subsets and print the subsets in a space separated manner.

        Sample Input
        3
        1
        2
        3
        3
        Sample Output
        1 2  3
        2
 */
package recursion_assignment_4;

import java.util.Scanner;

public class Subset_Problem {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int t=sc.nextInt();
        int c=subsets(a,0,t,0,"");
        System.out.println();
        System.out.println(c);
    }
    static int subsets(int a[],int i,int t,int sum,String ans){
        if(i==a.length)
        {

            if(sum==t){
                System.out.print(ans+" ");
                return 1;
            }
            return 0;
        }
        int c=0;
        c+=subsets(a,i+1,t,sum+a[i],ans+a[i]+" ");
        c+=subsets(a,i+1,t,sum,ans);
        return c;
    }
}
