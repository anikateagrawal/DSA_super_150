package recursion;

import java.util.*;
import java.util.Scanner;

public class Letter_Tile {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int f[]=new int[26];
        for (int i = 0; i < s.length(); i++) {
            f[s.charAt(i)-'A']++;
        }
        System.out.println(Letter(f,""));
    }
    public static int Letter(int[] f,String ans){
        int count=0;
        for (int i = 0;i<f.length; i++) {
            if(f[i]!=0){
                f[i]--;
                char ch=(char)(i+'A');
                count+=Letter(f,ans+ch)+1;
                f[i]++;
            }
        }
        return count;
    }
}
