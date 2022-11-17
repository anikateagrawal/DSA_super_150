package mix;

import java.util.Arrays;
import java.util.Scanner;

public class Aggressive_cows {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int c=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)arr[i]=sc.nextInt();
            Arrays.sort(arr);
            System.out.println(largestMinimumDistance(arr,c));
        }
    }
    public static int largestMinimumDistance(int []arr,int c){
        int lo=0;
        int hi=arr[arr.length-1]-arr[0];
        int ans=0;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(isPossible(arr,mid,c)){
                ans=mid;
                lo=mid+1;
            }
            else hi=mid-1;
        }
        return ans;
    }
    public static boolean isPossible(int[] arr,int d,int c){
        int cow=1;
        int pos=arr[0];
        for(int i=1;i<arr.length;i++) {
            if (arr[i] - pos >= d) {
                cow++;
                pos = arr[i];
            }
            if(cow==c)return true;
        }
        return false;
    }
}
