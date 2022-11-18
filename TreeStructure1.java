package Prectices_12_01_2022;

import Prectices_12_01_2022.TreeStructure1;
import Prectices_12_01_2022.TreeData.Node;

public class TreeStructure1 {
    public static void main(String[] args) {
        TreeData.Node head = null;
        TreeData t1 = new TreeData();
        Node temp = null;

        head = new Node(50);
        head.left = new Node(30);
        head.right = new Node(80);
        head.left.left = new Node(20);
        head.left.right = new Node(40);
        head.right.left = new Node(70);
        head.right.left.left = new Node(60);    
        
        



        
        temp = null;
        System.out.println("\n=================================================");
        System.out.println(t1.LCA(head, 60).data);
        System.out.println(t1.findData(head, 80));
        t1.printData(head);
        System.out.println(head.data + "\n=================================================");

        System.out.println(t1.findNode(head, 70).data);
        
    }
}


class TreeData{
    public void printData(Node head){
        if(head != null){
            System.out.print(head.data + ", ");
            printData(head.left);
            printData(head.right);
        }
    }


    public Node findNode(Node head, int key){


            //System.out.println(key);
        //     return head;
        // }
        // if(head.data != key){
        //     System.out.println("----");
        //     return findNode(head.left, key);
        // }
        // else{
        //     System.out.println("----");
        //     return findNode(head.right, key);
        // }

        // if(head == null){
        //     return null;
        // }
        // if(head.data == key){
        //     return head;
        // }
        // Node left = findNode(head.left, key);
        // if(left.data == key){
        //     return left;
        // }
        // Node right = findNode(head.right, key);
        // return right;


        if(head == null){
            return null;
        }
        if(head.data == key){
            return head;
        }
        Node left = findNode(head.left, key);
        Node right = findNode(head.right, key);
        if(left == null){
            return right;
        }
        return left;



    }




    public Node LCA(Node head, int data){
        if(head == null){
            return null;
        }
        if(head.data > data){
            System.out.print(head.data + " ");
            return LCA(head.left, data);
        }
        else if(head.data < data){
            System.out.print(head.data + " ");
            return LCA(head.right, data);
        }
        return head;

    }



    public boolean findData(Node head, int data){
        if(head == null){
            return false;
        }
        if(head.data == data){
            return true;
        }
        if(head.data > data){
            return findData(head.left, data);
        }
        else{
            return findData(head.right, data);
        }
    }





    static class Node{

        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}

