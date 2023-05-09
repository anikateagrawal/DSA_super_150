package stack_queue_assignment_5;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*
Monu Bhaiya has a board of size M x N consisting of characters and a list of strings words, print all words which are on the board in a sorted order .

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Input Format
First Line contains 3 space-separated Integers M ,N and K(length of words list) .
Next M Lines contains strings of length N .
Next Line contains a list of words .

Constraints
1 <= N,M <= 12
1 <= word.length <= 104
1 <= word[i].length <= 10

Output Format
print space-separated words which are on the board.

Sample Input
4 4 5
oaan
etae
ihkr
iflv
oath pea eat rain fifa
Sample Output
eat oath
Explanation
There are only two words "oath" and "eat" from the list which are also in the character board .
 */

public class Search_Word_in_MonuBhaiya_s_Board {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(),n=sc.nextInt(),k=sc.nextInt();
        char b[][]=new char [m][n];
        for(int i=0;i<m;i++){
            String ss=sc.next();
            for(int j=0;j<n;j++){
                b[i][j]=ss.charAt(j);
            }
        }
        String a[]=new String[k];
        for(int i=0;i<k;i++)a[i]=sc.next();
        List<String> ll=new LinkedList<String>();
        for(int q=0;q<k;q++){
            String word=a[q];
            outer:
            for(int ii=0;ii<b.length;ii++){
                inner:
                for(int j=0;j<b[0].length;j++){
                    if(b[ii][j]==word.charAt(0)){
                        if(rat(b,ii,j,word)){
                            ll.add(word);
                            break outer;
                        }
                    }
                }
            }
        }
        Collections.sort(ll);
        for(String sss:ll){
            System.out.print(sss+" ");        }
    }
    static boolean rat(char [][]a,int i,int j,String word){
        if(word.length()==0)
        {
            return true;
        }
        if(i<0||i>=a.length||j<0||j>=a[0].length||word.charAt(0)!=a[i][j]){
            return false;
        }
        char c=a[i][j];
        a[i][j]=' ';
        boolean b;
        b=rat(a,i+1,j,word.substring(1));
        if(!b)b=rat(a,i-1,j,word.substring(1));
        if(!b)b=rat(a,i,j+1,word.substring(1));
        if(!b)b=rat(a,i,j-1,word.substring(1));
        a[i][j]=c;
        return b;
    }
}
