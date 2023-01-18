package mix2;
/*
A short counting problem
Problem
Given two integers A and B, find the count of integers X∈[L,R] such that at least one of the following is true:

X and A are coprime
X and B are coprime

Input Format
The first and only line of input contains four integers

A,B,L, and R: as given in the problem statement.
Output Format
Print a single integer denoting the count of integers
X satisfying the condition.
Constraints
1≤A,B≤10^9
1≤L≤R≤10^18

Sample 1:
Input
6 15 1 10
Output
6
Explanation:
There are
6
6 numbers that satisfy the condition:
1,2,4,5,7,8.

Sample 2:
Input
235714494 193478285 2 100000000000
Output
65435081000
 */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        long l=sc.nextLong();
        long r=sc.nextLong();
        Set<Long> pa=new HashSet();
        prime(a,pa);
        Set<Long> pb=new HashSet();
        prime(b,pb);

        List<List<Long>> a1=new ArrayList();
        for(int i=0;i<=pa.size();i++)a1.add(new ArrayList());
        fun(new ArrayList(pa),0,a1,1,0);
        a1.remove(0);
        long c1=coprime(a1,l,r);
        System.out.println(c1);
        List<List<Long>> a2=new ArrayList();
        for(int i=0;i<=pb.size();i++)a2.add(new ArrayList());
        fun(new ArrayList(pb),0,a2,1,0);
        a2.remove(0);
        long c2=coprime(a2,l,r);

        Set<Long> p=new HashSet(pa);
        p.addAll(pb);

        List<List<Long>> a3=new ArrayList();
        for(int i=0;i<=p.size();i++)a3.add(new ArrayList());
        fun(new ArrayList(p),0,a3,1,0);
        a3.remove(0);
        long c3=coprime(a3,l,r);
        if(a==1||b==1)System.out.println(r-l+1);
        else
            System.out.println(c2-c3+c1);
    }
    static void fun(List<Long> s,int in,List<List<Long>> ans,long p,int c){
        if(in==s.size()){
            ans.get(c).add(p);
            return;
        }
        fun(s,in+1,ans,p*s.get(in),c+1);
        fun(s,in+1,ans,p,c);
    }
    static long coprime(List<List<Long>> cc,long l,long r){
        long ans=r-l+1;
        int sn=-1;
        for(List<Long> c:cc){
            for(long i:c){
                long fm=l;
                if(l%i!=0)fm+=i-l%i;
                long lm=r;
                if(r%i!=0)lm-=r%i;
                if((lm-fm)/i+1>0)
                    ans+=sn*((lm-fm)/i+1);
            }
            sn*=-1;
        }
        return ans;
    }
    static void prime(int n,Set<Long> s){
        if (n>0)
        {
            while (n%2==0)
            {
                s.add(2L);
                n /= 2;
            }
            for (int i = 3; i <= Math.sqrt(n); i+= 2)
            {
                while (n%i == 0)
                {
                    s.add((long)i);
                    n /= i;
                }
            }
            if (n > 2)s.add((long)n);
        }
    }
}
