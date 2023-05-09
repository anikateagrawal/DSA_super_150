package stack_queue_assignment_5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*
Monu bhaiya wants to count all his girlfriend's Derangement. A Derangement is a permutation of n elements, so no element appears in its original position. For example, a derangement of {0, 1, 2, 3} is {2, 3, 1, 0}. Given a number n, find the total number of Derangements of a set of n elements.

Input Format
An integer N

Constraints
N=[1,10^6]

Output Format
Number of possible derangements

Sample Input
2
Sample Output
1
Explanation
For two elements say {0, 1}, there is only one possible derangement {1, 0}
 */
public class GirlfriendsDerangements {
    static int c=0;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> l=new LinkedList<Integer>();
        for(int i=0;i<n;i++)l.add(i);
        per(l,new LinkedList<Integer>());
        System.out.println(c);
    }
    static void per(List<Integer> l,List<Integer> ans){
        if(l.size()==0){
            int i;
            for(i=0;i<ans.size();i++){
                if(ans.get(i)==i)break;
            }
            if(i==ans.size())c++;
        }
        for(int i=0;i<l.size();i++){
            int v=l.remove(i);
            ans.add(v);
            per(l,ans);
            ans.remove(ans.size()-1);
            l.add(i,v);
        }
    }

}
