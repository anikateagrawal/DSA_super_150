package hashmap_heap_assignment;

/*
Given an array find the number which comes with maximum frequency. It must work in O(n) time complexity.

Input Format
Enter the size of the array N and add N more numbers and store in an array

Constraints
1 <= N <= 10^7
-109 <= A[i] <= 109

Output Format
Display the number with the maximum frequency.

Sample Input
5
1 2 2 2 3
Sample Output
2
Explanation
2 has the highest frequency in the array i.e. 3.
 */
import java.util.*;
public class Highest_frequency {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            m.put(a,m.getOrDefault(a,0)+1);
        }
        int max=0;
        int k=-1;
        for(int i:m.keySet()){
            if(m.get(i)>max){
                max=m.get(i);
                k=i;
            }
        }
        System.out.println(k);
    }
}
