package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class BellmanFord {
    private HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();
    public BellmanFord(int v){
        for (int i = 1; i <=v ; i++) {
            map.put(i,new HashMap<>());
        }
    }
    public void addEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
    }
    class edgePair{
        int v1,v2,cost;

        public edgePair(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "edge{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", cost=" + cost +
                    '}';
        }
    }
    public ArrayList<edgePair> getAllEdges(){
        ArrayList<edgePair> l=new ArrayList<>();
        for(int e1:map.keySet()){
            for(int e2:map.get(e1).keySet()){
                l.add(new edgePair(e1,e2,map.get(e1).get(e2)));
            }
        }
        return l;
    }

    public  void BellmanFordAlgo(){
        int v= map.size();
        int ds[]=new int[v+1];
        for (int i = 2; i < ds.length; i++) {
            ds[i]=(int)1e7;
        }
        ArrayList<edgePair> l=getAllEdges();
        for (int i = 1; i <= v; i++) {
            for (edgePair e:l){
                int v1=e.v1;
                int v2=e.v2;
                int oldcost=ds[v2];
                int newcost=ds[v1]+e.cost;
                if(i==v&&newcost<oldcost){
                    System.out.println("-ve weight cycle");
                    return;
                }
                if(newcost<oldcost)ds[v2]=newcost;
            }
        }
        for (int i = 1; i < ds.length; i++) {
            System.out.println("Vertex " +i+" distance "+ds[i]);
        }
    }

    public static void main(String[] args) {
        BellmanFord b=new BellmanFord(5);
        b.addEdge(1,2,8);
        b.addEdge(2,5,2);
        b.addEdge(5,2,1);
        b.addEdge(4,5,4);
        b.addEdge(3,4,-3);
        b.addEdge(1,3,4);
        b.addEdge(1,4,5);
        b.BellmanFordAlgo();
    }
}
