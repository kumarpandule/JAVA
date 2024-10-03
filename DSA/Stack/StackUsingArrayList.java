import java.util.*;

public class StackUsingArrayList {

    static class Stack{
        public static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            return list.size() == 0;
        }

        // push
        public static void push(int val){
            if(isEmpty()){
                list.add(val);
                return;
            }

            list.add(val);
        }

        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }

            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }

            return list.get(list.size() - 1);
        }
    }
    public static void main(String srgs[]){
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        Stack.push(4);

        while(!Stack.isEmpty()){
            System.out.print(Stack.peek() + " ");
            Stack.pop();
        }
    }
}
