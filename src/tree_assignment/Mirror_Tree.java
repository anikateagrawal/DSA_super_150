package tree_assignment;
/*
Given a binary tree , Check if its mirror image is equal to the tree itself.

Input Format
The first line of the input contains level order traversal of the tree as space separated integers . In the level order traversal , -1 represent a null child while any other value represent a node of the tree.

Constraints
1<=number of nodes in the tree <=10^5

Output Format
Print "YES" without quotes if the mirror image of the tree is equal to the tree itself , else print "NO" without quotes.

Sample Input
1 2 2 -1 -1 -1 -1
Sample Output
YES
Explanation
The mirror image of given tree is equal to the tree itself.
 */
import java.util.*;
public class Mirror_Tree {
    public static void main (String args[]) {
        Scanner sc=new Scanner (System.in);
        Create_level_order3 b=new Create_level_order3();
        if(b.hlp(b.root,b.root))System.out.println("YES");
        else System.out.println("NO");
    }
}
class Create_level_order3 {
    class Node{
        int val;
        Node left,right;

        public Node(int val) {
            this.val = val;
        }
    }
    public Node root;
    Scanner sc=new Scanner(System.in);

    public Create_level_order3() {
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

    boolean hlp(Node t1,Node t2){
        if(t1==null&&t2==null)return true;
        if(t1==null||t2==null)return false;
        if(t1.val!=t2.val)return false;
        return hlp(t1.left,t2.right)&& hlp(t1.right,t2.left);
    }
}