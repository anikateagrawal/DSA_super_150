package stack_queue;

import java.util.Stack;

public class Insert_down {
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        System.out.println(s);
        insert(s,-3);
        System.out.println(s);
        rev(s);
        System.out.println(s);
    }
    static void insert(Stack<Integer> s,int v){
        if(s.isEmpty()){
           s.push(v);
           return;
        }
        int p=s.pop();
        insert(s,v);
        s.push(p);
    }
    static void rev(Stack<Integer> s ){
        if(s.isEmpty())return;
        int p=s.pop();
        rev(s);
        insert(s,p);
    }
}
