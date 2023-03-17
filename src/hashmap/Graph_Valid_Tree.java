package hashmap;

import java.util.*;

public class Graph_Valid_Tree {
    public boolean validTree(int n,int [][]edges){
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
        }
        for(int e[]:edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> vis=new HashSet<>();
        q.add(0);
        while (!q.isEmpty()){
            int f=q.poll();
            if(vis.contains(f))return false;
            vis.add(f);
            for(int i:map.get(f)){
                if(!vis.contains(f)){
                    q.add(f);
                }
            }
        }
        return vis.size()==n;
    }
}
