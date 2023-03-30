package graph;

import java.util.*;

public class alien_dictionary {
    public String alienOrder(String[] words) {
        // Write your code here

        Map<Character, List<Character>> map=new HashMap<>();
        for(String s:words){
            for(int i=0;i< words.length;i++){
                map.put(s.charAt(i),new ArrayList<>());
            }
        }
        int []in=new int[26];
        for(int i=0;i< words.length-1;i++){
            String a=words[i];
            String b=words[i+1];
            if(a.startsWith(b)&&a.length()>b.length())return "";
            for(int j=0;j<Math.min(a.length(),b.length());j++){
                if(a.charAt(j)!=b.charAt(j)){
                    map.get(a.charAt(j)).add(b.charAt(j));
                    in[b.charAt(j)-'a']++;
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<>();
        for (char c:map.keySet()) {
            if(in[c-'a']==0)q.add(c);
        }
        StringBuilder ans=new StringBuilder();
        while(!q.isEmpty()){
            char f=q.poll();
            ans.append(f);
            for(char c:map.get(f)){
                in[c-'a']--;
                if(in[c-'a']==0)q.add(c);
            }
        }
        return ans.length()== map.size()?ans.toString():"";
    }
}
