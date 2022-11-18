package Prectices_12_01_2022;

import Prectices_12_01_2022.MirrorTree;
import Prectices_12_01_2022.TreeDataMirror.Node;



public class MirrorTree {
    public static void main(String[] args) {
        TreeDataMirror.Node head1 = null;
        TreeDataMirror.Node head2 = null;
        TreeDataMirror t1 = new TreeDataMirror();

        head1 = new Node(50);
        head1.left = new Node(48);
        head1.right = new Node(80);
        head1.left.left = new Node(20);
        head1.left.right = new Node(49);
        head1.right.right = new Node(23);
        head1.right.left = new Node(56);
        head1.left.left.right = new Node(100);
        head1.left.left.left = new Node(1000);
        head1.left.left.right.left = new Node(121);
        head1.left.left.left.left = new Node(22);
        head1.left.left.right.right = new Node(101);


        head2 = new Node(50);
        head2.left = new Node(80);
        head2.right = new Node(30);
        head2.right.right = new Node(20);
        head2.right.left = new Node(40);


        

        System.out.println(t1.mirrorTreeCheack(head1, head2) + " <---------------------- ");





        System.out.println("=================================================");
        System.out.println(t1.isBST(head1));
        System.out.println("=================================================");
        System.out.println(t1.isBelenced(head1));
        System.out.println("=============++====================================");
        // System.out.println(t1.isBelencedClass(head1).ht <= 1 ? true : false);
        System.out.println(t1.isBalanced(head1));
        System.out.println("=============++====================================");

        try{
            System.out.println(t1.LCA(head1, 40, 30).data);
        }
        catch(Exception e){
            System.out.println("null");
        }

        // System.out.println(t1.findData(head1, 80));
        // t1.printData(head1);



        System.out.println("6666666666666666666666666666666666666666666");
        int data = 48;
        t1.kthNode(head1,data, 3, 0);
    }
}


class TreeDataMirror{
    public void printData(Node head){
        if(head != null){
            printData(head.left);
            System.out.println(head.data);
            printData(head.right);
        }
    }

    public Node LCA(Node head, int n1, int n2){
        if(head == null){
            return null;
        }

        if(head.data == n1 || head.data == n2){
            return head;
        }

        Node left = LCA(head.left, n1, n2);
        Node right = LCA(head.right, n1, n2);

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return head;
    }



    public boolean isBST(Node head){
        if(head == null){
            return true;
        }
        if(head.left != null && head.left.data > head.data){
            return false;
        }
        if(head.right != null && head.right.data < head.data){
            return false;
        }
        return (isBST(head.left) && isBST(head.right));

    }



    public int height(Node head){
        if(head == null){
            return 0;
        }
        int left = height(head.left);
        int right = height(head.right);
        int max = Math.max(left, right) + 1;
        return max;
    }



    //----------------------------------------------------------------------------------------------------//

    public void kthNode(Node head,int data, int k, int i){
        Node node = findNode(head,data);
        System.out.println(node.data + " $$$$$$$$$$$$$");
        findDepth(node,k,i);
        findBreth(node,k,i);
    }

    Node store = null;
    public Node findNode(Node head,int data){
        if(head == null){
            return null;
        }
        if(head.data == data){
            store = head;
        }
        findNode(head.left,data);
        findNode(head.right,data);
        return store;
    }

    public void findDepth(Node head,int k,int i){
        if(head == null){
            return;
        }
        if(k == i){
            System.out.print(head.data + " ");
        }
        findDepth(head.left,k,i+1);

        findDepth(head.right,k,i+1);
        
    }


    public void findBreth(Node head,int k, int i){
        if(head == null){
            return;
        }
        findBreth(head.left,k,i+1);
        if(k == i){
            System.out.print(head.data + " ");
        } 
        findBreth(head.right,k,i+1);
       
    }

    //----------------------------------------------------------------------------------------------------//




    public boolean isBelenced(Node head){
        if(head == null){
            return true;
        }

        int left = height(head.left);
        int right = height(head.right);
        
        if(Math.abs(left - right) > 1){
            return false;
        }
        return (isBelenced(head.left) && isBelenced(head.right));
    }


    static class Store{
        int ht;
        public Store(int ht){
            this.ht = ht;
        }
    }

    public Store isBelencedClass(Node head){
        if(head == null){
            return new Store(0);
        }

        Store left = isBelencedClass(head.left);
        Store right = isBelencedClass(head.right);

        Store s1 = new Store(Math.max(left.ht, right.ht) + 1);
        return s1;
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


    public boolean mirrorTreeCheack(Node head1, Node head2){
        if(head1 == null && head2 == null){
            return true;
        }
        if(head1 == null || head2 == null){
            return false;
        }
        if(head1.data != head2.data){
            return false;
        }
        return (head1.data == head2.data) && mirrorTreeCheack(head1.left, head2.right) && mirrorTreeCheack(head1.right, head2.left); 
    }



    public int isBalancedCheck(Node head)
    {
        if(head == null)
        {
            return 0;
        }
        
        int lh = isBalancedCheck(head.left);
        if(lh == -1)
        {
            return -1;
        }
        
        int rh = isBalancedCheck(head.right);
        if(rh == -1)
        {
            return -1;
        }
        
        if(Math.abs(lh-rh) > 1)
        {
            return -1;
        }
        else
        {
            return 1 + Math.max(lh, rh);
        }
    }
    
    public boolean isBalanced(Node head)
    {
        if(isBalancedCheck(head) == -1)
        {
            return false;
        }
        return true;
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
