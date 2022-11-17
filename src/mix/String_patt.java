package mix;

import java.util.Scanner;

public class String_patt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <s.length()-i+1; j++) {
                System.out.println(s.substring(j,j+i));
            }
        }
    }
}
