package divide_conquer;

import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int a[]={5,1,8,3,4};
        a=sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static int[] sort(int a[],int s,int e){
        if(s>=e)
        {
            int [] bs=new int[1];
            bs[0]=a[e];
            return bs;
        }
        int m=(s+e)/2;
        int a1[]=sort(a,s,m);
        int a2[]=sort(a,m+1,e);
        return merge(a1,a2);
    }
    public static int[] merge(int a[],int b[]){
        int i=0,j=0,k=0;
        int r[]=new int[a.length+b.length];
        while(i<a.length&&j<b.length){
            if(a[i]<b[j]){
                r[k++]=a[i++];
            }
            else {
                r[k++]=b[j++];
            }
        }
        while(i<a.length){
            r[k++]=a[i++];
        }
        while (j<b.length){
            r[k++]=b[j++];
        }
        return r;
    }
}
