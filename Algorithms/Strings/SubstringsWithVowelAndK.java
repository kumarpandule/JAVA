public class SubstringsWithVowelAndK {

    public static int countOfSubstrings(String word, int k){
        int subStrings = 0;
        int len = word.length();
        
        for(int x=0; x<len; x++){
            int a = 0, e = 0, i = 0, o = 0, u = 0, c = 0;

            for(int j=x; j<len; j++){
                switch (word.charAt(j)) {
                    case 'a' -> a++;
                    case 'e' -> e++;
                    case 'i' -> i++;
                    case 'o' -> o++;
                    case 'u' -> u++;
                    default -> c++;
                }
    
                if(a > 0 && e > 0 && i > 0 && o > 0 && u > 0 && c == k ) {
                    subStrings++;
                }
            }
        }
        return subStrings;
    }

    public static void main(String args[]){
        String word = "ieaouqqieaouqq";
        int k = 1;

        System.out.println(countOfSubstrings(word, k));
    }
}
