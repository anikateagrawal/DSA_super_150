package dp_assignment;

/*
You are given a string. You need to partition that string such that each substrings after partitioning would be palindromic string. You have to do this work with minimum number of partitioning.

Input Format
First line contains integer t which is number of test case. For each test case, it contains a string S.

Constraints
1<=t<=50 1<=S<=1000

Output Format
Print the minimum number of partitioning.

Sample Input
1
ababbbabbababa
Sample Output
3
Explanation
a|babbbab|b|ababa
 */
import java.util.*;
public class Palindrome_Partitioning {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            Integer dp[]=new Integer[s.length()];
            System.out.println(Partitioning(s,0,new ArrayList<>(),dp));
        }
    }
    public static int Partitioning(String ques,int i,List<String> ll,Integer dp[]){
        if(ques.length()==i){
            return -1;
        }
        if(dp[i]!=null)return dp[i];
        int ans=Integer.MAX_VALUE;
        for (int cut = 1;i+ cut <= ques.length(); cut++) {
            String s=ques.substring(i,i+cut);
            if(isPalin(s)){
                ll.add(s);
                ans=Math.min(ans,1+Partitioning(ques,i+cut,ll,dp));
                ll.remove(ll.size()-1);
            }
        }
        return dp[i]=ans;
    }
    static boolean isPalin(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;j--;
        }
        return true;
    }
}
