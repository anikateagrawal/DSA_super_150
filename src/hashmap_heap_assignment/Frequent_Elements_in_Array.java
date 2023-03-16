package hashmap_heap_assignment;

/*
Given an integer array nums and an integer k, Find the k most frequent elements ,keys with same frequency should be in decreasing order and finally You have to print the answer in sorted order.

Input Format
The first line contains two Integer space-separated integers N (array size) and K.

The second line contains Element of Array

Constraints
1 < = N <= 105
-104 <= arr[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

Output Format
Single Line consisting of K frequent elements in sorted order ,where each number is separated by space.

Sample Input
6  2
1 1 1 3 2 2
Sample Output
1 2
Explanation
None
 */
import java.util.*;
public class Frequent_Elements_in_Array {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int k=sc.nextInt();
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int b[]=topKFrequent(a,k);
        Arrays.sort(b);
        for(int i:b)System.out.print(i+" ");
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i:nums){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer,Integer>> l=new LinkedList<>(m.entrySet());
        Collections.sort(l,(i1,i2)->{
            return i2.getValue()!=i1.getValue()?i2.getValue()-i1.getValue():i2.getKey()-i1.getKey();
        });
        int ans[]=new int[k];
        int in=0;
        for(int i=0;i<k;i++){
            ans[in++]=l.get(i).getKey();
        }
        return ans;
    }
}
