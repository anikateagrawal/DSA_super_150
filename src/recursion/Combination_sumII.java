package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combination_sumII {
    public static void main(String[] args) {
        int[] arr={10,1,2,7,6,1,5};
        int target=8;
        Arrays.sort(arr);
        List<List<Integer>> l=new ArrayList<>();
        Combination(arr,target,0,l,new ArrayList<>());
        System.out.println(l);
    }
    public static void Combination(int a[],int t,int i,List<List<Integer>> l,List<Integer> ll)
    {
        if(t==0){
            l.add(new ArrayList<>(ll));
            return;
        }
        for (int j = i; j < a.length; j++) {
            if(j!=i && a[j]==a[j-1]){
                continue;
            }
            if(t>=a[j])
            {
                ll.add(a[j]);
                Combination(a, t - a[j],  j + 1,l,ll);
                ll.remove(ll.size()-1);
            }
        }
    }
}
