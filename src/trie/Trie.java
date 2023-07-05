package trie;

import java.util.HashMap;
import java.util.Scanner;

public class Trie {
    public class Node{
        char ch;
        HashMap<Character,Node> child=new HashMap<>();
        boolean isTerminal;
        public Node(char c){
            ch=c;
        }
    }
    private Node root;
    public Trie(){
        this.root=new Node('*');
    }

    public static void main(String[] args) {
        Trie t=new Trie();
        t.insert("raj");
        System.out.println(t.search("raj"));
    }
    public void insert(String word) {
        Node curr=root;
        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            curr=curr.child.computeIfAbsent(ch,k->new Node(ch));
        }
        curr.isTerminal=true;
    }
    public boolean startsWith(String prefix) {
        Node curr=root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch=prefix.charAt(i);
            if(curr.child.containsKey(ch)){
                curr=curr.child.get(ch);
            }
            else {
                return false;
            }
        }
        return true;
    }
    public boolean search(String word) {
        Node curr=root;
        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            if(curr.child.containsKey(ch)){
                curr=curr.child.get(ch);
            }
            else {
                return false;
            }
        }
        return curr.isTerminal;
    }
}
