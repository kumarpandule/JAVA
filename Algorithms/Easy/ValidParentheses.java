import java.util.Stack;

public class ValidParentheses {

        // anotehr example to solve same thing
        public static boolean isValid2(String s) {
            while (true) {
                if (s.contains("()")) {
                    s = s.replace("()", "");
                } else if (s.contains("{}")) {
                    s = s.replace("{}", "");
                } else if (s.contains("[]")) {
                    s = s.replace("[]", "");
                } else {
                    // If the string becomes empty, it indicates all brackets are matched.
                    return s.isEmpty();
                }
            }
        }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
    public static void main(String args[]){
        String s = "({})";
        System.out.println(isValid2(s));
    }
}
