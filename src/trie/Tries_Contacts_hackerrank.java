package trie;

import java.util.*;

public class Tries_Contacts_hackerrank {
    public class Node{
        char ch;
        int count=1;
        HashMap<Character,Node> child=new HashMap<>();
        boolean isTerminal;
        public Node(char c){
            ch=c;
        }
    }
    private Node root;
    public Tries_Contacts_hackerrank(){
        this.root=new Node('*');
    }

    public static void main(String[] args) {
        Tries_Contacts_hackerrank t=new Tries_Contacts_hackerrank();
        Scanner  sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            String q=sc.next();
            if(q.equals("add")){
                t.insert(sc.next());
            }
            else {
                System.out.println(t.startsWith(sc.next()));
            }
        }

    }
    public void insert(String word) {
        Node curr=root;
        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            if(curr.child.containsKey(ch)){
                curr=curr.child.get(ch);
                curr.count++;
            }
            else{
                Node n=new Node(ch);
                curr.child.put(ch,n);
                curr=n;
            }
        }
        curr.isTerminal=true;
    }
    public int  startsWith(String prefix) {
        Node curr=root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch=prefix.charAt(i);
            if(curr.child.containsKey(ch)){
                curr=curr.child.get(ch);
            }
            else {
                return 0;
            }
        }
        return curr.count;
    }

}
