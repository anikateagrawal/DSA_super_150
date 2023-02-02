package tree_assignment;
/*
Given a binary tree. Print the level order traversal, make sure each level start at a new line.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
None

Output Format
Print the level order in which the different levels are in different lines, all the values should be in a space separated manner

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
10
20 30
40 50 60 73
 */
import java.util.*;
public class LevelOrder {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        LevelOrder m = new LevelOrder();
        BinaryTree bt = m.new BinaryTree();
        bt.levelOrderNewLine();
        System.out.println(scn.nextInt());
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

        public void levelOrderNewLine() {
            if(root==null)return ;
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            Queue<Node> q2=new LinkedList<>();
            while(!q.isEmpty()){
                Node n=q.poll();
                System.out.print(n.data+" ");
                if(n.left!=null)q2.add(n.left);
                if(n.right!=null)q2.add(n.right);
                if(q.isEmpty()){
                    System.out.println();
                    q=q2;
                    q2=new LinkedList<>();
                }
            }
            // write your code here
        }

    }

}

