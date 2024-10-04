import java.util.*;

public class QueueUsingStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();

    }

    public boolean empty(){
        return s1.isEmpty() && s2.isEmpty();
    }
 
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        s1.push(x);

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        
        int top = s1.peek();
        s1.pop();
        return top;
    }
    
    public int peek() {
        if(empty()){
            return -1;
        }
        return s1.peek();
    }

    public static void main(String args[]){
        QueueUsingStack q = new QueueUsingStack();

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.pop());
        q.push(6);
        System.out.println(q.pop());
        q.push(7);
        while(!q.empty()){
            System.out.println(q.peek() + " ");
            q.pop();
        }
    }
}