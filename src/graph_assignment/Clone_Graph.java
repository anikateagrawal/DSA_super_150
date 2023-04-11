package graph_assignment;

/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

class Node {
public int val;
public List neighbors;
}

Input Format
you have given connected undirected graph.

Constraints
Output Format
Display a deep copy (clone) of the graph.

Sample Input
4
2
2 4
2
1 3
2
2 4
2
1 3
Sample Output
Original graph :- 1 2 4 3
Copied graph :- 1 2 4 3
Explanation
There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 */
import java.util.*;
        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.StringTokenizer;
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class Clone_Graph {
    public static Node cloneGraph(Node node) {
        // write code here
        if(node==null)return null;
        Map<Node,Node> m=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node f=q.poll();
            if(m.containsKey(f))continue;
            Node n=new Node(f.val);
            m.put(f,n);
            for(Node nb:f.neighbors){
                if(!m.containsKey(nb))q.add(nb);
            }
        }
        for(Node n:m.keySet()){
            Node e=m.get(n);
            for(Node nb:n.neighbors){
                e.neighbors.add(m.get(nb));
            }
        }
        return m.get(node);

    }
    public static void main(String[] args) throws IOException {
        Scanner s= new Scanner(System.in);
        int n = s.nextInt(); // number of nodes in graph
        Node [] nodes = new Node[n];
        for(int i = 0 ;i<n;i++){
            nodes[i]= new Node(i+1);
        }
        for(int i = 0;i<n;i++){
            int m = s.nextInt(); //num of neighbors connected with ith node
            while(m-->0){
                nodes[i].neighbors.add(nodes[s.nextInt()-1]); // connecting neighbours
            }
        }
        //printing graph
        System.out.print("Original graph :- ");
        get(nodes[0],n);           // original graph
        System.out.println();
        System.out.print("Copied graph :- ");
        Node output = cloneGraph(nodes[0]);
        get(output,n);            // coppied graph

    }

    public static void get(Node output ,int n){

        boolean [] visited = new boolean [n];
        Queue<Node> queue =  new LinkedList<>();
        queue.add(output);
        visited[output.val-1]=true;
        while(!queue.isEmpty()){
            Node x = queue.poll();
            System.out.print(x.val+" ");
            if(x.neighbors!=null){
                for(Node curr : x.neighbors){
                    if(!visited[curr.val-1]){
                        queue.add(curr);
                        visited[curr.val-1]=true;
                    }
                }
            }
        }
    }


}
