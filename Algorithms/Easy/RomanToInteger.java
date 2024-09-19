public class RomanToInteger {

    public static int checkValue(char currentChar, char previousChar, int romanInt){
        switch (currentChar) {
            case 'I' -> {
                if(previousChar == 'V' || previousChar == 'X'){
                    return -1;
                }else{
                    return 1;
                }
            }
            case 'V' -> {
                return 5;
            }
            case 'X' -> {
                if(previousChar == 'L' || previousChar == 'C'){
                    return -10;
                }else{
                    return 10;
                }
            }
            case 'L' -> {
                return 50;
            }
            case 'C' -> {
                if(previousChar == 'D' || previousChar == 'M'){
                    return -100;
                }else{
                    return 100;
                }
            }
            case 'D' -> {
                return 500;
            }
            case 'M' -> {
                return 1000;
            }
            default -> {
                return 0;
            }
        }
    }

    public static int romanToInt(String roman){
        int romanInt = 0;
        int len = roman.length() - 1;

        for(int i=len; i >= 0; i--){
            char romanChar = roman.charAt(i);
            char previousChar;
            if(i == len){
                previousChar = roman.charAt(i);
                romanInt += checkValue(romanChar, previousChar, romanInt);
            }else{
                previousChar = roman.charAt(i+1);
                romanInt += checkValue(romanChar, previousChar, romanInt);
            }
        }
        return romanInt;
    }
    public static void main(String args[]){
        String roman = "MCMXCIV";
        System.out.println(romanToInt(roman));
    }
}
