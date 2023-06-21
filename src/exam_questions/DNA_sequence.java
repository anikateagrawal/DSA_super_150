package exam_questions;

/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Input Format
Input a string

Constraints
String will contain only A,C,G,T in uppercase

Output Format
Print Substrings in space separated manner

Sample Input
AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT
Sample Output
AAAAACCCCC CCCCCAAAAA
Explanation
substrings which occur more than once in the DNA sequence is AAAAACCCCC(from index 0 -9 and index 10-19) and CCCCCAAAAA (from index
 */
import java.util.*;
public class DNA_sequence {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        HashMap<String,Integer> m=new HashMap<>();
        for(int i=0;i+10<=s.length();i++){
            String sub=s.substring(i,i+10);
            if(m.containsKey(sub)){
                int v=m.get(sub);
                if(v!=-1)System.out.print(sub+" ");
                m.put(sub,-1);
            }
            else m.put(sub,1);
        }

    }
}
