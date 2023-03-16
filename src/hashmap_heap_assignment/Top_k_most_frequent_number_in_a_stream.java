package hashmap_heap_assignment;
/*
Given an array of n numbers. Your task is to read numbers from the array and keep at-most K numbers at the top (according to their decreasing frequency) every time a new number is read. We basically need to print top k numbers sorted by frequency when input stream has included k distinct elements, else need to print all distinct elements sorted by frequency. If frequency of two numbers are same then print them in increasing order.

Input Format
First line contains integer t as number of test cases. Each test case contains following input. First line contains integer n and k, n represents the length of the array and next line contains n space separated integers.

Constraints
1 < t < 100 1< n < 1000

Output Format
Print top k running stream.

Sample Input
1
5 2
5 1 3 5 2
Sample Output
5 1 5 1 3 5 1 5 1
 */
import java.util.*;
public class Top_k_most_frequent_number_in_a_stream  {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            ArrayList<Integer> l=new ArrayList<>();
            for(int i=0;i<n;i++){
                l.add(sc.nextInt());
                ArrayList<Integer> a=topKFrequent(l,k);
                for(int j:a){
                    System.out.print(j+" ");
                }
            }
            System.out.println();
        }
    }
    public static ArrayList<Integer> topKFrequent(ArrayList<Integer> nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i:nums){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer,Integer>> l=new LinkedList<>(m.entrySet());
        Collections.sort(l,(i1,i2)->{
            return i2.getValue()!=i1.getValue()?i2.getValue()-i1.getValue():i1.getKey()-i2.getKey();
        });
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<k&&i<l.size();i++){
            ans.add(l.get(i).getKey());
        }
        return ans;
    }
}
