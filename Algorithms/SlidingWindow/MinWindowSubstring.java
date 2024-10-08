
import java.util.HashMap;

public class MinWindowSubstring {
    // Function to find the minimum window substring
    // Optimized code with Array
    public static String minWindowOptimized(String s, String t){
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return new String();

        int minLen = Integer.MAX_VALUE;
        int startingIdx = 0;
        int uniqueCharCount = t.length();
        int windowStart = 0;
        int windowEnd = 0;

        int[] map = new int[128];
        for(char ch : t.toCharArray()){
            map[ch]++;
        }

        while(windowEnd < s.length()){

            if(map[s.charAt(windowEnd++)]-- > 0){
                uniqueCharCount--;
            }

            while(uniqueCharCount == 0){
                if(windowEnd - windowStart < minLen){
                    startingIdx = windowStart;
                    minLen = windowEnd - windowStart;
                }

                if(map[s.charAt(windowStart++)]++ == 0){
                    uniqueCharCount++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? new String() : s.substring(startingIdx, startingIdx + minLen);
    }

    // Optimized code with HashMap
    public static String minWindow(String s, String t){
        HashMap<Character, Integer> tClone = new HashMap<>();

        // Lets copy our t chars
        for(char ch : t.toCharArray()){
            tClone.put(ch, tClone.getOrDefault(ch, 0) + 1);
        }

        int len = 0;
        int minLen = Integer.MAX_VALUE;
        int uniqueCharCount = tClone.size();
        int startingIdx = -1;
        int windowStart = 0;
        int windowEnd = 0;
        int n = s.length();

        while(windowEnd < n){

            // Expansion phase
            char currentChar = s.charAt(windowEnd);
            if(tClone.containsKey(currentChar)){
                tClone.put(currentChar, tClone.get(currentChar) -1);

                if(tClone.get(currentChar) == 0){
                    uniqueCharCount--;
                }
            }

            // Shrinking Phase
            while(uniqueCharCount == 0){
                len = windowEnd - windowStart + 1;
                if(len < minLen){
                    minLen = len;
                    startingIdx = windowStart;
                }

                currentChar = s.charAt(windowStart);
                if(tClone.containsKey(currentChar)){
                    tClone.put(currentChar, tClone.get(currentChar) + 1);

                    if(tClone.get(currentChar) > 0){
                        uniqueCharCount++;
                    }
                }
                windowStart++;
            }
            windowEnd++;
        }

        return startingIdx == -1 ? "" : s.substring(startingIdx, startingIdx + minLen);
    }

    public static void main(String arsg[]){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // Expected output: "BANC"
        System.out.println(minWindowOptimized(s, t));
    }
}


// Brute Force
// public String minWindow(String s, String t) {
//     int minLength = Integer.MAX_VALUE;
//     int n = s.length();
//     int m = t.length();
//     int start = -1;

//     for(int i=0; i<n; i++){
//         int[] tClone = new int[128];

//         for(char ch : t.toCharArray()){
//             tClone[ch]++;
//         }

//         int count = 0;
//         for(int j=i; j<n; j++){
//             char currentChar = s.charAt(j);

//             if(tClone[currentChar] > 0){
//                 tClone[currentChar]--;
//                 count++;
//             }

//             if(count == m){
//                 if(j-i+1 < minLength){
//                     minLength = j-i+1;
//                     start = i;
//                 }

//                 break;
//             }
//         }
//     }
//     return start == -1 ? "" : s.substring(start, start + minLength);
// }