package hashmap;

import java.util.ArrayList;

public class HashMap<K,V> {
    class Node{
        K key;
        V value;
        Node next;

        public Node() {

        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<Node> bucketarr;
    private int size=0;
    public HashMap(int x) {
        bucketarr = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            bucketarr.add(null);
        }
    }
    public HashMap(){
        this(4);
    }

    public int hashfunction(K key){
        int bn=key.hashCode()%bucketarr.size();
        if(bn<0)bn+=bucketarr.size();
        return bn;
    }
    public void put(K key,V value){
        int bn=hashfunction(key);
        Node tmp=bucketarr.get(bn);
        while (tmp!=null){
            if(tmp.key.equals(key)){
                tmp.value=value;
                return;
            }
            tmp=tmp.next;
        }
        Node n=new Node(key,value);
        n.next=bucketarr.get(bn);
        bucketarr.set(bn,n);
        size++;
        double lf=1.0*size/bucketarr.size();
        double thf=2.0;
        if (lf>thf){
            rehashing();
        }
    }
    private void rehashing(){
        ArrayList<Node> newbucketarr=new ArrayList<>();
        for (int i = 0; i < bucketarr.size()*2; i++) {
            newbucketarr.add(null);
        }
        ArrayList<Node> oba=bucketarr;
        bucketarr=newbucketarr;
        size=0;
        for(Node node:oba){
            while (node!=null){
                put(node.key,node.value);
                node=node.next;
            }
        }
    }
    public V get(K key){
        int bn=hashfunction(key);
        Node tmp=bucketarr.get(bn);
        while (tmp!=null){
            if(tmp.key.equals(key)){
                return tmp.value;
            }
            tmp=tmp.next;
        }
        return null;
    }
    public V remove(K key){
        int bn=hashfunction(key);
        Node prev=null;
        Node curr=bucketarr.get(bn);
        while (curr!=null){
            if(curr.key.equals(key)){
                break;
            }
            prev=curr;
            curr=curr.next;
        }
        if(curr==null)return null;
        size--;
        if(prev==null){
            bucketarr.set(bn,curr.next);
            curr.next=null;
        }
        else {
            prev.next= curr.next;
            curr.next=null;
        }
        return curr.value;
    }

    @Override
    public String toString() {
        String s="{";
        for(Node node:bucketarr){
            while (node!=null){
                s+=node.key+"="+node.value+",";
                node=node.next;
            }
        }
        return s.substring(0,s.length()-1)+"}";
    }

    public boolean containsKey(K key){
        int bn=hashfunction(key);
        Node tmp=bucketarr.get(bn);
        while (tmp!=null){
            if(tmp.key.equals(key)){
                return true;
            }
            tmp=tmp.next;
        }
        return false;
    }

}
