import java.util.*;

public class PushAtBottom {

    public static void pushAtBottom(Stack<Integer> s, int val){
        if(s.isEmpty()){
            s.push(val);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, val);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        // add data to stack
        s.push(1);
        s.push(2);
        s.push(3);
        // push data to the bottom of stack
        pushAtBottom(s, 4);
        // reverse the stack
        reverseStack(s);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
