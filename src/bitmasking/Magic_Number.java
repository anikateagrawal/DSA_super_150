package bitmasking;

import java.util.Scanner;

/*
series of 5,25,30,125,130,150....
Find nth Magic Number
 */
public class Magic_Number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        int mul=5;
        int pow=5;
        while(n>0){
            sum+=(n&1)*pow;
            n=n>>1;
            pow=pow*mul;
        }
        System.out.println(sum);
    }
}
