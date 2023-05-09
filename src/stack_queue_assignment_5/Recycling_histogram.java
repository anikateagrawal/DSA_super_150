package stack_queue_assignment_5;

import java.util.Scanner;
import java.util.Stack;
/*
You are a marketing head of a big MNC. You made a bar graph for your latest presentation. Now for your next project you need a rectangular sheet. But you don't want to waste anymore paper.

Since you don't need that bar graph anymore, you can use sheets from that. So you have to find the biggest possible rectangle you can cut out of that bar graph.

Input Format
First line takes integer N(no. of histogram bar).
Second line contains N integers representing the height of each bar respectively.

Constraints
Constraints: 1<=N<=10^5
0<=height[i]<=10^4

Output Format
Print the largest area of the rectangle that can be formed in histogram.

Sample Input
6
2 1 5 6 2 3
Sample Output
10
Explanation
The above is a histogram where the width of each bar is 1. The largest rectangle is shown in the red area, which has an area = 10 units.
 */
public class Recycling_histogram {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        System.out.println(Area(a));
    }
    public  static  int Area(int []arr){
        Stack<Integer> st=new Stack<Integer>();
        int maxarea=0;
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty()&&arr[i]<arr[st.peek()]){
                int h=arr[st.pop()];
                int r=i;
                if(st.isEmpty()){
                    maxarea=Math.max(maxarea,h*r);
                }
                else{
                    int l=st.peek();
                    maxarea=Math.max(maxarea,h*(r-l-1));
                }
            }
            st.push(i);
        }
        int r=arr.length;
        while (!st.isEmpty()){
            int h=arr[st.pop()];
            if(st.isEmpty()){
                maxarea=Math.max(maxarea,h*r);
            }
            else{
                int l=st.peek();
                maxarea=Math.max(maxarea,h*(r-l-1));
            }
        }
        return maxarea;
    }
}
