package graph;

import java.util.*;

public class Prims {
    private HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();
    public Prims(int v){
        for (int i = 1; i <=v ; i++) {
            map.put(i,new HashMap<>());
        }
    }
    public void addEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }
    class PrimsPair{
        int vtx,acqvtx,cost;

        public PrimsPair(int vtx, int acqvtx, int cost) {
            this.vtx = vtx;
            this.acqvtx = acqvtx;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "PrimsPair{" +
                    "vtx=" + vtx +
                    ", acqvtx=" + acqvtx +
                    ", cost=" + cost +
                    '}';
        }
    }
    public void PrimsAlgo(){
        int sum=0;
        PriorityQueue<PrimsPair> q=new PriorityQueue<>((a,b)->a.cost-b.cost);
        q.add(new PrimsPair(1,1,0));
        Set<Integer> v=new HashSet<>();
        while (!q.isEmpty()){
            PrimsPair pp=q.poll();
            if(v.contains(pp.vtx))continue;
            v.add(pp.vtx);
//            System.out.println(pp);
            sum+=pp.cost;
            for(int nb:map.get(pp.vtx).keySet()){
                if(!v.contains(nb)){
                    q.add(new PrimsPair(nb,pp.vtx,map.get(pp.vtx).get(nb)));
                }
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Prims p=new Prims(n);
        int m=sc.nextInt();
        for (int i = 0; i < m; i++) {
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int c=sc.nextInt();
            p.addEdge(v1,v2,c);
        }
        p.PrimsAlgo();
    }
}

/*
Input
4 5
1 2 10
2 3 15
1 3 5
4 2 2
4 3 40
 */