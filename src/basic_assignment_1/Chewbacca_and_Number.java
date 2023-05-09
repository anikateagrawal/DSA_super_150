package basic_assignment_1;

import java.util.Scanner;
/*
Luke Skywalker gave Chewbacca an integer number x. Chewbacca isn't good at numbers but he loves inverting digits in them. Inverting digit t means replacing it with digit 9 - t.

Help Chewbacca to transform the initial number x to the minimum possible positive number by inverting some (possibly, zero) digits. The decimal representation of the final number shouldn't start with a zero.

Input Format
The first line contains a single integer x (1 ≤ x ≤ 10^18) — the number that Luke Skywalker gave to Chewbacca.

Constraints
x <= 100000000000000000

Output Format
Print the minimum possible positive number that Chewbacca can obtain after inverting some digits. The number shouldn't contain leading zeroes.

Sample Input
4545
Sample Output
4444
Explanation
There are many numbers form after inverting the digit. For minimum number, check if inverting digit is less than or greater than the original digit. If it is less, then invert it otherwise leave it.


 */
public class Chewbacca_and_Number {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        String nn="";
        while(n>0){
            long d=n%10;
            if(9-d<d){
                nn=""+(9-d)+nn;
            }
            else nn=""+d+nn;
            n/=10;
        }
        if(nn.charAt(0)=='0'){
            nn="9"+nn.substring(1);
        }
        System.out.println(Long.parseLong(nn));
    }
}
