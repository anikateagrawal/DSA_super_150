package mix;

import java.util.Scanner;

public class _Compare {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(compare(s,s2));
    }
    static int compare(String s1,String s2){
        int i=0,j=0;
        while(i<s1.length()&&j<s2.length()){
            if(s1.charAt(i)>s2.charAt(j)){
                return s1.charAt(i)-s2.charAt(j);
            }
            else if(s1.charAt(i)<s2.charAt(j)){
                return s2.charAt(j)-s1.charAt(i);
            }
            i++;
            j++;
        }
        return s1.length()-s2.length();
    }
}
