import java.util.*;

public class App {

    public static boolean isStringPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1 == null || s2 == null){
            return false;
        }

        int[] letterCount1 = new int[26];
        int [] letterCount2 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            letterCount1[s1.charAt(i)-'a']++;
        }
        for(int i = 0; i < s2.length(); i++){
            letterCount2[s2.charAt(i)-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(letterCount1[i] != letterCount2[i]){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
       String word1 = in.next();
       String word2 = in.next();
       System.out.println(isStringPermutation(word1,word2)); 
    }
}
