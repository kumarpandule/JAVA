public class MyCircularQueue {

        int[] arr;
        int size;
        int front = -1;
        int rear = -1;

        public MyCircularQueue(int k) {
            arr = new int[k];
            this.size = k;
        }
        
        public boolean enQueue(int value) {
            if(isFull()){
                return false;
            }
            if(front == -1){
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = value;
            return true;
        }
        
        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }

            if(rear == front){
                rear = front = -1;
            }else{
                front = (front + 1) % size;
            }
            return  true;
        }
        
        public int Front() {
            if(isEmpty()){
                return -1;
            }

            return arr[front];
        }
        
        public int Rear() {
            if(isEmpty()){
                return -1;
            }

            return arr[rear];
        }
        
        public boolean isEmpty() {
            return front == -1 && rear == -1;
        }
        
        public boolean isFull() {
            return (rear + 1) % size == front;
    }
    
    public static void main(String args[]){
        MyCircularQueue q = new MyCircularQueue(5);

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        System.out.println(q.deQueue());
        q.enQueue(6);
        System.out.println(q.deQueue());
        q.enQueue(7);
        System.out.println(q.Rear());

        while(!q.isEmpty()){
            System.out.println(q.Front() + " ");
            q.deQueue();
        }
    }
}
