package tree_assignment;
/*
Given a binary tree , print its max path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Input Format
Single line input containing space separated integers denoting the preorder input of the tree. NULL indicates that the node does not exist.

Constraints
1 <= No of nodes <= 10^5

Output Format
Print a single integer denoting the max path sum for the given tree.

Sample Input
8 3 4 1 2 NULL NULL NULL 9 7 NULL NULL NULL 10 NULL 5 NULL NULL NULL
Sample Output
38
Explanation
The tree looks like

                  8
               /
             3
           /     \
         4       10
       /    \       \
     1       9       5
   /         /
  2         7
The max path sum is given by : 7 + 9 + 4 + 3 + 10 + 5 = 38
 */

import java.util.*;
public class Max_Path_Sum {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Max_Path_Sum m = new Max_Path_Sum();
        BinaryTree bt1 = m.new BinaryTree();
        System.out.println(bt1.maxPathSum());
    }

    private class BinaryTree {
        private class Node {
            int val;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        public Node takeInput(Node parent, boolean ilc) {
            String cdata = scn.next();
            if(cdata.equals("NULL"))return null;
            int d=Integer.parseInt(cdata);
            Node child = new Node();
            child.val = d;
            this.size++;
            child.left = this.takeInput(child, true);
            child.right = this.takeInput(child, false);
            return child;
        }
        private int max = Integer.MIN_VALUE;
        private int maxpath(Node root) {
            if (root == null) {
                return 0;
            }
            int l=maxpath(root.left);
            int r=maxpath(root.right);
            int mm=Math.max(root.val,Math.max(r,l)+root.val);
            int cm=Math.max(mm,r+l+root.val);
            max=Math.max(max,cm);
            return mm;
        }

        public int maxPathSum() {
            maxpath(root);
            return max;
        }
    }
}