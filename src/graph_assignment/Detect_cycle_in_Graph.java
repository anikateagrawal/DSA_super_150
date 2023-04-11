package graph_assignment;

/*
Given a undirected unweighted graph with N number of vertices and M number of edges. Vertices are numbered from 1 to N. Detect if there exists any cycle in graph. Note: There is no multi edge or self loop in graph.

Input Format
T: number of test cases N: number of vertices M: number of edges Each of next N line contains two pair of integers denoting bidirectional edge between them.

Constraints
1<=N<=100000 1<=M<=500000

Output Format
Print “yes” (without quotes) if there exists a cycle in graph else print “no” (without quotes).

Sample Input
1
5  5
1 2
2 3
4 5
1 4
1 3
Sample Output
yes
 */
import java.util.*;
public class Detect_cycle_in_Graph {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int e=sc.nextInt();
            Map<Integer,List<Integer>> m=new HashMap<>();
            for(int i=1;i<=n;i++){
                m.put(i,new ArrayList<>());
            }
            for(int i=0;i<e;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                m.get(a).add(b);
                m.get(b).add(a);
            }
            if(cycle(m,n))System.out.println("yes");
            else System.out.println("no");
        }
    }
    static boolean cycle(Map<Integer,List<Integer>> m,int n){
        boolean v[]=new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(v[i])continue;
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int f=q.poll();
                if(v[f])return true;
                v[f]=true;
                for(int nb:m.get(f)){
                    if(!v[nb])q.add(nb);
                }
            }
        }
        return false;
    }
}
