package stack_queue_assignment_5;

import java.util.Scanner;
/*
We are given a circular array, print the next greater number for every element. If it is not found print -1 for that number. To find the next greater number for element Ai , start from index i + 1 and go uptil the last index after which we start looking for the greater number from the starting index of the array since array is circular.

Input Format
First line contains the length of the array n. Second line contains the n space separated integers.

Constraints
1 <= n <= 10^6
-10^8 <= Ai <= 10^8 , 0<= i< n

Output Format
Print n space separated integers each representing the next greater element.

Sample Input
3
1 2 3
Sample Output
2 3 -1
Explanation
Next greater element for 1 is 2,
for 2 is 3 but not present for 3 therefore -1
 */

public class Find_the_greater_element {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<a.length;i++){
            a[i]=sc.nextInt();
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int k=1;
            while(k<n){
                if(a[(i+k)%n]>a[i]){
                    ans[i]=a[(i+k)%n];
                    break;
                }
                k++;
            }
            if(k==n)ans[i]=-1;
        }
        for(int i=0;i<a.length;i++)System.out.print(ans[i]+" ");
    }
}
