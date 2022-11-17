package mix;

import java.util.Scanner;

public class Vowel_subString_count {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        s=s.toLowerCase();
        int m=0,c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                c++;
            }
            else{
                if(c>m)m=c;
                c=0;
            }
        }
        if(c>m)m=c;
        System.out.println(m);

    }
}


