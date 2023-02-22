package codeforces;

import java.util.Scanner;

public class Non_alternating_Deck {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            int i=0;
            int a=0,b=0;
            int tot=0;
            while(tot+i<=n){
                if((i/2)%2==0){
                    a+=i;
                }
                else{
                    b+=i;
                }
                tot+=i;
                i++;
            }
            if((i/2)%2==0){
                a+=n-tot;
            }
            else{
                b+=n-tot;
            }
            System.out.println(a+" "+b);
        }
    }
}
