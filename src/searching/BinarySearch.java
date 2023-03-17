package searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int v=sc.nextInt();
        System.out.println(binarySearch(a,v));
        System.out.println(binarySearchRecursive(a,0,a.length-1,v));
    }
    public static int binarySearch(int a[],int v){
        int lo=0,hi=a.length-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(a[mid]==v)return mid;
            else  if(a[mid]<v)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
    public static int binarySearchRecursive(int a[],int lo,int hi,int v){
        if(lo>hi)return -1;
        int mid=lo+(hi-lo)/2;
        if(a[mid]==v)return mid;
        else if(a[mid]<v)return binarySearchRecursive(a,mid+1,hi,v);
        else return binarySearchRecursive(a,lo,mid-1,v);
    }
}
