package tree;

import java.util.*;

public class Build_Binary_Expression {
    static Node root;
    public static void main(String[] args) {
        Build_Binary_Expression obj=new Build_Binary_Expression();
        root=obj.buildTree("2-3/(5*2)+1");
        System.out.println(obj.level(root));
    }
    Node buildTree(String s){
        Stack<Node> exp=new Stack<>();
        Stack<Character> op=new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                exp.push(new Node(ch));
            } else if (ch == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    combine(exp, op.pop());
                }
                op.pop();
            } else {
                while (!op.isEmpty() && getVal(op.peek()) >= getVal(ch)) {
                    combine(exp, op.pop());
                }
                op.push(ch);
            }
        }
        while (!op.isEmpty()){
            combine(exp,op.pop());
        }
        return exp.pop();
    }

    int getVal(char ch){
        if(ch=='+'||ch=='-')return 1;
        if(ch=='*'||ch=='/' ||ch=='%')return 2;
        if(ch=='^')return 3;
        return -1;
    }
    void combine(Stack<Node> exp,char op){
        Node root=new Node(op);
        root.right=exp.pop();
        root.left=exp.pop();
        exp.push(root);
    }
    List<Character> level(Node root){
        List<Character> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Queue<Node> q2=new LinkedList<>();
            while (!q.isEmpty()){
                Node f=q.poll();
                if(f==null)ans.add(null);
                else{
                    ans.add(f.val);
                    q2.add(f.left);
                    q2.add(f.right);
                }
            }
            q=q2;
        }
        while (ans.get(ans.size()-1)==null)ans.remove(ans.size()-1);
        return ans;
    }
}
class Node{
    char val;
    Node left,right;
    public Node(char val) {
        this.val = val;
    }
}