package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Cycle_In_Directed_Graph {
    private HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();

    public Cycle_In_Directed_Graph(int v){
        for (int i = 1; i <=v ; i++) {
            map.put(i,new HashMap<>());
        }
    }
    public void addEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
    }
    public int [] indegree(){
        int []in=new int[map.size()+1];
        for(int i:map.keySet()){
            for(int j:map.get(i).keySet()){
                in[j]++;
            }
        }
        return in;
    }

    public boolean Topological_Sort(){
        int []in=indegree();
        Queue<Integer> q=new LinkedList<>();
        for (int i = 1; i <in.length ; i++) {
            if(in[i]==0)q.add(i);
        }
        int count=0;
        while (!q.isEmpty()){
            int f=q.poll();
            System.out.print(f+" ");
            count++;
            for(int i:map.get(f).keySet()){
                in[i]--;
                if(in[i]==0)q.add(i);
            }
        }
        return count!=map.size();
    }

    public static void main(String[] args) {
        Cycle_In_Directed_Graph g=new Cycle_In_Directed_Graph(8);
        g.addEdge(1,2,6);
        g.addEdge(2,4,10);
        g.addEdge(3,1,7);
        g.addEdge(3,2,7);
        g.addEdge(4,5,7);
        g.addEdge(4,6,7);
        g.addEdge(5,6,7);
        g.addEdge(7,8,7);
        System.out.println(g.Topological_Sort());
        Cycle_In_Directed_Graph g2=new Cycle_In_Directed_Graph(8);
        g2.addEdge(1,4,6);
        g2.addEdge(1,2,10);
        g2.addEdge(2,3,7);
        g2.addEdge(3,4,5);
        g2.addEdge(4,5,1);
        g2.addEdge(5,6,4);
        g2.addEdge(7,5,2);
        g2.addEdge(6,7,3);
        System.out.println(g2.Topological_Sort());
    }
}
