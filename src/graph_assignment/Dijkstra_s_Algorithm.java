package graph_assignment;

/*
Given a graph consisting 'N' nodes (labeled 1 to N) where a specific given node 'S' represents the starting position and an edge between two nodes is of a given length, which may or may not be equal to other lengths in the graph.

It is required to calculate the shortest distance from the start position (Node 'S') to all of the other nodes in the graph.

If a node is unreachable, the distance is assumed as -1.

Input Format
The first line contains T, denoting the number of test cases. First line of each test case has two integers N, M denoting the number of nodes in the graph and, denoting the number of edges in the graph.

The next M lines each consist of three space-separated integers x,y,r where x and y denote the two nodes between which the undirected edge exists, 'r' denotes the length of edge between these corresponding nodes.

The last line has an integer, 'S' denoting the starting position.

Constraints
1 <= N <= 3000 1 <= M <= (N*(N-1))/2 1 <= x,y <= N 1 <= r <= 10^5

Output Format
For each of the T test cases, print a single line consisting N-1 space separated integers denoting the shortest distance of N-1 nodes other than from starting position S in increasing order of their labels.

For unreachable nodes, print -1.

Sample Input
1
4 4
1 2 24
1 4 20
3 1 3
4 3 12
1

Sample Output
24 3 15
 */
import java.util.*;
public class Dijkstra_s_Algorithm {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int e=sc.nextInt();
            List<List<int[]>> m=new ArrayList<>();
            for(int i=0;i<=n;i++)m.add(new ArrayList<>());
            for(int i=0;i<e;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                int c=sc.nextInt();
                m.get(a).add(new int[]{b,c});
                m.get(b).add(new int[]{a,c});
            }
            boolean v[]=new boolean[n+1];
            int d[]=new int[n+1];
            Arrays.fill(d,-1);
            int src=sc.nextInt();
            PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[1]-b[1]);
            q.add(new int[]{src,0});
            while(!q.isEmpty()){
                int f[]=q.poll();
                if(v[f[0]])continue;
                v[f[0]]=true;
                d[f[0]]=f[1];
                for(int nb[]:m.get(f[0])){
                    if(!v[nb[0]]){
                        q.add(new int[]{nb[0],f[1]+nb[1]});
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
