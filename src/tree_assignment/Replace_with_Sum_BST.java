package tree_assignment;
/*
Replace_with_Sum_BST
Replace each node with the sum of all greater nodes in a given BST

Input Format
Enter the number of nodes N and add N more numbers to the BST

Constraints
None

Output Format
Display the resulting tree

Sample Input
3
2
1
3
Sample Output
5 => 3 <= 0
END => 5 <= END
END => 0 <= END
 */

import java.util.*;
public class Replace_with_Sum_BST {
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public Replace_with_Sum_BST() {
        this.root = null;
        this.size = 0;
    }

    public void add(int data) {
        if (this.isEmpty()) {
            this.root = new Node(data, null, null);
            this.size++;
        } else {
            this.add(this.root, data);
        }
    }

    private void add(Node node, int data) {
        if (data > node.data) {
            if (node.right != null) {
                this.add(node.right, data);
            } else {
                this.size++;
                node.right = new Node(data, null, null);
            }
        } else if (data < node.data) {
            if (node.left != null) {
                this.add(node.left, data);
            } else {
                this.size++;
                node.left = new Node(data, null, null);
            }
        } else {
            // nothing to do
        }
    }

    public void remove(int data) {
        this.root = this.remove(this.root, data);
    }

    private Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data > node.data) {
            node.right = this.remove(node.right, data);
            return node;
        } else if (data < node.data) {
            node.left = this.remove(node.left, data);
            return node;
        } else {
            // found the element
            if (node.left == null && node.right == null) {
                this.size--;
                return null;
            } else if (node.left == null) {
                this.size--;
                return node.right;
            } else if (node.right == null) {
                this.size--;
                return node.left;
            } else {
                // both children
                int lmax = this.max(node.left);
                node.data = lmax;
                node.left = this.remove(node.left, lmax);

                return node;
            }
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void display() {
        System.out.println(this);
    }

    public int max() {
        return this.max(this.root);
    }

    private int max(Node node) {
        int rv = node.data;

        if (node.right != null) {
            rv = this.max(node.right);
        }

        return rv;
    }

    @Override
    public String toString() {
        return this.toString(this.root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }

        String retVal = "";

        if (node.left != null) {
            retVal += node.left.data + " => ";
        } else {
            retVal += "END" + " => ";
        }

        retVal += node.data;

        if (node.right != null) {
            retVal += " <= " + node.right.data;
        } else {
            retVal += " <= " + "END";
        }

        retVal += "\n";

        retVal += this.toString(node.left);
        retVal += this.toString(node.right);

        return retVal;
    }
    public void replaceWLS() {
        duplicate(root,0);
    }
    private int duplicate(Node node,int l) {
        //Your Code Goes Here
        if(node ==null)return 0;
        int right=duplicate(node.right,l);
        int left=duplicate(node.left,node.data+right+l);
        int d=node.data;
        node.data=right+l;
        return d+right+left;
    }
    public static void main(String[] args) {
        Replace_with_Sum_BST b1= new Replace_with_Sum_BST();
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        while(n!=0){
            int m=scn.nextInt();
            b1.add(m);
            --n;
        }
        b1.replaceWLS();
        System.out.println(b1);
    }
}
