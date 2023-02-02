package tree_assignment;
/*
Given a Binary Tree Print all the leaf nodes.

Input Format
Level order input of the binary tree

Constraints
Total no of nodes <1000

Output Format
All leaf nodes from left to right in single line

Sample Input
1
2 3
4 5
6 7
-1 -1
-1 -1
-1 -1
-1 -1
Sample Output
4 5 6 7
 */
import java.util.*;
public class Print_All_Leaf_Nodes {
    public static void main(String args[]) {
        Create_level_order b=new Create_level_order();
        b.print(b.root);
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
    public Node root;
    Scanner sc=new Scanner(System.in);

    public Create_level_order() {
        createTree();
    }
    private void createTree(){
        Queue<Node> q=new LinkedList<>();
        int val=sc.nextInt();
        if(val==-1)return;
        root=new Node(val);
        q.add(root);
        while (!q.isEmpty()){
            Node n=q.poll();
            int v=sc.nextInt();
            if(v!=-1){
                n.left=new Node(v);
                q.add(n.left);
            }
            v=sc.nextInt();
            if(v!=-1){
                n.right=new Node(v);
                q.add(n.right);
            }
        }
    }
    void print(Node root){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            System.out.print(root.val+" ");
            return ;
        }
        print(root.left);
        print(root.right);
    }
}