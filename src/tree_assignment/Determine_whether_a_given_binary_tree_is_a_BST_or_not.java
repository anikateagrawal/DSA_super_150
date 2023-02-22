package tree_assignment;
/*
Determine_whether_a_given_binary_tree_is_a_BST_or_not
Given a binary tree, determine whether it is a BST.

Input Format
Level order traversals given where -1 means child is NULL

Constraints
-10^5<=nodes.data<=10^5

Output Format
true or false

Sample Input
20 10 30 -1 -1 5 40 -1 -1 -1 -1
Sample Output
false
Explanation
In the tree above, each node meets the condition that the node contains a value larger than its left child and smaller
than its right child hold, and yet it’s not a BST: the value 5 is on the right subtree of the node containing 20,
a violation of the BST property.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static class BinaryTreeFromLvlOrder {

        private Scanner s = new Scanner(System.in);

        private class Node {
            int val;
            Node left;
            Node right;

            public Node(int val) {
                this.val = val;
            }
        }

        private Node root;

        public BinaryTreeFromLvlOrder() {
            // TODO Auto-generated constructor stub
            root = construct();// 2k
        }

        private Node construct() {
            // TODO Auto-generated method stub

            int val = s.nextInt();
            Node nn = new Node(val);
            Queue<Node> lvl = new LinkedList<>();
            lvl.add(nn);

            while (!lvl.isEmpty()) {
                Node front = lvl.remove();
                int a = s.nextInt();
                int b = s.nextInt();

                if (a != -1) {
                    Node na = new Node(a);
                    front.left = na;
                    lvl.add(na);
                }

                if (b != -1) {
                    Node nb = new Node(b);
                    front.right = nb;
                    lvl.add(nb);
                }
            }
            return nn;// 2k
        }

        private boolean isValid() {
            // TODO Auto-generated method stub
            return isValid(root,null,null);
        }
        private boolean isValid(Node root,Integer low,Integer high){
            if(root==null)return true;
            if(low!=null&& root.val< low || high!=null&& root.val>high){
                return false;
            }
            return isValid(root.left,low,root.val)&& isValid(root.right,root.val,high);
        }

    }

    public static void main(String[] args) {
        BinaryTreeFromLvlOrder bt = new BinaryTreeFromLvlOrder();
        System.out.println(bt.isValid());
    }
}

