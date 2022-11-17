package mix;

import java.util.Scanner;

public class pseudo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s1=sc.next();
        String s2=sc.next();
        int a1[]=change(s1);
        int a2[]=change(s2);
        int f=0;
        String ans;
        if(s1.compareTo(s2)<=0)ans=s1;else ans=s2;
        for(int i=0;i<a1.length;i++){
            if(Math.abs(a1[i]-a2[i])>3){
                f=1;
                break;
            }
        }
        if(f==0) System.out.println(ans);
        else System.out.println("-1");
    }
    static int[] change(String s){
        int a[]=new int[26];
        for(char c:s.toCharArray()){
            a[c-'a']++;
        }
        return a;
    }
}
