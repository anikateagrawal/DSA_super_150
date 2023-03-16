package hashmap_heap_assignment;

/*
Take as input N, the size of array. Take N more inputs and store that in an array. Take N more inputs and store that in another array. Write a function which gives the intersection of two arrays in an ArrayList of integers and Print the ArrayList.

Input Format
First line contains N denoting the size of the two arrays. Second line contains N space separated integers denoting the elements of the first array. Third line contains N space separated integers denoting the elements of the second array.

Constraints
Length of Arrays should be between 1 to 100000.

Output Format
Display the repeating elements in a comma separated manner enclosed in square brackets. The numbers should be sorted in increasing order.

Sample Input
7
1 2 3 1 2 4 1
2 1 3 1 5 2 2
Sample Output
[1, 1, 2, 2, 3]
Explanation
Check which integer is present in both the arrays and add them in an array .Print this array as the ans.
 */
import java.util.*;
public class Intersection_Of_Two_Arrays {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }
        for(int i=0;i<n;i++)b.add(sc.nextInt());
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<b.size();j++){
                if(a.get(i)==b.get(j)){
                    ans.add(a.get(i));
                    b.remove(j);
                    break;
                }
                // System.out.println(a+" "+b+" "+j);
            }
        }
        Collections.sort(ans);
        System.out.println(ans);
    }
}
