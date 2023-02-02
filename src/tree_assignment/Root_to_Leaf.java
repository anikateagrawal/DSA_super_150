package tree_assignment;
/*
Given a binary tree and a number k, print out all root to leaf paths where the sum of all nodes value is same as the given number.

Input Format
First line contains the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL. Second line contains the number k.

Constraints
None

Output Format
Display the root to leaf path whose sum is equal to k.

Sample Input
10 true 20 true 30 false false true 50 false false true 40 true 60 false false true 73 false false
60
Sample Output
10 20 30
Explanation
The given tree is in pre order traversal. So convert it into binary tree and check root to leaf path sum.
 */

import java.util.*;
public class Root_to_Leaf {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Root_to_Leaf m = new Root_to_Leaf();
        BinaryTree bt1 = m.new BinaryTree();
        int k=scn.nextInt();
        bt1.fun(bt1.root,k,0,"");
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        public Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        public Node takeInput(Node parent, boolean ilc) {

            int cdata = scn.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;
            boolean hlc = scn.nextBoolean();
            if (hlc) {
                child.left = this.takeInput(child, true);
            }
            boolean hrc = scn.nextBoolean();
            if (hrc) {
                child.right = this.takeInput(child, false);
            }
            return child;
        }
        public void fun(Node root,int k,int s,String ans){
            if(root==null)return;
            s+=root.data;
            ans+=root.data+" ";
            if(root.left==null&&root.right==null){
                if(s==k)
                    System.out.println(ans);
                return;
            }
            fun(root.left,k,s,ans);
            fun(root.right,k,s,ans);
        }
    }
}