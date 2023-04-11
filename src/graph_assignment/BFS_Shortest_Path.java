package graph_assignment;

/*
Consider an undirected graph consisting of 'n' nodes where each node is labeled from 1 to n and the edge between any two nodes is always of length 6 . We define node 's' to be the starting position for a BFS.

Given 'q' queries in the form of a graph and some starting node, 's' , perform each query by calculating the shortest distance from starting node 's' to all the other nodes in the graph. Then print a single line of n-1 space-separated integers listing node s's shortest distance to each of the n-1 other nodes (ordered sequentially by node number); if 's' is disconnected from a node, print -1 as the distance to that node.

Input Format
The first line contains an integer,q , denoting the number of queries. The subsequent lines describe each query in the following format:

Each line contains N and M, the number of nodes and edges respectively.

The next m lines contains u and v means that there is edge between u and v .

The last line contains 's', the starting node.

Constraints
1 <= q <= 10 2 <= n <= 1000 1 <= m <= (n*(n-1))/2 1 <= u,s,v <= n

Output Format
You have to print n-1 integer denoting the shortest distance from s to all other nodes excluding s itself.

Sample Input
2
4 2
1 2
1 3
1
3 1
2 3
2
Sample Output
6 6 -1
-1 6
 */
import java.util.*;
public class BFS_Shortest_Path {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int e=sc.nextInt();
            List<List<Integer>> l=new ArrayList<>();
            for(int i=0;i<=n;i++)l.add(new ArrayList<>());
            for(int i=0;i<e;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                l.get(a).add(b);
                l.get(b).add(a);
            }
            int src=sc.nextInt();
            int d[]=new int[n+1];
            Arrays.fill(d,-1);
            d[src]=0;
            Queue<Integer> q=new LinkedList<>();
            q.add(src);
            while(!q.isEmpty()){
                int f=q.poll();
                for(int nb:l.get(f)){
                    if(d[nb]==-1){
                        d[nb]=d[f]+6;
                        q.add(nb);
                    }
                }
            }
            for(int i=1;i<=n;i++){
                if(i==src)continue;
                System.out.print(d[i]+" ");
            }
            System.out.println();
        }
    }
}
