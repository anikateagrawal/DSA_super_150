package exam_questions;
/*
Monu bhaiya is given a string s, his task is to remove duplicate letters so that every letter appears once and only once. he must make sure his result is the smallest in lexicographical order among all possible results.

Input Format
String

Constraints
1 <= s.length <= 104
s consists of lowercase English letters.

Output Format
Print resulting string

Sample Input
bcabc
Sample Output
abc
 */

import java.util.*;
public class Monu_Bhaiya_and_Strings {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String r="";
        int c[]=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            c[ch-'a']++;
        }
        int v[]=new int[26];
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)-'a']--;
            if(v[s.charAt(i)-'a']==0){
                while(r.length()>0&&s.charAt(i)<=r.charAt(r.length()-1)&&c[r.charAt(r.length()-1)-'a']>0){
                    v[r.charAt(r.length()-1)-'a']=0;
                    r=r.substring(0,r.length()-1);
                }
                v[s.charAt(i)-'a']=1;
                r+=s.charAt(i);
            }
        }
        System.out.println(r);
    }
}