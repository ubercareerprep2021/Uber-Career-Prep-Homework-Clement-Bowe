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

    public static List<List<Integer>> pairsThatEqualSum(List<Integer> inputArray, Integer targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        Collections.sort(inputArray);

        if(inputArray.size() == 0 || inputArray == null){
            return ans; 
        }

        Collections.sort(inputArray);
        for(int i = 0; i < inputArray.size()-1; i++){
            int element = inputArray.get(i);
            int j = inputArray.size()-1;
            while(j > i){
                int sum = element+inputArray.get(j);
                if(sum == targetSum){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(element);
                    arr.add(inputArray.get(j));
                    ans.add(arr);
                }
                j--;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
       String word1 = in.next();
       String word2 = in.next();
       System.out.println(isStringPermutation(word1,word2));

       List<Integer> let = new ArrayList<>();
       for(int i = 0; i < 5; i++){
           int el = in.nextInt();
           let.add(el);
       }
      System.out.println(pairsThatEqualSum(let, 12));
    }
}
