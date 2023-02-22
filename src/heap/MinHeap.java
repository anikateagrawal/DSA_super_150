package heap;

import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> list =new ArrayList<>();
    public  void add(int item){
        list.add(item);
        upheapify(list.size()-1);
    }
    private void upheapify(int ci){
        int pi=(ci-1)/2;
        if(list.get(pi)>list.get(ci)){
            swap(ci,pi);
            upheapify(pi);
        }
    }
    public int remove(){
        swap(0,list.size()-1);
        int rv=list.remove(list.size()-1);
        downheapify(0);
        return rv;
    }
    public int size(){
        return list.size();
    }
    public int min(){
        return list.get(0);
    }
    public void display(){
        System.out.println(list);
    }
    private void downheapify(int pi){
        int lci=pi*2+1;
        int rci=pi*2+2;
        int mini=pi;
        if(lci<list.size()&&list.get(mini)>list.get(lci)){
            mini=lci;
        }
        if(rci<list.size()&&list.get(mini)>list.get(rci)){
            mini=rci;
        }
        if(mini!=pi){
            swap(mini,pi);
            downheapify(mini);
        }
    }
    private void swap(int ci,int pi){
        int t=list.get(pi);
        list.set(pi,list.get(ci));
        list.set(ci,t);
    }
}
