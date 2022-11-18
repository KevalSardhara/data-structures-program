package Prectices_12_01_2022;

import java.util.Scanner;

import Prectices_12_01_2022.Tree.Node;

public class TreeStructure {
    public static void main(String[] args) {

        Node head = null;
        Scanner sc = new Scanner(System.in);
        Tree t1 = new Tree();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            head = t1.setData(data, head);
        }
        System.out.println("---------------------------------");

        t1.printData(head);

        sc.close();
    }
    
}
class Tree{

    public Node setData(int data, Node head){
        if(head == null){
            Node n1 = new Node(data);
            head = n1;
        }

        else if(data <= head.data){
            head.left = setData(data, head.left);
        }
        else if(data > head.data){
            head.right = setData(data, head.right);
        }
        return head;
    }


    public static class Node{

        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void printData(Node head){
        if(head != null){
            printData(head.left);
            System.out.println(head.data);
            printData(head.right);
        }
    }
}
