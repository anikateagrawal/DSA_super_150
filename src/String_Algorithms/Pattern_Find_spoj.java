package String_Algorithms;
/*
3
ababab ab
aaaaa bbb
aafafaasf aaf
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Rabin Karp
public class Pattern_Find_spoj {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            String s=sc.next();
            String p=sc.next();
            RabinKarp(s,p);
        }
    }
    public static void RabinKarp(String s,String t){
        int hash=hashCode(t,new int[t.length()+1],new int[t.length()]);
        int dp[]=new int[s.length()+1];
        int p[]=new int[s.length()];
        hashCode(s,dp,p);
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<=s.length()-t.length();i++){
            if(s.charAt(i)!=t.charAt(0))continue;
            int sub=(dp[i+t.length()]-dp[i]);
            if(sub==(int)((hash*p[i])%mod+mod)%mod)l.add(i);
        }
        if(l.size()==0){
            System.out.println("Not Found");
            System.out.println();
        }
        else{
            System.out.println(l.size());
            for(int i:l) System.out.print((i+1)+" ");
            System.out.println("\n");
        }
    }
    static long mod=1000_000_007;
    public static int hashCode(String s,int dp[],int p[]){
        int pow=1;
        long ans=0;
        int prime=31;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            ans=(ans+((ch-'a'+1)*pow%mod)%mod+mod)%mod;
            ans=(ans+mod)%mod;
            dp[i+1]=(int)ans;
            p[i]=pow;
            pow=(int)(((pow*prime)%mod+mod)%mod);
        }
        return (int)ans;
    }
}
