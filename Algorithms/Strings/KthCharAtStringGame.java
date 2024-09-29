public class KthCharAtStringGame {

    public static String generateWord(String chars){
        String result = "";

        for(int i = 0; i < chars.length(); i++){
            char ch = chars.charAt(i);
            char character = ch;
            character += 1;
            result += character;
        }
        return result;
    }

    public static char kthCharacter(int k){
        String word = "a";
        while(word.length() < k ){
            String chars = generateWord(word);
            word += chars;
            System.out.print(chars + " ");
            System.out.print(word);
            System.out.println();
        }
        return word.charAt(k-1);
    }
    public static void main(String args[]){
        int k = 5;
        System.out.println(kthCharacter(k));
    }
}
