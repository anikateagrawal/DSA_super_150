package linklist_assignment6;
/*
Given a list, modify it such that all odd elements appear before the even ones. The order of odd elements and even shall remain intact.

See explantaion for more info.

Input Format
The first line contains an integer N, the number of elements in the list.

The next line contains N space separated integral elements of the list.

Constraints
1 <= T <= 1000 0 <= N <= 10^6

Output Format
T lines of output

Sample Input
5
1 2 3 4 5
Sample Output
1 3 5 2 4
Explanation
Input : 1 -> 2 -> 3 -> 11-> 4 -> 5

The order of odd elements and even does not change. For instance 3 comes before 5 in the input, so comes in the output.

Output: 1 -> 3 -> 11 -> 5 -> 2 -> 4
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class OddEven {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        List<Integer> o=new LinkedList<Integer>();
        List<Integer> e=new LinkedList<Integer>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            if(a%2==1)o.add(a);
            else e.add(a);
        }
        for(int i=0;i<o.size();i++)System.out.print(o.get(i)+" ");
        for(int i=0;i<e.size();i++)System.out.print(e.get(i)+" ");
    }
}
