package Prectices_12_01_2022;

import java.util.Scanner;
import Prectices_12_01_2022.LoopLink.Node;

public class LinkListLooping {


    static StringBuilder a = new StringBuilder("Bharat Mata Ki Jay");
    public static void main(String[] args) {
        
            Node last = null;


            System.out.println(a);
            Scanner sc = new Scanner(System.in);
            LoopLink l1 = new LoopLink();
            int n = sc.nextInt();

            for(int i = 0;i < n ; i++){
                int data = sc.nextInt();
                last = l1.passData(data);
            }
            l1.loopingList(last);
            
            System.out.println(l1.cheackIsLoop());
            
            // l1.printData();
            sc.close();
    }
    
}

class LoopLink{

    Node head = null;
    public Node passData(int data){
        Node n1 = new Node(data);
        if(head == null){
            head = n1;

        }
        else{

            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = n1;

            // n1.next = head;
            // head = n1;
        }
        return n1;
    }

    public void loopingList(Node lastNode){
        int i = 1;
        int n = 4;
        Node temp = head;
        while(i < n){
            i++;
            temp = temp.next;
        }
        lastNode.next = temp;
    }


    public void printData(){
        Node temp = this.head;
        System.out.println("--------------------------------");
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public boolean cheackIsLoop() {
        if(head == null){
            return false;
        }
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;


            if(fast == slow){
                return true;
            }
        }

        return false;
    }

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}
