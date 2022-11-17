package mix;

import java.util.Scanner;

public class book_allocation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int page[]={10,20,30,40};
        int nos=2;
        System.out.println(minpage(page,nos));
    }
    public static int minpage(int []page,int nos){
        int hi=0;
        for (int i = 0; i < page.length; i++) {
            hi+=page[i];
        }
        int lo=0;
        int ans=0;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(isPossible(page,mid,nos)){
                ans=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }
        return ans;
    }
    public static boolean isPossible(int []page,int d,int s){
        int ss=1;
        int read_page=0;
        for (int i = 0; i < page.length; i++) {
            if(read_page+page[i]<=d){
                read_page+=page[i];
            }
            else{
                read_page=0;
                ss++;
                i--;
            }
            if(ss>s)return false;
        }
        return true;
    }
}
