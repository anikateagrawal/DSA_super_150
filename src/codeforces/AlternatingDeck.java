package codeforces;

import java.util.Scanner;

public class AlternatingDeck {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            int aw=0,ab=0,bw=0,bb=0;
            int r=0;
            int k=1,kk=1;
            for(int i=1;i<=n;i++){
                if(r==0){
                    if(i%2==1){
                        aw++;
                    }
                    else ab++;
                }
                else{
                    if(i%2==0)bw++;
                    else bb++;
                }
                if(i==kk){
                    r=r==1?0:1;
                    k+=4;
                    kk+=k;
                }
            }
            System.out.println(aw+" "+ab+" "+bb+" "+bw);
        }
    }
}
