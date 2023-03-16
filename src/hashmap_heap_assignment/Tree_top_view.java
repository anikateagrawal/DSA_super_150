package hashmap_heap_assignment;
/*
Given a binary tree , print the nodes in left to right manner as visible from above the tree

Input Format
Level order input for the binary tree will be given.

Constraints
No of nodes in the tree can be less than or equal to 10^7

Output Format
A single line containing space separated integers representing the top view of the tree

Sample Input
1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
Sample Output
4 2 1 3
Explanation
The tree looks like

             1
          /      \
       2           3
    /     \       /
   4       5     6
When viewed from the top , we would see the nodes 4, 2, 1 and 3.
 */
import java.util.*;
import java.io.*;
public class Tree_top_view {
    public static void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        BinaryTree bt=new BinaryTree(arr);
        bt.topview();

    }
}

class BinaryTree
{
    private class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
        }
    }

    Node root;

    BinaryTree(String[] arr)
    {
        Queue<Node> queue=new LinkedList<Node>();
        construct(arr,0,queue);
    }

    public void topview()
    {
        verticalTraversalTop(this.root,0);
        for(int i:m.keySet()){
            System.out.print(m.get(i)+" ");
        }
    }
    Map<Integer,Integer> m=new TreeMap<>();
    private void verticalTraversalTop(Node root,int p ) {
        if(root==null||root.data==-1)return;
        if(!m.containsKey(p))m.put(p,root.data);
        verticalTraversalTop(root.left,p-1);
        verticalTraversalTop(root.right,p+1);
    }


    private void construct(String[] arr,int ind,Queue<Node> queue)
    {
        if(ind>=arr.length)
            return;
        if(queue.size()==0)
        {
            Node nn=new Node(Integer.parseInt(arr[ind]));
            this.root=nn;
            queue.add(nn);
        }
        else
        {
            Node parent=queue.peek();
            if(parent.data!=-1){
                if(parent.left==null)
                {
                    parent.left=new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.left);
                }
                else
                {
                    if(parent.right==null)
                    {
                        parent.right=new Node(Integer.parseInt(arr[ind]));
                        queue.add(parent.right);
                        queue.poll();
                    }
                }
            }
            else
            {
                queue.poll();
                ind--;
            }
        }
        construct(arr,ind+1,queue);
    }

    public void display()
    {
        display_tree(this.root);
    }

    private void display_tree(Node root)
    {
        if(root==null)
            return;
        String str=root.data+"";
        if(root.left!=null)
        {
            str=root.left.data+" <= "+str;
        }
        else
        {
            str="END <= "+str;
        }

        if(root.right!=null)
        {
            str=str+" => "+root.right.data;
        }
        else
        {
            str=str+" => END";
        }
        System.out.println(str);
        display_tree(root.left);
        display_tree(root.right);

    }


}
