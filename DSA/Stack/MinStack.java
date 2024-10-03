import java.util.*;
public class MinStack {

    Stack<Integer> list;
    Stack<Integer> minList;

    public MinStack() {
        list = new Stack<>();
        minList = new Stack<>();
    }
    
    public void push(int val) {
        if(minList.isEmpty() || minList.peek() >= val){
            minList.push(val);
        }
        list.push(val);
    }
    
    public void pop() {
        if(list.peek().equals(minList.peek())){
            minList.pop();
        }
        list.pop();
    }
    
    public int top() {
        return list.peek();
    }
    
    public int getMin() {
        return minList.peek();
    }

    public static void main(String args[]){
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
