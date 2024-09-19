import java.util.Scanner;

public class RecursionString {

    // Recursio function to reverse the string
    public static void printReverseStr(String str, int idx){
        if(idx == 0){
            System.out.print(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        printReverseStr(str, idx-1);
    }

    // Recursion to find first and last occurrence of element in the given str
    public static int first = -1;
    public static int second = -1;

    public static void printOccurrenceOfE(String str, char element, int idx){
        if(idx == str.length() - 1){
            System.out.print("First at: " + first + " Second at: " + second);
            return;
        }
        char currentChar = str.charAt(idx);
        if(currentChar == element){
            if(first == -1){
                first = idx;
            }else{
                second = idx;
            }
        }
        printOccurrenceOfE(str, element, idx + 1);
    }

    // Recursion function to move all 'x' to the end of the str
    public static void printMoveXtoEnd(String str, String newString, int idx, int count){
        if(idx == str.length()){
            for(int i=0; i<count; i++){
                newString += 'x';
            }
            System.out.print(newString);
            return;
        }
        if(str.charAt(idx) == 'x'){
            count++;
            printMoveXtoEnd(str, newString, idx + 1, count);
        }else{
            newString += str.charAt(idx);
            printMoveXtoEnd(str, newString, idx + 1, count);
        }
    }

    // Recursion function to remove all duplicats from the string
    public static boolean[] map = new boolean[26];
    public static void printRemoveDuplicates(String str, String newStr, int idx){
        if(idx == str.length()){
            System.out.print(newStr);
            return;
        }
        char currenChar = str.charAt(idx);
        if(map[currenChar - 'a']){
            printRemoveDuplicates(str, newStr, idx + 1);
        }else{
            newStr += currenChar;
            map[currenChar - 'a'] = true;
            printRemoveDuplicates(str, newStr, idx + 1);
        }
    }

    // Recursion function to print subsequences of a string
    public static void printSubsequences(String str, int idx, String newStr){
        if(idx == str.length()){
            System.out.print(newStr + " ");
            return;
        }
        char currentChar = str.charAt(idx);

        // currentChar want to be
        printSubsequences(str, idx + 1, newStr+currentChar);

        // currentChar do not want to be
        printSubsequences(str, idx + 1, newStr);
    }


    // Recursion function to calculate number keypad combinations
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vw", "xyz"}; 

    public static void printKeypadCombi(String str,int idx, String combinasion){
        if(idx == str.length()){
            System.out.print(combinasion + " ");
            return;
        }

        char currentChar = str.charAt(idx);
        String mapping = keypad[currentChar - '0'];
        for(int i=0; i<mapping.length(); i++){
            printKeypadCombi(str, idx + 1, combinasion+mapping.charAt(i));
        }
    }


    public static void main(String args[]){
        String str;
        try(Scanner scan = new Scanner(System.in)){
            System.out.print("Please enter a string: ");
            str = scan.nextLine();
        }
        // System.out.print("Reverse string is: ");
        // printReverseStr(str, str.length() - 1);
        // System.out.println();
        // System.out.print("Printing first and last position of element 'a' of string: ");
        // printOccurrenceOfE(str,'a',0);
        // System.out.println();
        // System.out.print("Move all 'x' to the end of the string: ");
        // printMoveXtoEnd(str,"",0,0);
        // System.out.println();
        // System.out.print("Remove duplicates chars in a string: ");
        // printRemoveDuplicates(str, "", 0);
        // System.out.println();
        // System.out.print("Print all the subsequences of a string: ");
        // printSubsequences(str, 0, "");
        // System.out.println();
        System.out.print("Print keypad combinations: ");
        printKeypadCombi(str,0,"");
    }
}
