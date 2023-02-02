package tree_assignment;
/*
Given a Binary tree check if it is balanced i.e. depth of the left and right sub-trees of every node differ by 1 or less.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
1 <= No of nodes <= 10^5

Output Format
Display the Boolean result

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
true
Explanation
The tree looks like

             10
          /       \
       20           30
    /     \       /     \
   40      50    60      73
The given tree is clearly balanced as depths of the left and right sub-trees of every node differ by 1 or less.
 */

import java.util.*;
public class IsBalanced{

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        IsBalanced m= new IsBalanced();
        BinaryTree bt = m.new BinaryTree();
        System.out.println(bt.isBalanced());
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        public Node takeInput(Node parent, boolean ilc) {

            int cdata = scn.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;

            // left
            boolean hlc = scn.nextBoolean();

            if (hlc) {
                child.left = this.takeInput(child, true);
            }

            // right
            boolean hrc = scn.nextBoolean();

            if (hrc) {
                child.right = this.takeInput(child, false);
            }

            // return
            return child;
        }

        public boolean isBalanced() {
            return this.hlp(this.root).f;
        }

        private BalancedPair hlp(Node root) {
            // write your code here
            BalancedPair p=new BalancedPair();
            if(root==null)return p;
            BalancedPair l=hlp(root.left);
            if(!l.f)return l;
            BalancedPair r=hlp(root.right);
            if(!r.f)return r;
            if(Math.abs(l.ht-r.ht)>1)p.f=false;
            p.ht=Math.max(l.ht,r.ht)+1;
            return p;

        }

        private class BalancedPair {
            int ht=-1;
            boolean f=true;
        }

    }
}
