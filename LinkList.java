package Prectices_12_01_2022;


import java.util.Scanner;
import Prectices_12_01_2022.List.Node;

public class LinkList{


    static StringBuilder a = new StringBuilder("Bharat Mata Ki Jay");


    public static void main(String[] args) {
        System.out.println(a);
        Scanner sc = new Scanner(System.in);
        Node head = null;
        List l1 = new List();
        int n = sc.nextInt();
        for(int i = 0;i < n ; i++){
            int data = sc.nextInt();
            head = l1.passData(data);
        }

        l1.printData();
        System.out.println(l1.cheackIsLoop());
        
        head = l1.reverseRecurtionLinkList(head);
        Node head1 = head;
        l1.printData(head);

        // // l1.passData(head);
        // l1.printData();
        // l1.printData();
        

        // l1.deleteNode(head,1);
        // System.out.println("--------------------------------");
        // System.out.println("--------------------------------");
        // System.out.println("--------------------------------");
        // l1.printData();
        // System.out.println("--------------------------------");
        // System.out.println("--------------------------------");
        // System.out.println("--------------------------------");

        System.out.println(l1.chakePolindrom(head1));
        l1.printData();
        sc.close();
    }
}

class List{

    Node head = null;
    public Node passData(int data){
        Node n1 = new Node(data);
        if(head == null){
            head = n1;
        }
        else{
            // Node temp = head;
            // while(temp.next != null){
            //     temp = temp.next;
            // }
            // temp.next = n1;

            n1.next = head;
            head = n1;
        }

        return head;
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

    // public void passData(Node head){
    //     this.head = head;
    // }
    static class Node{
        int data;
        Node next;

        public Node(int data){ // Constructer
            this.data = data;
            this.next = null;
        }
    }

    public void printData(){
        Node temp = this.head;
        System.out.println("--------------------------------");
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void printData(Node head){
        Node temp = head;
        System.out.println("--------------------------------");
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        this.head = head;
    }

    public void reverseLinkList(){
        Node prev = head;
        Node cur = head.next;

        if(head == null || head.next == null){
            return;
        }

        while(cur != null){
            Node nextnode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextnode;
        }
        head.next = null;
        head = prev;
    }

    public Node reverseRecurtionLinkList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node reversenodehead = reverseRecurtionLinkList(head.next);
        head.next.next = head;
        head.next = null;
        return reversenodehead;
    }

    public void deleteNode(Node head,int n){
        if(head == null){
            return;
        }
        if(head.next == null){
            this.head = null;
            return;
        }
        int i = 0;

        Node temp = head;
        while(temp != null){
            temp = temp.next;
            i++;
        }
        
        if(n == i){
            this.head = head.next;
            return;
        }
        n = i - n;
        i = 1;
        temp = head;
        // while(temp != null){
        //     if(i == n){
        //         temp.next = temp.next.next;
        //         return;
        //     }
        //     i++;
        //     temp = temp.next;
        // }
        while(i < n){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return;
    }

    public boolean chakePolindrom(Node head){
        if(head == null || head.next == null){
            return true;
        }

        int i = 0;
        Node temp = head;
        Node temp2 = head;

        while(temp != null){
            temp = temp.next;
            i++;
        }

        
        int n = i / 2;
        if(i % 2 == 1){
            n = n + 1;
        }

        temp = head;
        i = 1;
        while(i <= n){
            i++;
            System.out.println(temp.data + "-----");
            temp = temp.next;
        }

        Node newnode = null;

        // Node prev = temp;
        // Node cur = temp.next;

        // while(cur != null){
        //     Node nextnode = cur.next;
        //     cur.next = prev;
        //     prev = cur;
        //     cur = nextnode;
        // }
        // temp.next = null;
        // newnode = prev;

// -----------------------------------------------------------------------------------------------------------

        Node prev = null;
        Node cur = temp;

        while(cur != null){
            Node nextnode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextnode;
        }
        newnode = prev;

// -----------------------------------------------------------------------------------------------------------
        // while(newnode != null){
        //     System.out.println(newnode.data + "+++++");
        //     newnode = newnode.next;
        // }


        while(newnode != null){
            System.out.println(temp2.data + "          " + newnode.data);
            if(temp2.data != newnode.data){
                return false;
            }
            temp2 = temp2.next;
            newnode = newnode.next;
        }
        

        return true;
    }
}