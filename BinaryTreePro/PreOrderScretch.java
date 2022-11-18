package Prectices_12_01_2022.BinaryTreePro;

import java.util.LinkedList;
import java.util.Queue;

public class PreOrderScretch {

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

    static class PreOrderTree{
        static int ind = -1;
        public static Node addTreeData(int arr[]){
            ind++;
            if(arr[ind] == -1){
                return null;
            }
            Node head = new Node(arr[ind]);
            head.left = addTreeData(arr); 
            head.right = addTreeData(arr); 

            return head;
        }
    }
    public static void printData(Node head){
        if(head != null){
            System.out.print(head.data + " ");
            printData(head.left);
            printData(head.right);
        }
    }

    public static int height(Node head){
        if(head == null){
            return 0;
        }
        int left = height(head.left);
        int right = height(head.right);
        return Math.max(left, right) + 1;

    }


    public static int countData(Node head){
        if(head == null){
            return 0;
        }
        int left = height(head.left);
        int right = height(head.right);
        return left + right + 1;
    }


    public static int sumDataOfNode(Node head){
        if(head == null){
            return 0;
        }

        return height(head.left) + height(head.right) + head.data;

    }

    public static int treeDiameter(Node head){
        if(head == null){
            return 0;
        }
        int dime1 = treeDiameter(head.left);
        int dime2 = treeDiameter(head.right);
        int dime3 = height(head.left) + height(head.right) + 1;
        int dim = Math.max(dime3, Math.max(dime1, dime2));

        return dim;
    }

    public static int levalOredreTrv(Node head, int leval){
        Queue<Node> q1 = new LinkedList<Node>();
        q1.add(head);
        q1.add(null);
        int sum = 0;
        int c = 1;
        int value = 0;
        while(!q1.isEmpty()){
            Node front = q1.remove();
            if(front == null){
                if(c == leval){
                    value = sum;
                }
                sum = 0;
                c++;
                System.out.println();
                if(!q1.isEmpty()){
                    q1.add(null);
                }
                else{
                    break;
                }
            }
            else{
                sum = sum + front.data;
                System.out.print(front.data + " ");
                if(front.left != null){
                    q1.add(front.left);
                }
                if(front.right != null){
                    q1.add(front.right);
                }
            }
        }
        return value;
    }






    public static void zigzag(Node head){
        Queue<Node> q1 = new LinkedList<Node>();
        q1.add(head);
        q1.add(null);
        int a[] = new int[100];
        int i = 0;
        int c = 1;
        while(!q1.isEmpty()){
            Node front = q1.remove();
            if(front == null){
                if(c%2 == 1){
                    for(int j = 0; j < i; j++){
                        System.out.print(a[j] + " ");
                    }
                }
                else{
                    for(int j = i-1; j >= 0; j--){
                        System.out.print(a[j] + " ");
                    }
                }
                // System.out.print(a[0] + " "); -------------->>> For the Left View For the Binary Tree
                // System.out.print(a[i - 1] + " "); -------------->>> For the Right View For the Binary Tree
                
                i = 0;
                c++;
                System.out.println();
                if(!q1.isEmpty()){
                    q1.add(null);
                }
                else{
                    break;
                }
            }
            else{
                a[i] = front.data;
                i++;
                if(front.left != null){
                    q1.add(front.left);
                }
                if(front.right != null){
                    q1.add(front.right);
                }
            }
        }
    }

    static class TreeHight{
        int ht = 0;
        int dm = 0;

        public TreeHight(int ht, int dm){
            this.ht = ht;
            this.dm = dm;
        }
    }



    public static TreeHight diameterData(Node head){
        if(head == null){
            return new TreeHight(0,0);
        }
        TreeHight left = diameterData(head.left);
        TreeHight right = diameterData(head.right);
        int myHight = Math.max(left.ht,right.ht) + 1;

        int dim1 = left.dm;
        int dim2 = right.dm;
        int dim3 = left.ht + right.ht + 1;

        int myDim = Math.max(dim3, Math.max(dim1,dim2));
        TreeHight hit = new TreeHight(myHight,myDim);

        return hit;
    }

