public class LongestCommPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String commenPrefix = "";
        int idx = 0;

        while(true){
            if(idx >= strs[0].length()) return commenPrefix;
            char currentPrefix = strs[0].charAt(idx);

            for(int j=1; j<strs.length; j++){
                if(idx >= strs[j].length() || currentPrefix != strs[j].charAt(idx)){
                    return commenPrefix;
                }
            }
            commenPrefix += currentPrefix;
            idx++;
        }
    }

    public static void main(String args[]){
        String[] strs = {"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
    }

}
