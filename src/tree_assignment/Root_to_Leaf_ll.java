package tree_assignment;
/*
Given a binary tree and an integer sum,Print count of root-to-leaf paths that have path's sum equal to given integer sum.

Input Format
The first line contains level order traversal of the tree . In the level order traversal given, -1 represent a null child while any other value represent a node of the tree.
Next line contains a single integer sum.

Constraints
1<=number of nodes in the tree <=10^5

Output Format
Print a single integer equal to number of root to leaf paths with given sum.

Sample Input
1 2 3 -1 -1 -1 -1
3
Sample Output
1
Explanation
There is only 1 root to leaf path with sum 3 (from 1 to 2).
 */

import java.util.*;
public class Root_to_Leaf_ll {
    public static void main (String args[]) {
        Create_level_order2 b=new Create_level_order2();
        b.fun();
    }
}
class Create_level_order2 {
    class Node{
        int val;
        Node left,right;

        public Node(int val) {
            this.val = val;
        }
    }
    public Node root;
    Scanner sc=new Scanner(System.in);

    public Create_level_order2() {
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
    int ct=0;
    public void fun(){
        fun(root,sc.nextInt(),0);
        System.out.println(ct);
    }
    public void fun(Node root,int k,int s){
        if(root==null)return;
        s+=root.val;
        if(root.left==null&&root.right==null){
            if(s==k)
                ct++;
            return;
        }
        fun(root.left,k,s);
        fun(root.right,k,s);
    }
}