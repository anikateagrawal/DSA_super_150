package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Topological_Sort {
    private HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();

    public Topological_Sort(int v){
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

    public void Topological_Sort(){
        int []in=indegree();
        Queue<Integer> q=new LinkedList<>();
        for (int i = 1; i <in.length ; i++) {
            if(in[i]==0)q.add(i);
        }
        while (!q.isEmpty()){
            int f=q.poll();
            System.out.print(f+" ");
            for(int i:map.get(f).keySet()){
                in[i]--;
                if(in[i]==0)q.add(i);
            }
        }
    }

    public static void main(String[] args) {
        Topological_Sort g=new Topological_Sort(8);
        g.addEdge(1,2,6);
        g.addEdge(2,4,10);
        g.addEdge(3,1,7);
        g.addEdge(3,2,7);
        g.addEdge(4,5,7);
        g.addEdge(4,6,7);
        g.addEdge(5,6,7);
        g.addEdge(7,8,7);
        g.Topological_Sort();
    }
}
