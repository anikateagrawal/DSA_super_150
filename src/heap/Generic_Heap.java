package heap;

import java.util.ArrayList;

public class Generic_Heap<T extends Comparable> {
    private ArrayList<T> list =new ArrayList<>();
    public  void add(T item){
        list.add(item);
        upheapify(list.size()-1);
    }
    private void upheapify(int ci){
        int pi=(ci-1)/2;
        if(isLarger(list.get(pi),list.get(ci))>0){
            swap(ci,pi);
            upheapify(pi);
        }
    }
    private int isLarger(T o1,T o2){
        return o1.compareTo(o2);
    }
    public T remove(){
        swap(0,list.size()-1);
        T rv=list.remove(list.size()-1);
        downheapify(0);
        return rv;
    }
    public int size(){
        return list.size();
    }
    public T min(){
        return list.get(0);
    }
    public void display(){
        System.out.println(list);
    }
    private void downheapify(int pi){
        int lci=pi*2+1;
        int rci=pi*2+2;
        int mini=pi;
        if(lci<list.size()&&isLarger(list.get(mini),list.get(lci))>0){
            mini=lci;
        }
        if(rci<list.size()&&isLarger(list.get(mini),list.get(rci))>0){
            mini=rci;
        }
        if(mini!=pi){
            swap(mini,pi);
            downheapify(mini);
        }
    }
    private void swap(int ci,int pi){
        T t=list.get(pi);
        list.set(pi,list.get(ci));
        list.set(ci,t);
    }
}