    public static boolean comperNext(Node mainTree, Node subTree){
        if(mainTree == null && subTree == null){
            return true;
        }

        if(mainTree == null || subTree == null){
            return false;
        }
        if(mainTree.data == subTree.data){
            return comperNext(mainTree.left, subTree.left) && comperNext(mainTree.right, subTree.right);
        }
            return false;
    }

    public static boolean comperTwoTree(Node mainTree, Node subTree){
        if(subTree == null){
            return true;
        }
        if(mainTree == null){
            return false;
        }
        if(mainTree.data == subTree.data){
            if(comperNext(mainTree, subTree)){
                return true;
            }
        }
        return comperTwoTree(mainTree.left, subTree) || comperTwoTree(mainTree.right, subTree);
    }




    public static int sumData(Node head){
        if(head != null){

            int left = sumData(head.left);
            int right = sumData(head.right);
            return (left + right + head.data);
        }

        return 0;
        // int left = sumData(head.left);
        // int right = sumData(head.right);
        // return left + right + head.data;

    }

    public static boolean isBlenced(Node head){
        if(head == null){
            return true;
        }

        int left = height(head.left);
        int right = height(head.left);
        if(Math.abs(left - right) > 1){
            return false;
        }
        else{
            return (isBlenced(head.left) && isBlenced(head.right));
        }
    }

    static int lh = 0;
    static int rh = 0;
    public static boolean isBlencedN(Node head,int h){
        if(head == null){
            return true;
        }

        if(isBlencedN(head.left,lh) == false){
            return false;
        }
        if(isBlencedN(head.right,rh) == false){
            return false;
        }
        h = Math.max(lh,rh) + 1;
        
        if(Math.abs(lh - rh) <= 1){
            return true;
        }
        else{
            return false;
        }
    }


    
    public static void headToLeaf(Node head,int arr[],int i)
    {
        
        if(head == null)
        {
            return;
        }
        arr[i] = head.data;
        headToLeaf(head.left,arr,i+1);
        headToLeaf(head.right,arr,i+1);
        if(head.left == null && head.right == null) {
            
            for(int ind = 0; ind <= i; ind++){
                System.out.print(arr[ind] + " ");
            }
            System.out.println();
            
        }
    }









    public static int sumData(Node head, int sum){

        if(head == null){
            //System.out.println(sum + " -----------------------------");
            return sum;
        }
        sum = sum + head.data;
        //System.out.println(sum + " -");
        sum = sumData(head.left,sum);
        sum = sumData(head.right,sum);
        return sum;
    }




    // public static int ancestore(Node head, int a){
    //     if(head == null){
    //         return 0;
    //     }
    //     if((head.left.data == a) || (head.right.data == a) || (ancestore(head.left, a)) || (ancestore(head.right, a)))
    //     {
    //         System.out.println(head.data + " - ");
    //         return 1;

    //     }
    //     return 0;
    // }









    static int h = 0;
    public static void main(String[] args) {
        Node head = null;
        Node head2 = null;
        
        PreOrderTree p1 = new PreOrderTree();
        

        int arr1[] = new int[]{1,2,-1,3,4,-1,-1,11,-1,-1,5,-1,6,7,-1,-1,8,9,-1,-1,10,11,12,-1,-1,-1,-1,-1};
        // int arr2[] = new int[]{1,2,-1,-1,3,-1,-1};
        head = p1.addTreeData(arr1);
        //head2 = p1.addTreeData(arr2);

        head2 =  new Node(1);
        head2.left = new Node(2);
        head2.right = new Node(3);
        // head2.left.right = new Node(4);
        // head2.right.right = new Node(5);
        
        printData(head);
        printData(head2);
        System.out.println();
        System.out.println(height(head));
        System.out.println(treeDiameter(head));
        System.out.println(diameterData(head).dm);

        System.out.println(comperTwoTree(head, head2));
        //System.out.println(sumData(head));
        System.out.println(sumData(head));

        System.out.println(isBlenced(head) + "=============");
        System.out.println(isBlencedN(head,h) + "-----");
        System.out.println(h);



        System.out.println(sumData(head,0) + "---");
        System.out.println("----------------------------------------");
        int array[] = new int[100];
        headToLeaf(head, array,0);


        // ancestore(head, 7);
        System.out.println(levalOredreTrv(head,4));
        zigzag(head);
    }
}
