package stack_queue;

import java.util.Stack;

public class Num_valid_subarray {
    public static void main(String[] args) {
        int arr[]={1,4,2,5,3};
        System.out.println(count(arr));
    }
    public static int count(int arr[]){
        Stack<Integer> s=new Stack<>();
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty()&& arr[i]<s.peek()){
                s.pop();
            }
            s.push(arr[i]);
            count+=s.size();
        }
        return count;
    }
}
