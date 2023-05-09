package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Kruskal {
    private HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();
    public Kruskal(int v){
        for (int i = 1; i <=v ; i++) {
            map.put(i,new HashMap<>());
        }
    }
    public void addEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }
    class edge{
        int v1,v2,cost;

        public edge(int v1, int v2, int cost) {
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
    public ArrayList<edge> getAllEdges(){
        ArrayList<edge> l=new ArrayList<>();
        for(int e1:map.keySet()){
            for(int e2:map.get(e1).keySet()){
                l.add(new edge(e1,e2,map.get(e1).get(e2)));
            }
        }
        return l;
    }
    public void KruskalsAlgo(){
        int sum=0;
        Disjoint ds=new Disjoint();
        for(int i:map.keySet())
            ds.createSet(i);
        ArrayList<edge> l=getAllEdges();
        Collections.sort(l,(a,b)->a.cost-b.cost);
        for(edge e:l){
            int v1=e.v1;
            int v2=e.v2;
            int re1=ds.find(v1);
            int re2=ds.find(v2);
            if(re1!=re2){
//                System.out.println(e);
                sum+=e.cost;
                ds.union(v1,v2);
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Kruskal k=new Kruskal(n);
        int m=sc.nextInt();
        for (int i = 0; i < m; i++) {
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int c=sc.nextInt();
            k.addEdge(v1,v2,c);
        }
        k.KruskalsAlgo();
    }
    class Disjoint {
        class Node{
            int vtx;
            Node parent;
            int rank=0;
        }
        HashMap<Integer, Node> map=new HashMap<Integer, Node>();
        public void createSet(int v){
            Node n=new Node();
            n.vtx=v;
            n.parent=n;
            n.rank=0;
            map.put(v,n);
        }

        public int find(int v){
            Node n=map.get(v);
            return find(n).vtx;
        }
        private Node find(Node n){
            if(n.parent==n){
                return n;
            }
            n.parent=find(n.parent);
            return n.parent;
        }

        public void union(int v1,int v2){
            Node n1=map.get(v1);
            Node re1=find(n1);
            Node n2=map.get(v2);
            Node re2=find(n2);
            if(re1.rank==re2.rank){
                re1.parent=re2;
                re2.rank++;
            }
            else if(re1.rank<re2.rank){
                re1.parent=re2;
            }
            else{
                re2.parent=re1;
            }
        }
    }
}
