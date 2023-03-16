package graph;

import java.util.*;

public class Graph {
    private HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
    public Graph(int v){
        for (int i = 1; i <=v ; i++) {
            map.put(i,new HashMap<>());
        }
    }
    public void addEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }
    public boolean containEdge(int v1,int v2){
        return map.get(v1).containsKey(v2);
    }
    public boolean containsVertex(int v){
        return map.containsKey(v);
    }
    public int countEdges(){
        int sum=0;
        for(int i:map.keySet()){
            sum+=map.get(i).size();
        }
        return sum/2;
    }
    public void removeEdge(int v1,int v2){
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }
    public void removeVertex(int v){
        for(int i:map.get(v).keySet()){
            map.get(i).remove(v);
        }
        map.remove(v);
    }
    public void display(){
        for(int i:map.keySet()){
            System.out.println(i+"->" +map.get(i));
        }
    }
    public boolean hasPath(int src,int des,Set<Integer> vis){
        if(src==des){
            return true;
        }
        vis.add(src);
        for(int i:map.get(src).keySet()){
            if(vis.contains(i))continue;
            boolean ans=hasPath(i,des,vis);
            if(ans)return ans;
        }
        return false;
    }
}
