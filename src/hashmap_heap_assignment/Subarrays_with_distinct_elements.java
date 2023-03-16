package hashmap_heap_assignment;

/*
Given an array, the task is to calculate the sum of lengths of contiguous subarrays having all elements distinct

Input Format
An integer n denoting size of array followed by n integers

Constraints
1<=N<=10^5

Output Format
The answer mod 10^9+7

Sample Input
3
1 2 3
Sample Output
10
Explanation
{1, 2, 3} is a subarray of length 3 with distinct elements. Total length of length three = 3. {1, 2}, {2, 3} are 2 subarray of length 2 with distinct elements. Total length of lengths two = 2 + 2 = 4 {1}, {2}, {3} are 3 subarrays of length 1 with distinct element. Total lengths of length one = 1 + 1 + 1 = 3 Sum of lengths = 3 + 4 + 3 = 10
 */
import java.util.*;
public class Subarrays_with_distinct_elements {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        function(a);
    }
    static void function(int a[]){
        int n=a.length;
        int ans=0;
        int j=0;
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<n;i++){
            while(j<n&& !s.contains(a[j])){
                s.add(a[j]);
                j++;
            }
            ans+=(j-i+1)*(j-i)/2;
            s.remove(a[i]);
        }
        System.out.println(ans);
    }
}
