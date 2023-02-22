package tree_assignment;
/*
Given a binary tree, find the maximum path sum in it.
The path is defined as a sequence of nodes that follows parent-child connection.Path may start from any node and end at any node.

Input Format
The first line of input contains level order traversal of the tree.In the input , a -1 value represent a null child while any other value represent a node in the tree.

Constraints
1<=number of nodes in the tree <=10^5

Output Format
Print a single integer equal to maximum path sum in the given tree.

Sample Input
1 4 6 -1 -1 -1 -1
Sample Output
11
Explanation
The path with maximum sum is from the root's left child(4) to root's right child(6) with sum as 11(4+1+6)
 */
import java.util.*;
public class Binary_Tree_Maximum_Path_Sum {
    public static void main (String args[]) {
        Create_level_order4 t=new Create_level_order4();
        System.out.println(t.max());
    }
}
class Create_level_order4 {
    class Node{
        int val;
        Node left,right;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node root;
    Scanner sc=new Scanner(System.in);

    public Create_level_order4() {
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
    int max(){
        max(root);
        return max;
    }
    int max=Integer.MIN_VALUE;
    int max(Node root){
        if(root==null)return 0;
        int left=Math.max(max(root.left),0);
        int right=Math.max(max(root.right),0);
        max=Math.max(max,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}