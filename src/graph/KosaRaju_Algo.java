package graph;

import java.util.*;
public class KosaRaju_Algo
{
    //find strongly connected components
    HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
    public KosaRaju_Algo(int v){
        for (int i = 0; i < v; i++) {
            map.put(i,new HashMap<>());
        }
    }
    public void addEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
    }
    public int KosaRaju_Algo(){
        Stack<Integer> st=new Stack();
        Set<Integer> visited=new HashSet<>();
        dfs(visited,st,1);
        HashMap<Integer,HashMap<Integer,Integer>> map1=new HashMap<>();
        TransposeGraph(map1);
        visited=new HashSet<>();
        int count=0;
        while (!st.isEmpty()){
            int top=st.pop();
            if(visited.contains(top))continue;
            count++;
            dfs(map1,visited,top);
        }
        return count;
    }

    private void dfs(HashMap<Integer, HashMap<Integer, Integer>> map1, Set<Integer> visited, int i) {
        visited.add(i);
        for (int nb:map1.get(i).keySet()) {
            if(!visited.contains(nb)){
                dfs(map1,visited,nb);

            }
        }
    }


    private void TransposeGraph(HashMap<Integer, HashMap<Integer, Integer>> map1) {
        for(int key:map.keySet()){
            for(int nb:map.get(key).keySet()){
                if(!map1.containsKey(nb)){
                    map1.put(nb,new HashMap<>());
                }
                map1.get(nb).put(key,map.get(key).get(nb));
            }
        }
    }

    private void dfs(Set<Integer> visited, Stack<Integer> st, int i) {
        visited.add(i);
        for (int nb:map.get(i).keySet()) {
            if(!visited.contains(nb)){
                dfs(visited,st,nb);

            }
        }
        st.push(i);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        KosaRaju_Algo k=new KosaRaju_Algo(n);
        for (int i = 0; i < m; i++) {
            k.addEdge(sc.nextInt(),sc.nextInt(),5);
        }
        System.out.println(k.KosaRaju_Algo());
    }
}
/*
input
8 10
0 1
1 2
2 0
2 3
3 4
4 5
5 6
6 7
4 7
6 4
output
4

 */