import java.util.ArrayList;
import java.util.List;

public class LetterCombi {
    
    public static String[] keypad = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void helper(String digits, List<String> allCombinations, int idx, String combinations){
        if(idx == digits.length()){
            allCombinations.add(combinations);
            return;
        }

        int currentDigit = digits.charAt(idx) - '0';
        String mapping = keypad[currentDigit - 1];

        for(int i=0; i<mapping.length(); i++){
            helper(digits, allCombinations, idx + 1, combinations + mapping.charAt(i));
        }
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        List<String> allCombinations = new ArrayList<>();
        String combinations = "";
        helper(digits, allCombinations, 0, combinations);
        return allCombinations;
    }

    public static void main(String args[])
    {
        String digits = "";
        List<String> keypadCombi = letterCombinations(digits);

        for(String commbination : keypadCombi){
            System.out.print(commbination + " ");
        }
    }
}