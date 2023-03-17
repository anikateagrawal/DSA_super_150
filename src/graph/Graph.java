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
    public void printPaths(int src,int des,Set<Integer> vis,String path){
        if(src==des){
            System.out.println(path+des);
            return;
        }
        vis.add(src);
        for(int i:map.get(src).keySet()){
            if(!vis.contains(i))
            printPaths(i,des,vis,path+src+" ");
        }
        vis.remove(src);
    }
    public boolean bfs(int src,int des){
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()){
            //remove
            int f=q.poll();
            //if already visited ignore
            if(visited.contains(f))continue;
            //visited
            visited.add(f);
            //self work
            if(f==des)return true;
            //add neighbours
            for(int n:map.get(f).keySet()){
                if(!visited.contains(n))q.add(n);
            }
        }
        return false;
    }
    public boolean dfs(int src,int des){
        Set<Integer> visited=new HashSet<>();
        Stack<Integer> q=new Stack<>();
        q.push(src);
        while (!q.isEmpty()){
            //remove
            int f=q.pop();
            //if already visited ignore
            if(visited.contains(f))continue;
            //visited
            visited.add(f);
            //self work
            if(f==des)return true;
            //add neighbours
            for(int n:map.get(f).keySet()){
                if(!visited.contains(n))q.push(n);
            }
        }
        return false;
    }
    public void bft(){
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        for(int src:map.keySet()){
            if(visited.contains(src))continue;
            q.add(src);
            while (!q.isEmpty()){
                //remove
                int f=q.poll();
                //if already visited ignore
                if(visited.contains(f))continue;
                //visited
                visited.add(f);
                //self work
                System.out.println(f+" ");
                //add neighbours
                for(int n:map.get(f).keySet()){
                    if(!visited.contains(n))q.add(n);
                }
            }
        }
    }
    public void dft(){
        Set<Integer> visited=new HashSet<>();
        Stack<Integer> q=new Stack<>();
        for(int src:map.keySet()){
            if(visited.contains(src))continue;
            q.push(src);
            while (!q.isEmpty()){
                //remove
                int f=q.pop();
                //if already visited ignore
                if(visited.contains(f))continue;
                //visited
                visited.add(f);
                //self work
                System.out.println(f+" ");
                //add neighbours
                for(int n:map.get(f).keySet()){
                    if(!visited.contains(n))q.push(n);
                }
            }
        }
    }
}
