package hashmap_heap_assignment;

/*
Given K sorted linked lists of equal sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.

Input Format
First line contains 2 space separated integers K and N.
Next lines contain N*K space separated integers

Constraints
None

Output Format
Single line consisting of space separated numbers

Sample Input
3 4
5 5 5 9 3 13 14 17 1 8 11 18
Sample Output
1 3 5 5 5 8 9 11 13 14 17 18
 */
import java.util.*;
public class Merge_K_Sorted_Lists {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        PriorityQueue<Integer> p=new PriorityQueue<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)p.add(sc.nextInt());
        while(!p.isEmpty())System.out.print(p.poll()+" ");
    }
}
