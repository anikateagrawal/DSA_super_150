package tree_assignment;
/*
Given a Binary tree, print the bottom-up level order traversal of its nodes, i.e. from left to right, each level from leaf to root.

Input Format
The only line of input contains N space-separated values, i.e. integers or N denoting a null node in their level-order traversal.

Constraints
|node.Value| ≤ 105

Output Format
Print each level on a new line, where the values of each node in the level are separated by a space.

Sample Input
3 9 2 N N 5 7
Sample Output
5 7
9 2
3
Explanation
    3
  /   \
 9      2
       /  \
      5     7
The levels in bottom-up would be, {5, 7}, {9, 2}, {3}.
 */
import java.util.*;
public class Bottom_Up_Level_Order {
    public static void main (String args[]) {
        Create_level_order5 t=new Create_level_order5();
        ArrayList<ArrayList<Integer>> l=t.levelArrayList();
        for(int i=l.size()-1;i>=0;i--){
            ArrayList<Integer> k=l.get(i);
            for(int j:k)System.out.print(j+" ");
            System.out.println();
        }
    }
}
class Create_level_order5 {
    class Node{
        int val;
        Node left,right;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node root;
    Scanner sc=new Scanner(System.in);

    public Create_level_order5() {
        createTree();
    }
    private void createTree(){
        try{
            Queue<Node> q=new LinkedList<>();
            String s=sc.next();
            if(s.equals("N"))return;
            int val=Integer.parseInt(s);
            root=new Node(val);
            q.add(root);
            while (!q.isEmpty()){
                Node n=q.poll();
                String ss=sc.next();
                if(!ss.equals("N")){
                    n.left=new Node(Integer.parseInt(ss));
                    q.add(n.left);
                }
                ss=sc.next();
                if(!ss.equals("N")){
                    n.right=new Node(Integer.parseInt(ss));
                    q.add(n.right);
                }
            }
        }

        catch (Exception e){
            return;
        }
    }
    public ArrayList<ArrayList<Integer>> levelArrayList() {
        ArrayList<ArrayList<Integer>> l=new ArrayList<ArrayList<Integer>>();
        if(root==null)return l;
        Queue < Node > queue = new LinkedList <Node > ();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> ll=new ArrayList<Integer>();
            Queue < Node > temp = new LinkedList < Node> ();
            while (!queue.isEmpty()) {
                Node n = queue.remove();
                ll.add(n.val);
                if (n.left != null)
                    temp.add(n.left);
                if (n.right != null)
                    temp.add(n.right);
            }
            queue = temp;
            l.add(ll);
        }
        return l;
        // write your code here
    }
}
