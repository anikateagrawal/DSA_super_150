package tree_assignment;
/*
Given a binary search tree, replace each nodes' data with the sum of all nodes' which are greater or equal than it. Include the current node's data also.

Input Format
The first line contains a number n showing the length of the inorder array of BST. The next line contains n integers denoting the elements of the array.

Constraints
2 ≤ N ≤ 10^3

Output Format
Print the preorder traversal of the new tree.

Sample Input
7
20
30
40
50
60
70
80
Sample Output
260 330 350 300 150 210 80
Explanation
The original tree looks like

            50
        /        \
      30          70
    /    \       /   \
  20    40      60    80
We are supposed to replace the elements by the sum of elements larger than it.
80 being the largest element remains unaffected .
70 being the second largest element gets updated to 150 (70+80)
60 becomes 210 (60 + 70 + 80)
50 becomes 260 (50 + 60 + 70 + 80)
40 becomes 300 (40 + 50 + 60 + 70 + 80)
30 becomes 330 (30 + 40 + 50 + 60 + 70 + 80)
20 becomes 350 (20 + 30 + 40 + 50 + 60 + 70 + 80)

The new tree looks like

           260
        /        \
     330         150
    /    \       /   \
  350    300   210    80
The Pre-Order traversal (Root->Left->Right) looks like :
260 330 350 300 150 210 80.


 */
import java.util.*;
public class Replace_with_Sum_of_greater_nodes {
    private class Node {
        int data;
        Node left;
        Node right;
        public Node(){

        }
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public Replace_with_Sum_of_greater_nodes() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void add(int data[]) {
        root=createTree(data,0,data.length-1);
    }

    private Node createTree(int in[],int ilo,int ihi){
        if(ilo>ihi)return null;
        int mid=(ilo+ihi)/2;
        Node nn=new Node();
        nn.data=in[mid];
        nn.left=createTree(in,ilo,mid-1);
        nn.right=createTree(in,mid+1,ihi);
        return nn;
    }

    public void display() {
        this.display(this.root);
    }

    public void remove(int data) {
        this.root = this.remove(this.root, data);
    }

    private Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = this.remove(node.left, data);
            return node;
        } else if (data > node.data) {
            node.right = this.remove(node.right, data);
            return node;
        } else {
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
                int lmax = this.max(node.left);
                node.data = lmax;
                node.left = this.remove(node.left, lmax);
                return node;
            }
        }
    }
    int max(Node root){
        if(root.right==null)return root.data;
        return max(root.right);
    }

    private void display(Node node) {
        if(node ==null)return;
        System.out.print(node.data+" ");
        display(node.left);
        display(node.right);

    }
    public void duplicate() {
        this.duplicate(this.root,0);
    }

    private int duplicate(Node node,int l) {
        //Your Code Goes Here
        if(node ==null)return 0;
        int right=duplicate(node.right,l);
        int left=duplicate(node.left,node.data+right+l);
        int d=node.data;
        node.data+=right+l;
        return d+right+left;
    }

    public static void main (String[] args) {
        Replace_with_Sum_of_greater_nodes bst=new Replace_with_Sum_of_greater_nodes();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int in[]=new int[n];
        for(int i=0;i<n;i++){
            in[i]=s.nextInt();
        }
        bst.add(in);
        bst.duplicate();
        bst.display();
    }
}

