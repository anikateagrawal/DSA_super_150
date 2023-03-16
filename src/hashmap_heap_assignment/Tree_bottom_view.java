package hashmap_heap_assignment;

/*
Given a binary tree , print the nodes in left to right manner as visible from below the tree

Input Format
Level order input for the binary tree will be given.

Constraints
No of nodes in the tree can be less than or equal to 10^7

Output Format
A single line containing space separated integers representing the bottom view of the tree

Sample Input
1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
Sample Output
4 2 6 3
Explanation
The tree looks like

             1
          /      \
       2           3
    /     \       /
   4       5     6
(Note that 5 and 6 are at the same position so we consider the right one to lower)
 */
import java.util.*;
        import java.io.*;
public class Tree_bottom_view{
    public static void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        BinaryTree1 bt=new BinaryTree1(arr);
        bt.bottomView();
    }
}

class BinaryTree1
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

    BinaryTree1(String[] arr)
    {
        Queue<Node> queue=new LinkedList<Node>();
        construct(arr,0,queue);
    }

    public void bottomView()
    {
        bottomView(this.root,0,0);
        for(int i:m.keySet()){
            System.out.print(m.get(i).val+" ");
        }
    }
    class N{
        int val=-1;
        int level=-1;
    }
    Map<Integer,N> m=new TreeMap<>();
    private void bottomView(Node root,int p,int l) {
        if(root==null||root.data==-1)return;
        N n=m.getOrDefault(p,new N());
        if(l>=n.level){
            n.val=root.data;
            n.level=l;
        }
        m.put(p,n);
        bottomView(root.left,p-1,l+1);
        bottomView(root.right,p+1,l+1);

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
