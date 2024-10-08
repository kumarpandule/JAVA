public class TypingDistance {

    public static char[][] keyboard = {
        {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'},
        {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ' '},
        {'Z', 'X', 'C', 'V', 'B', 'N', 'M', ' ', ' '}
    };

    public static int[] findDistance(int row, int col, char nextChar){
        int distance = 0;
        int[] newPos = new int[2];

        for(int r=0; r<keyboard.length; r++){
            for(int c=0; c<keyboard[r].length; c++){
                if(keyboard[r][c] == nextChar){
                    int currentDistance = distance = Math.abs(row - r) + Math.abs(col - c);
                    if(currentDistance < distance){
                        distance = currentDistance;
                        newPos[0] = r;
                        newPos[1] = c;
                    }
                }
            }
        }
        return new int[] {distance, newPos[0], newPos[1]};
    }

    public static int countDistance(String word){
        int distance = 0;
        int row = 0, col = 0;

        for(int ch=0; ch<word.length(); ch++){
            char currentChar = word.charAt(ch);
                int[] result = findDistance(row, col, currentChar);
                distance += result[0];
                row = result[1];
                col =  result[2];
        }
        return distance;
    }

    public static void main(String args[]){
        String word = "Q";
        System.out.println(countDistance(word));
    }
}
