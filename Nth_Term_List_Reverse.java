package Prectices_12_01_2022;

import java.util.Scanner;

public class Nth_Term_List_Reverse{
    public static void main(String[] args) {
        // int a = 121;
        // System.out.println(a);

        ListDef.Node head = null;
        ListDef.Node head1 = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bharat Mata Ki Jay");
        ListDef l1 = new ListDef();
        for(int i = 0; i < 5; i++){
            int a = sc.nextInt();
            head = l1.addData(head, a);
        }
        head1 = head;
        l1.printData(head);
        l1.printData(head1);
        ListDef.Node newHead = l1.nthTermRev(head1,3);
        l1.printData(newHead);
        head = l1.nthTermRev(newHead,3);
        l1.printData(head);
        // ListDef.Node newHead = l1.nthTermRev(head,3);
        // l1.printData(newHead);
        // head = l1.nthTermRev(newHead,3);
        // l1.printData(head);
    }
}
class ListDef{
    public Node addData(Node head, int data){
        Node n1 = new Node(data);
        
        if(head == null){
            head = n1;
            return head;
        }
        Node temp = null;
        temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = n1;
        return head;
    }

    public Node nthTermRev(Node head, int n){
        if(head == null){
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node newNext = curr;
        while(curr != null && n > 0){
            newNext = curr.next;
            curr.next = prev;
            prev =curr;
            curr = newNext;
            n--;
        }
        if(curr != null){
            head.next = nthTermRev(curr,3);
        }
        return prev;
    }

    public void printData(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp= temp.next;
        }
        System.out.println("null");
    }

    static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

}