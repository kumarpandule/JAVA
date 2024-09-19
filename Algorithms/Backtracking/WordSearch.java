public class WordSearch {

    public static boolean exist(char[][] board, String word){
        return true;
    }
    public static void main(String args[]){
        char[][] board = {{'A','B','C','E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        exist(board, word);
    }
}
