package stack_queue_assignment_5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
/*
You are at a casino. There are N stacked cards on pile . Each card has a number written on it. Then there will be Q iterations. In ith iteration, you start picking up the cards in Ai-1th pile from the top one by one and check whether the number written on the card is divisible by the ith prime number. If the number is divisible, you stack that card on pile Bi. Otherwise, you stack that card on pile Ai. After Q iterations, cards can only be on pile B1, B2, B3, . . . BQ, AQ . Output numbers on these cards from top to bottom of each piles in order of B1, B2, B3, . . . BQ, AQ .

Input Format
First line contains N and Q. The next line contains N space separated integers representing the initial pile of cards i.e., A0. The leftmost value represents the bottom plate of the pile.

Constraints
N < 10^5
Q < 10^5
|Ai| < 10^9

Output Format
Output N lines, each line containing the number written on the card.

Sample Input
5 1
3 4 7 6 5
Sample Output
4
6
3
7
5
Explanation
Initially:

A0 = [3, 4, 7, 6, 5]<-TOP

After 1st iteration:

A0 = []<-TOP

A1 = [5, 7, 3]<-TOP

B1 = [6, 4]<-TOP

Now first print B1 from top to bottom then A1 from top to bottom.
 */
public class Playing_with_cards_in_stack {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),q=sc.nextInt();
        List<Integer> p=new LinkedList<Integer>();
        primeSieve(1000000,p);
        Stack<Integer> A=new Stack<Integer>();
        for(int i=0;i<n;i++)A.push(sc.nextInt());
        List<Stack<Integer>> l=new LinkedList<Stack<Integer>>();
        for(int i=0;i<q;i++){
            Stack<Integer> b=new Stack<Integer>();
            Stack<Integer> a=new Stack<Integer>();
            while(!A.isEmpty()){
                if(A.peek()%p.get(i)==0){
                    b.push(A.pop());
                }
                else {
                    a.push(A.pop());
                }
            }
            l.add(b);
            A=a;
        }
        for(int i=0;i<l.size();i++){
            Stack<Integer> bb=l.get(i);
            while(!bb.isEmpty()){
                System.out.println(bb.pop());
            }
        }
        while(!A.isEmpty()){
            System.out.println(A.pop());
        }
    }
    public static void primeSieve(int n, List<Integer> p){
        boolean a[]=new boolean[n+1];
        a[0]=a[1]=true;
        for (int i = 2; i*i <=n ; i++) {
            if(!a[i]){
                for (int j = 2; i*j <=n ; j++) {
                    a[i*j]=true;
                }
            }
        }
        for (int i = 0; i < n+1; i++) {
            if(!a[i])
                p.add(i);
        }
    }
}
