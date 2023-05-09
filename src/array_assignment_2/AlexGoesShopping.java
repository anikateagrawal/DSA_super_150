package array_assignment_2;

import java.util.Arrays;
import java.util.Scanner;
/*
It is Alex’s birthday and she wants to go shopping. She only has ‘A’ units of money and she wants to spend all of her money. However, she can only purchase one kind of item. She goes to a shop which has ‘n’ types items with prices A0,A1,A2,…,An-1. The shopkeeper claims that he has at least ‘k’ items she can choose from. Help her find out if the shopkeeper is correct or not.

Input Format
The first line contains an integer ‘n’ denoting the number of items in the shop. The second line contains ‘n’ space-separated integers describing the respective price of each item. The third line contains an integer ‘q’ denoting the number of queries. Each of the subsequent lines contains two space-separated integers ‘A’ and ‘k’

Constraints
1 <=n, Ai, A <= 105 where 0<=i

1 <= q <= 2*n
1 <= k <= n
The array may contain duplicate elements.

Output Format
For each query, print Yes on a new line if the shopkeeper is correct; otherwise, print No instead.

Sample Input
4
100 200 400 100
6
100 2
200 3
500 4
600 4
800 4
1200 1
Sample Output
Yes
Yes
No
No
Yes
Yes
Explanation
In query 1, Alex has 100 units of money. The shopkeeper claims that she can choose to buy from 2 kinds of items i.e. item 1 and item 4 each priced at 100.

In query 2, The shopkeeper claims that she can choose to buy from 3 kinds of items ie item 1 and item 4 each priced at 100(she can buy 1 from either of the two), or item 2 priced at 200(she can buy one)

In query 3, she has 500 units of money. She can either buy item 1 or item 4 ( 5 of each kind respectively). Thus, she has only 2 kinds of items to choose from.

In query 5, she has 800 units of money. She can either buy item 1 or item 4 ( 8 of each kind respectively) or item 2(she can buy 4 of these) or item 3(2 of these). Thus, she has 4 kinds of items to choose from.

In query 6, she has 1200 units of money. She can either buy item all types of items to use up her money. Thus, she has 4 kinds of items to choose from. As Shopkeeper as at least 1. Shopkeeper is Correct
 */
public class AlexGoesShopping {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        Arrays.sort(a);
        int q=sc.nextInt();
        while(q-->0){
            int m=sc.nextInt();
            int k=sc.nextInt();
            if(fun(a,m,k))System.out.println("Yes");
            else System.out.println("No");
        }
    }
    static boolean fun(int []a,int m,int k){

        int kk=0;
        for(int i=0;i<a.length;i++){
            //System.out.println(m+" "+k+" "+a[i]);
            if(m%a[i]==0){
                kk++;
            }
            if(kk==k)return true;
        }
        return false;
    }
}
