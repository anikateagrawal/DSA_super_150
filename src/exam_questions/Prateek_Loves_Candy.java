package exam_questions;

/*
Prateek recently graduated from college. To celebrate, he went to a candy shop and bought all the candies. The total cost was a number upto which there are n prime numbers (starting from 2). Since Prateek wants to minimize his cost, he calls you to help him find the minimum amount that needs to be paid. Being a student of Prateek bhaiya it is now your job to help him out :)

Input Format
First line contains a single integer denoting the number of test cases T. Next T lines contains a single integer N, denoting the number of primes required.

Constraints
T <= 10000

It is guaranteed that the answer does not exceed 10^6.

Output Format
Print the minimum cost that needs to be paid.

Sample Input
2
5
1
Sample Output
11
2
Explanation
In the first case there are 5 primes upto 11(2,3,5,7,11).
 */
import java.util.*;
public class Prateek_Loves_Candy {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        ArrayList<Integer> p=new ArrayList<>();
        prime(p);
        while(t-->0){
            int n=sc.nextInt();
            System.out.println(p.get(n-1));
        }
    }
    static void prime(ArrayList<Integer> p){
        boolean a[]=new boolean[1000001];
        a[0]=a[1]=true;
        for(int i=2;i<a.length;i++){
            if(!a[i]){
                p.add(i);
                for(int j=2;j*i<a.length;j++){
                    a[j*i]=true;
                }
            }
        }
    }
}
