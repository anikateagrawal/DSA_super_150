package sorting;

import java.util.Scanner;

public class Merge_Sort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        mergeSort(a,0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
    static void mergeSort(int a[],int p,int r){
        if(p<r){
            int q=(p+r)/2;
            mergeSort(a,p,q);
            mergeSort(a,q+1,r);
            merge(a,p,q,r);
        }
    }
    static void merge(int a[],int p,int q,int r){
        int n1=q-p+1;
        int n2=r-q;
        int L[]=new int[n1+1];
        int R[]=new int[n2+1];
        L[n1]=Integer.MAX_VALUE;
        R[n2]=Integer.MAX_VALUE;
        for (int i = 0; i <n1 ; i++) {
            L[i]=a[p+i];
        }
        for (int i = 0; i < n2; i++) {
            R[i]=a[q+1+i];
        }
        int i=0,j=0;
        for (int k = p; k <=r ; k++) {
            if(L[i]<=R[j]){
                a[k]=L[i];
                i=i+1;
            }
            else {
                a[k]=R[j];
                j=j+1;
            }
        }
    }
}
