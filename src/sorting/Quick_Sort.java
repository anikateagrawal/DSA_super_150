package sorting;

import java.util.Arrays;

public class Quick_Sort {
    static void quickSort(int a[],int s,int e){
        if(s<e){
            int q=partition(a,s,e);
            System.out.println(Arrays.toString(a));
            quickSort(a,s,q);
            quickSort(a,q+1,e);
        }
    }
    static int partition(int a[],int s,int e){
        int key=a[s];
        int i=s-1;
        int j=e+1;
        while(true){
            i++;
            while (a[i]<key)i++;
            j--;
            while (a[j]>key)j--;
            if(i>=j)return j;
            else {
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }
    }

    public static void main(String[] args) {
        int a[]={6,4,1,7,5,3,2,3};
        quickSort(a,0,a.length-1);
        System.out.println();
        System.out.println(Arrays.toString(a));
    }
}
