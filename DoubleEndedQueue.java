package Prectices_12_01_2022;

public class DoubleEndedQueue {

    static class Queue{
        static int queue[];
        static int size;
        static int rear = -1;
        static int front = -1;

        public Queue(int size){
            queue = new int[size];
            Queue.size = size;
        }
        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        public static boolean isFull(){
            return front == (rear+1)%size;
        }

        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % size;
            queue[rear] = data;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int value = queue[front];
            if(front == rear){
                front = rear = -1;
            }
            else{
                front = (front+1) % size;
            }
            return value;
        }
        public static int peek(){
            if(front == -1){
                System.out.println("Queue is empty");
                return -1;
            }
            return queue[front];
        }
    }
    public static void main(String[] args){
        
        Queue q1 = new Queue(5);
        q1.add(56);
        q1.add(57);
        q1.add(58);
        
        q1.add(59);
        q1.add(60);
        q1.add(61);
        
        while(!q1.isEmpty()){
            System.out.println(q1.peek());
            q1.remove();
        }
        q1.add(111);
        q1.add(251);
        q1.add(1111111111);
        System.out.println(q1.peek());
        q1.remove();
    }
}
