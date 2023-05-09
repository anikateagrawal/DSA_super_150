package string_assignment_3;

import java.util.Scanner;
/*
Kartik Bhaiya has a string consisting of only 'a' and 'b' as the characters. Kartik Bhaiya describes perfectness of a string as the maximum length substring of equal characters. Kartik Bhaiya is given a number k which denotes the maximum number of characters he can change. Find the maximum perfectness he can generate by changing no more than k characters.

Input Format
The first line contains an integer denoting the value of K. The next line contains a string having only ‘a’ and ‘b’ as the characters.

Constraints
2 ≤ N ≤ 10^6

Output Format
A single integer denoting the maximum perfectness achievable.

Sample Input
2
abba
Sample Output
4
Explanation
We can swap the a's to b using the 2 swaps and obtain the string "bbbb". This would have all the b's and hence the answer 4.
Alternatively, we can also swap the b's to make "aaaa". The final answer remains the same for both cases.
 */
public class kartIk_and_strings {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        sc.nextLine();
        String s=sc.nextLine();
        int ei=0,si=0;
        int k=a;
        int max=0;
        while(ei<s.length()){
            if(s.charAt(ei)=='a')k--;
            while(si<=ei&&k<0){
                if(s.charAt(si++)=='a')k++;
            }
            max=Math.max(max,ei-si+1);
            ei++;
        }
        ei=0;si=0;k=a;
        while(ei<s.length()){
            if(s.charAt(ei)=='b')k--;
            while(si<=ei&&k<0){
                if(s.charAt(si++)=='b')k++;
            }
            max=Math.max(max,ei-si+1);
            ei++;
        }
        System.out.println(max);
    }
}
