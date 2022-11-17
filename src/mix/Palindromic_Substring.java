package mix;

public class Palindromic_Substring {
    public static void main(String[] args) {
        String s="nitin";
        System.out.println(count(s));
    }
    public static int count(String s){
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j+i < s.length()&& i-j>=0; j++) {
                if(s.charAt(i-j)!=s.charAt(i+j))break;
                count++;
            }
        }
        for (double i = 0.5; i < s.length(); i++) {
            for (double j = 0.5; j+i < s.length()&& i-j>=0; j++) {
                if(s.charAt((int) (i-j))!=s.charAt((int) (i+j)))break;
                count++;
            }
        }
        return count;
    }
}
