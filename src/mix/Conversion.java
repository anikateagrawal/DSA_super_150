package mix;

import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int mul=1;
        int sum=0;
        while(n>0){
            int r=n%10;
            sum+=r*mul;
            mul*=5;
            n/=10;
        }
        System.out.println(sum);
    }
}
