package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
    private HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();
    public Dijkstra(int v){
        for (int i = 1; i <=v ; i++) {
            map.put(i,new HashMap<>());
        }
    }
    public void addEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }
    public void cost(){
        PriorityQueue<Dijkstra_Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        Set<Integer> visited=new HashSet<>();
        pq.add(new Dijkstra_Pair(1,"1",0));
        while (!pq.isEmpty()){
            Dijkstra_Pair rp=pq.remove();
            if(visited.contains(rp.vtx))continue;
            visited.add(rp.vtx);
            System.out.println(rp);
            for (int nbrs:map.get(rp.vtx).keySet()){
                if(!visited.contains(nbrs)){
                    pq.add(new Dijkstra_Pair(nbrs,rp.path+" "+nbrs,rp.cost+map.get(rp.vtx).get(nbrs)));
                }
            }
        }
    }
    private class Dijkstra_Pair{
        int vtx;
        String path;
        int cost;
        public Dijkstra_Pair(int vtx, String path, int cost) {
            this.vtx = vtx;
            this.path = path;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Dijkstra_Pair{" +
                    "vtx=" + vtx +
                    ", path='" + path + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }
}
