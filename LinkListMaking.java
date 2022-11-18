// package Prectices_12_01_2022;

// public class LinkListMaking {
//     public static void main(String[] args) {
//         LinkListMakeData l1 = new LinkListMakeData();
//         l1.insert(56);
//         l1.insert(89);
//         l1.insert(96);
//         l1.insert(51);
//         l1.insert(11);
//         l1.insert(23);

//         l1.printData();
//     }
// }

// class LinkListMakeData{

//     Node head = null;

//     public void insert(int data){
//         Node newNode = new Node(data);
//         Node temp = null;
//         if(head == null){
//             head = newNode;
//             return;
//         }
//         else{
//             temp = head;
//             while(temp.next != null){
//                 temp = temp.next;
//             }
//             temp.next = newNode;
//         }
//     }

//     public void printData(){
//         Node temp = head;
//         while (temp != null){
//             System.out.println(temp.data);
//             temp = temp.next;
//         }
//     }

//     static class Node{
//         int data;
//         Node next;
//         public Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }
// }




// package Prectices_12_01_2022;

// public class LinkListMaking {
//     public static void main(String[] args) {
//         LinkListMakeData l1 = new LinkListMakeData();
//         LinkListMakeData.Node head = null;
//         head = l1.insert(56,head);
//         l1.insert(89,head);
//         l1.insert(96,head);
//         l1.insert(51,head);
//         l1.insert(11,head);
//         l1.insert(23,head);

//         l1.printData(head);
//     }
// }

// class LinkListMakeData{

//     public Node insert(int data,Node head){
//         Node newNode = new Node(data);
//         Node temp = null;
//         if(head == null){
//             head = newNode;
//             return head;
//         }
//         else{
//             temp = head;
//             while(temp.next != null){
//                 temp = temp.next;
//             }
//             temp.next = newNode;
//         }
//         return head;
//     }

//     public void printData(Node head){
//         Node temp = head;
//         while (temp != null){
//             System.out.println(temp.data);
//             temp = temp.next;
//         }
//     }

//     static class Node{
//         int data;
//         Node next;
//         public Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }
// }




package Prectices_12_01_2022;

public class LinkListMaking {
    public static void main(String[] args) {
        LinkListMakeData l1 = new LinkListMakeData();
        LinkListMakeData.Node head = null;
        head = l1.insert(56,head);
        head = l1.insert(89,head);
        head = l1.insert(96,head);
        head = l1.insert(51,head);
        head = l1.insert(11,head);
        head = l1.insert(23,head);

        l1.printData(head);
    }
}

class LinkListMakeData{

    public Node insert(int data,Node head){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public void printData(Node head){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
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
