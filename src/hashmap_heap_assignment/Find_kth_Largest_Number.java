package hashmap_heap_assignment;

/*
Find the kth largest element in an unsorted array.
Note:It is the kth largest element in the sorted order, not the kth distinct element.

Input Format
First line contains integer n as size of array. Second line contains the value of k. Third line contains n integers as element of array.

Constraints
1 ≤ k ≤ array's length.

Output Format
Print the kth largest element as output.

Sample Input
6
2
3 2 1 5 6 4
Sample Output
5
 */
import java.util.*;
public class Find_kth_Largest_Number {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int k=sc.nextInt();
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        System.out.println(findKthLargest(a,k));
    }
    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i:nums){
            if(q.size()<=k-1){
                q.add(i);continue;
            }
            if(i>q.peek()){
                q.poll();
                q.add(i);
            }

        }
        return q.poll();
    }
}
