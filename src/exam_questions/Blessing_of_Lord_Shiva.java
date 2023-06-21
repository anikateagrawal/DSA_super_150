package exam_questions;

/*
Martin is a devotee of Lord Shiva. Upon noticing his good deeds and austerity, Lord Shiva asked Martin to make a wish and He will make that true but for that Martin was required to prove his knowledge. So, Lord Shiva gave him a binary string of a's and b's and asked him to make this string a sequence of alternate characters by flipping minimum number of characters possible. Now, its your duty to help Martin.

Input Format
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consists of one line. The line contains a string of a's and b's.

Constraints
1 ≤ T ≤ 100
1 ≤ string length ≤ 1000

Output Format
Minimum number of characters to be removed to make string alternate.

Sample Input
2
ababa
bbbb
Sample Output
0
2
 */
import java.util.*;
public class Blessing_of_Lord_Shiva {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int f=0;
            for(int i=0;i<s.length();i++){
                if(i%2==0&&s.charAt(i)!='a'){
                    f++;
                }
                else if(i%2==1&&s.charAt(i)!='b'){
                    f++;
                }
            }
            int f2=0;
            for(int i=0;i<s.length();i++){
                if(i%2==0&&s.charAt(i)!='b')f2++;
                else if(i%2==1&&s.charAt(i)!='a')f2++;
            }
            System.out.println(Math.min(f,f2));
        }
    }
}
