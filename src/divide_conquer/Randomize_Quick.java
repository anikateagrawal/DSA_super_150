package divide_conquer;

import java.util.Arrays;
import java.util.Random;

public class Randomize_Quick {
    public static void main(String[] args) {
        int a[]={5,7,2,3,8,9,1,4};
        quick(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void quick(int a[],int s,int e){
        if(s>=e)return;
        Random r=new Random();
        int rn=r.nextInt(e-s+1)+s;
        int tmp=a[e];
        a[e]=a[rn];
        a[rn]=tmp;

        int pi=s;
        for (int i = s; i <=e; i++) {
            if(a[i]<=a[e]){
                int t=a[i];
                a[i]=a[pi];
                a[pi]=t;
                pi++;
            }
        }
        quick(a,s,pi-2);
        quick(a,pi,e);
    }
}

