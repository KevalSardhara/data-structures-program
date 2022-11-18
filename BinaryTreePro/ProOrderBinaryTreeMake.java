package Prectices_12_01_2022.BinaryTreePro;

import java.util.LinkedList;
import java.util.Queue;

public class ProOrderBinaryTreeMake {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class TreeData{
        static int ind = -1;
        public static Node insertData(int nodeData[]){
            ind++;
            if(nodeData[ind] == -1){
                return null;
            }
            Node head = new Node(nodeData[ind]);
            head.left = insertData(nodeData);
            head.right = insertData(nodeData);
            return head;
        }
        public static void printData(Node head){
            if(head == null){
                return;
            }
            System.out.print(head.data + " ");
            printData(head.left);
            printData(head.right);
        }


        public static void levalOredreTrv(Node head){
            Queue<Node> q1 = new LinkedList<Node>();
            q1.add(head);
            q1.add(null);
            
            while(!q1.isEmpty()){
                Node front = q1.remove();
                if(front == null){
                    System.out.println();
                    if(!q1.isEmpty()){
                        q1.add(null);
                    }
                    else{
                        break;
                    }
                }
                else{
                    System.out.print(front.data + " ");
                    if(front.left != null){
                        q1.add(front.left);
                    }
                    if(front.right != null){
                        q1.add(front.right);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        
        Node head = null;
        int nodeData[] = new int[]{1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        TreeData t1 = new TreeData();
        head = t1.insertData(nodeData);
        t1.printData(head);
        System.out.println();
        t1.levalOredreTrv(head);
    }
}
