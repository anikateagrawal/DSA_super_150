package mix;

import java.util.Arrays;

public class Arr {
    public static void main(String[] args) {
        int a[]={2,3,-1,4,7,11,9};
        //System.out.println(Arrays.toString(a));
        int i=0,j=a.length-1;
        while(i<j){
            int t=a[i];
            a[i]=a[j];
            a[j]=t;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(a));
    }
}
