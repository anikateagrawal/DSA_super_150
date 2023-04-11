package graph;

import hashmap.HashMap;

public class DSU {
    class Node{
        int vtx;
        Node parent;
        int rank=0;
    }
    HashMap<Integer,Node> map=new HashMap<Integer, Node>();
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
