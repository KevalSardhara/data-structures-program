package Prectices_12_01_2022;

public class QueueInDataStructure{

    static class Queue{
        static int queue[];
        static int size;
        // static int rear = 0;
        static int front = -1;

        public Queue(int size){
            queue = new int[size];
            Queue.size = size;
        }
        public static boolean isEmpty(){
            if(front == -1){
                System.out.println("Queue is empty");
                return true;
            }
            return false;
        }
        public static void add(int data){
            if(front == size - 1){
                System.out.println("Queue is Full");
                return;
            }
            front++;
            queue[front] = data;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return queue[0];
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int value = queue[0];
            for(int i = 0; i < front; i++){
                queue[i] = queue[i + 1];
            }
            front--;
            return value;
        }

    }

    public static void main(String[] args) {
        Queue q1= new Queue(5);
        // int a[] = {12,23,45,56,89};
        System.out.println(q1.isEmpty());
        q1.add(56);
        q1.add(57);
        q1.add(58);
        
        q1.add(59);
        q1.add(60);
        q1.add(61);
        
        while(!q1.isEmpty()){
            System.out.println(q1.peek());
            q1.pop();
        }
    }
}

// class Node{
//     int data;
//     Node next;
//     public Node(int data){
//         this.data = data;
//         this.next = null;
//     }
// }

// static class Queue{

//     Node head = null;
// }
