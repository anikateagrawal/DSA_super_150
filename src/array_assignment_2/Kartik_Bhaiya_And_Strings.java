package array_assignment_2;

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
public class Kartik_Bhaiya_And_Strings {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int kk=k;
        sc.nextLine();
        String s=sc.nextLine();
        int ei=0,si=0,max=0;
        while(ei<s.length()){
            if(s.charAt(ei)=='a')k--;
            while(si<=ei&&k<0){
                if(s.charAt(si)=='a')k++;
                si++;
            }
            max=Math.max(max,ei-si+1);
            ei++;
        }
        k=kk;
        ei=0;si=0;int max2=0;
        while(ei<s.length()){
            //System.out.println(k+" "+ei+" "+si);
            if(s.charAt(ei)=='b')k--;
            while(si<=ei&&k<0){
                if(s.charAt(si)=='b')k++;
                si++;
            }
            max2=Math.max(max2,ei-si+1);
            ei++;
        }
        max=Math.max(max,max2);
        System.out.println(max);
    }
}
