package hashmap_heap_assignment;

/*
Sanju needs your help! He gets a list of employees with their salary. The maximum salary is 100.

Sanju is supposed to arrange the list in such a manner that the list is sorted in decreasing order of salary. And if two employees have the same salary, they should be arranged in lexicographical manner such that the list contains only names of those employees having salary greater than or equal to a given number x.

Help Sanju prepare the same!

Input Format
On the first line of the standard input, there is an integer x. The next line contans integer N, denoting the number of employees. N lines follow, which contain a string and an integer, denoting the name of the employee and his salary.

Constraints
1 <= N <= 10^5 1 <= | Length of the name | <= 100 1 <= x, salary <= 100

Output Format
You must print the required list.

Sample Input
79
4
Eve 78
Bob 99
Suzy 86
Alice 86
Sample Output
Bob 99
Alice 86
Suzy 86
 */
import java.util.*;
public class Sort_Game {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();
        ArrayList<sal> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            sal o=new sal(sc.next(),sc.nextInt());
            if(o.s>=k)l.add(o);
        }
        Collections.sort(l,(a,b)->{
            if(a.s!=b.s)return b.s-a.s;
            else return a.n.compareTo(b.n);
        });
        for(sal s:l)System.out.println(s.n+" "+s.s);
    }
    static class sal{
        int s;
        String n;
        sal(String name,int sal){
            s=sal;
            n=name;
        }
    }
}

