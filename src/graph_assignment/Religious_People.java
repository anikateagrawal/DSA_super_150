package graph_assignment;

/*
All the people living in our imaginary world Bitworld are very religious.
There are N cities in Bitworld numbered from 1 to N.
Due to a storm, every road in Bitworld was destroyed and now no temples are left.
There are 2 types of operations :

You can construct a temple by giving away A dollars in ith city.
You can repair an already existing road by giving away B dollars.

Your goal is to make temples such that people of every city have access to some temple.
People of the ith city can visit the temple only if :
A temple exists in that city.
OR
There is a path from that city to a city which contains a temple. ( the path should consist of repaired roads only )
You have to minimize the total cost such that people in every city can go to a temple and output this minimum cost.

NOTE : You can only repair the roads which existed and not build on your own.

Input Format
The first line consists of number of test cases T. Each test case consists of 4 integers N,M,A,B. which denote number of cities, number of roads which existed , cost to build a temple , cost to repair a road. Next M lines contains M pairs denoted by U V which indicates a road existed between U and V.

Constraints
1 <= T <= 10.
1 <= N <= 100000.
0 <= M <= 100000.
1 <= A,B <= 1000000000.
1 <= U,V <= N.
Each road connects 2 distinct cities.

Output Format
Total minimum cost in dollars.

Sample Input
2
3 3 2 1
1 2
3 1
2 3
6 6 2 5
1 3
3 4
2 4
1 2
2 3
5 6
Sample Output
4
12
Explanation
For first test case:

build temple in city 1 for 2 dollars.
repair road between 1 and 2 and repair road between 2 and 3 for total cost of 1+1 dollars. hence total cost is 4 dollars.
For second test case: You can build a temple in every city for a total cost of 6*2 = 12 dollars.
 */
import java.util.*;
public class Religious_People {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int r=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            List<List<Integer>> l=new ArrayList<>();
            for(int i=0;i<=n;i++)l.add(new ArrayList<>());
            for(int i=0;i<r;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                l.get(x).add(y);
                l.get(y).add(x);
            }
            List<Integer> len=new ArrayList<>();
            boolean v[]=new boolean[n+1];
            int c=0;
            for(int i=1;i<=n;i++){
                if(!v[i]){
                    c++;
                    e=0;
                    dfs(l,i,v);
                    len.add(e-1);
                }
            }
            long ans=0;
            if(a<b){
                ans=1L*a*n;
            }
            else{
                ans+=1L*a*c;
                for(int i:len){
                    ans+=1L*b*i;
                }
            }
            System.out.println(ans);
        }
    }
    static int e;
    static void dfs(List<List<Integer>> l,int src,boolean v[]){
        v[src]=true;
        e++;
        for(int n:l.get(src)){
            if(!v[n]){
                dfs(l,n,v);
            }
        }
    }
}
