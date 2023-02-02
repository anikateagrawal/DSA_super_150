package tree_assignment;
/*
Given a binary tree. Print the zig zag order i.e print level 1 from left to right, level 2 from right to left and so on. This means odd levels should get printed from left to right and even levels should be printed from right to left.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
None

Output Format
Display the values in zigzag level order in which each value is separated by a space

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
10 30 20 40 50 60 73
 */
import java.util.*;
public class Level_Order_zigzag {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        Level_Order_zigzag m = new Level_Order_zigzag();
        BinaryTree bt = m.new BinaryTree();
        bt.levelOrderZZ();
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

        public void levelOrderZZ() {
            List<List<Integer>> l=fun();
            for(int i=0;i<l.size();i++){
                List<Integer> ll=l.get(i);
                if(i%2==0){
                    for(int j:ll)System.out.print(j+" ");
                }
                else {
                    for(int j=ll.size()-1;j>=0;j--)System.out.print(ll.get(j)+" ");
                }
            }
        }
        public List<List<Integer>> fun(){
            List<List<Integer>> l=new ArrayList<List<Integer>>();
            if(root==null)return l;
            Queue < Node > queue = new LinkedList <Node > ();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> ll=new ArrayList<Integer>();
                Queue < Node > temp = new LinkedList <Node > ();
                while (!queue.isEmpty()) {
                    Node n = queue.remove();
                    ll.add(n.data);
                    if (n.left != null)
                        temp.add(n.left);
                    if (n.right != null)
                        temp.add(n.right);
                }
                queue = temp;
                l.add(ll);
            }
            return l;
        }
    }

}

