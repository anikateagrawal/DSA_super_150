package mix;

import java.util.Scanner;

public class First_non_repeat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            char a[]=s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                int j=0;
                if(a[i]==0)continue;
                for (j = i+1; j < s.length(); j++) {
                    //System.out.println(s.charAt(i)+" "+s.charAt(j));
                    if(s.charAt(i)==s.charAt(j)) {
                        a[j]=0;
                        break;
                    }
                }
                if(j==s.length()){ System.out.println(s.charAt(i));
                break;
                }
            }
        }
    }
}
