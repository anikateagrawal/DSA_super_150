package stack_queue;
import java.util.Stack;

import java.util.Arrays;

public class NextGreater {
    public static void main(String[] args) {
        int a[]={10,2,1,3,5,4,8,7};
        Stack<Integer> s=new Stack();
        for (int i = 0; i < a.length; i++) {
            while(!s.isEmpty()&& a[i]>a[s.peek()]){
                int in=s.pop();
                a[in]=a[i];
            }
            s.push(i);
        }
        while (!s.isEmpty()){
            int in=s.pop();
            a[in]=-1;
        }
        System.out.println(Arrays.toString(a));
    }
}
