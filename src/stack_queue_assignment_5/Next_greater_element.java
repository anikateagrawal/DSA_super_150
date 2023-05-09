package stack_queue_assignment_5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
/*
Given an array, print the Next Greater Element (NGE) for every element. The Next Greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Input Format
First line of the input contains a single integer T denoting the number of testcases. First line of each testcase contains an integer N denoting the size of array. Second line of each testcase contains N space seperated integers denoting the array.

Constraints
1 <= T <= 50 1 <= N <= 10^5

Output Format
For each index, print its array element and its next greater element seperated by a comma in a new line.

Sample Input
2
4
11 13 21 3
5
11 9 13 21 3
Sample Output
11,13
13,21
21,-1
3,-1
11,13
9,13
13,21
21,-1
3,-1
Explanation
For the first testcase , the next greater element for 11 is 13 , for 13 its 21 and 21 being the largest element of the array does not have a next greater element. Hence we print -1 for 21. 3 is the last element of the array and does not have any greater element on its right. Hence we print -1 for it as well.
 */
public class Next_greater_element {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t > 0) {
            int n = scn.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < arr.length; i++)
                arr[i] = scn.nextInt();

            nextLarger(arr);

            t--;
        }

    }

    // Function to print Next Greater Element for each element of the array
    public static void nextLarger(int[] arr) {

// Write Code here
        int a[]= Arrays.copyOf(arr,arr.length);
        Stack<Integer> s=new Stack<Integer>();
        for (int i = 0; i < a.length; i++) {
            while(!s.isEmpty()&& a[i]>a[s.peek()]){
                int in=s.pop();
                a[in]=a[i];
            }
            s.push(i);
        }
        while (!s.isEmpty()){
            int in=s.pop();
            a[in]=-1;
        }
        for(int i=0;i<a.length;i++){
            System.out.println(arr[i]+","+a[i]);
        }
    }
}
