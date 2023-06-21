package exam_questions;

/*
You are given a Complete graph.
Complete graph: A graph in which each vertex is connected to every other vertex is called a complete graph.



Ayan has a lot of useless stuff in his drawers, a considerable part of which are his science notebooks: it is time to sort them out. This time he found an old dusty graph theory notebook with a description of a graph.

It is an undirected weighted graph on n vertices. It is a complete graph: each pair of vertices is connected by an edge. The weight of each edge is either 0 or 1 ; exactly m edges have weight 1 , and all others have weight 0 .

Since Ayan doesn't really want to organize his notes, he decided to find the number of components of the minimum cost of the graph. Can you find the answer for Ayan so he stops procrastinating?

Input Format
The first line of the input contains two integers n and m
(1≤n≤10^5 , 0≤m≤min(n(n−1)2,10^5) ), the number of vertices and the number of edges of weight 1 in the graph.

The i -th of the next m lines contains two integers ai and bi (1≤ai,bi≤n , ai≠bi ), the endpoints of the i -th edge of weight 1 .

It is guaranteed that no edge appears twice in the input.

Constraints
(1≤n≤10^5 , 0≤m≤min(n(n−1)2,10^5) )
(1≤ai,bi≤n , ai≠bi )

Output Format
Output a single integer, the number of the components of minimum cost of the graph

Sample Input
6 11
1 3
1 4
1 5
1 6
2 3
2 4
2 5
2 6
3 4
3 5
3 6
Sample Output
3
 */
import java.util.*;
public class Monu_bhaiya_and_spams {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<TreeSet<Integer>> m=new ArrayList<>();
        for(int i=0;i<n;i++){
            m.add(new TreeSet<>());
        }
        int mm=sc.nextInt();
        for(int i=0;i<mm;i++){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            m.get(a).add(b);
            m.get(b).add(a);
        }
        TreeSet<Integer> unv=new TreeSet<>();
        for(int i=0;i<n;i++)unv.add(i);
        int c=0;
        for(int i=0;i<n;i++){
            if(unv.contains(i)){
                c++;
                unv.remove(i);
                dfs(i,unv,m);
            }
        }
        System.out.println(c);
    }
    static void dfs(int s,TreeSet<Integer> un,List<TreeSet<Integer>> m){
        TreeSet<Integer> nb=m.get(s);
        List<Integer> nn=new ArrayList<>();
        for(int i:un){
            if(!nb.contains(i)){
                nn.add(i);
            }
        }
        for(int i:nn)un.remove(i);
        for(int i:nn)dfs(i,un,m);

    }
}
