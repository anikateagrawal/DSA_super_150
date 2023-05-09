package linklist_assignment6;
/*
Given three linked lists, say a, b and c, find one node from each list such that the sum of the values of the nodes is equal to a given number say, Target. As any number of answers can be possible return the first one you get while traversing.

Input Format
The First Line contains 3 Integers n, m and k as the Size of the Three LinedLists. Next 3 Lines contains n, m and k integers Respectively as the elements of Linked Lists. Next Line contains the an Integer as Target.

Constraints
The Size of the Lists can be different.

Output Format
Display the 3 elements from each of the Lists whose sum is equals to the target separated by space.

Sample Input
3 3 3
12 6 29
23 5 8
90 20 59
101
Sample Output
6 5 90
Explanation
In the Given Sample Input, 6, 5 and 90 from lists 1, 2 and 3 respectively add to give 101.
 */
import java.util.Scanner;

public class Triplet_from_three_linked_lists {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int a1[]=new int[a];
        int a2[]=new int [b];
        int a3[]=new int[c];
        for(int i=0;i<a;i++)a1[i]=sc.nextInt();
        for(int i=0;i<b;i++)a2[i]=sc.nextInt();
        for(int i=0;i<c;i++)a3[i]=sc.nextInt();
        int t=sc.nextInt();
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                for(int k=0;k<c;k++){
                    if(a1[i]+a2[j]+a3[k]==t){
                        System.out.println(a1[i]+" "+a2[j]+" "+a3[k]);
                        return;
                    }
                }
            }
        }
    }
}
