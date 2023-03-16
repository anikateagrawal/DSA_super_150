package hashmap_heap_assignment;

/*
You will be given a Binary Tree. Your task is to print the binary tree in Vertical Fashion. The image below describes how we define a vertical traversal of a tree.

Input Format
You will be given an Integer N denoting the number of levels in the corresponding tree. On the next line you will be given (2^N)-1 order integers denoting the level order input for the tree. If at any level any node is absent then that will denoted by -1 and every integer other than -1 shows the presence of a node at that level.

Constraints
1 <= N <= 10^5

Output Format
Print all nodes of a given column in the same line.

Image

Sample Input
4 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 -1 -1 -1 -1
Sample Output
4 2 1 5 6 3 8 7 9
Explanation
Refer to the image.
We are to simply print the traversal of each vertical level from left to right , using pre order traversal. {4} {2} {1 5 6} {3 8} {7} {9}
 */
import java.util.*;
public class Vertical_Order_Print_Binary_Tree{
    public static void main(String args[]) {
        Create_level_order t=new Create_level_order();
        t.vertical();
    }

}
class Create_level_order {
    class Node{
        int val;
        Node left,right;

        public Node(int val) {
            this.val = val;
        }
    }
    Node root;
    Scanner sc=new Scanner(System.in);

    public Create_level_order() {
        createTree();
    }
    private void createTree(){
        int num=sc.nextInt();
        Queue<Node> q=new LinkedList<>();
        int val=sc.nextInt();
        if(val==-1)return;
        root=new Node(val);
        q.add(root);
        while (!q.isEmpty()){
            Node n=q.poll();
            int v=-1;
            if(sc.hasNext())
                v=sc.nextInt();
            if(v!=-1){
                n.left=new Node(v);
                q.add(n.left);
            }
            if(sc.hasNext())
                v=sc.nextInt();
            else v=-1;
            if(v!=-1){
                n.right=new Node(v);
                q.add(n.right);
            }
        }
    }
    void vertical(){
        Map<Integer,List<Integer>> m=new TreeMap<>();
        vertical(root,m,0);
        for(int i:m.keySet()){
            for(int j:m.get(i)){
                System.out.print(j+" ");
            }
            // System.out.println();
        }
    }
    void vertical(Node root,Map<Integer,List<Integer>> m,int p){
        if(root==null)return;
        List<Integer> l=m.getOrDefault(p,new ArrayList<>());
        l.add(root.val);
        m.put(p,l);
        vertical(root.left,m,p-1);
        vertical(root.right,m,p+1);
    }
}
