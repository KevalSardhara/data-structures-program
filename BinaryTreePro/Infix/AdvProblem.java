package Prectices_12_01_2022.BinaryTreePro.Infix;

import Prectices_12_01_2022.BinaryTreePro.Infix.TreeStr.Node;

public class AdvProblem {
    public static void main(String[] args) {

        TreeStr.Node head = null;
        int a[] = new int[]{2,3,4,5,6,8,9,11,7};
        int b[] = new int[]{4,3,5,2,11,9,8,6,7};
        int start = 0;
        int end = b.length - 1;
        TreeStr t1 = new TreeStr();
        head = t1.PreToIn(a, b, start, end);
        t1.inOrder(head);
        System.out.println();
        System.out.println(t1.cheackTree(head));
        System.out.println(t1.height(head));
        System.out.println(t1.isBelencedCheack(head));

        System.out.println(t1.balanceClass(head).chk);
 

        System.out.println(t1.balClass(head).chk);


        TreeStr.Node head1 = new Node(1);
        head1.left = new Node(4);
        head1.right = new Node(6);
        head1.left.left = new Node(2);
        head1.left.right = new Node(1);
        head1.right.left = new Node(0);
        head1.right.right = new Node(-1);

        // TreeStr.Node head1 = new Node(1);
        // head1.left = new Node(2);
        // head1.right = new Node(3);
        // head1.left.left = new Node(0);
        // head1.left.right = new Node(1);
        // head1.right.left = new Node(1);
        // head1.right.right = new Node(1);
        // head1.right.left.left = new Node(9);
        // head1.right.left.left.left = new Node(11);


        System.out.println(t1.equalsTree(head, head1));

        System.out.println(t1.sumTreeData(head1).isSum);

        int arr[] = new int[20];
        t1.headToLeaf(head1,arr ,0,6);
        System.out.println(TreeStr.count);




        TreeStr.Node head2 = new Node(30);
        head2.left = new Node(10);
        head2.right = new Node(6);
        head2.left.left = new Node(20);
        head2.left.right = new Node(110);
        head2.left.right.left = new Node(100);
        head2.left.right.right = new Node(25);
        head2.left.right.left.left = new Node(99);
        head2.left.right.left.left.left = new Node(50);
        head2.right.left = new Node(100);
        head2.right.right = new Node(60);

        int k = 10;
        // System.out.println(t1.kthAncester(head2,2,k).data + " +-+-+-+-+-+-+-+-+-+-+ ");

        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        Node ans = t1.kthAncestorGo(head2,1,k);
        if(ans == null || ans.data == k){
            System.out.println(-1);
        }
        else{
            System.out.println(ans.data);
        }
    }
}

class TreeStr{

    static int k;
    public Node kthAncester(Node head,int k , int n){
        if(head == null){
            return null;
        }
        if(head.data == n){
            System.out.println("yes");
            return head;
        }

        Node left = kthAncester(head.left,k,n);
        Node right = kthAncester(head.right,k,n);

        if(left != null && right == null){
            k--;
            if(k <= 0){
                k = Integer.MAX_VALUE;
                //System.out.println(head.data);
                return head;
            }
            return left;
        }

        if(left == null && right != null){
            k--;
            if(k <= 0){
                k = Integer.MAX_VALUE;
                //System.out.println(head.data);
                return head;
            }
            return right;
        }
        return null;
    }


    //---------------------------------------------------------------------------------------------------//
    // static Node temp = null;
    // static Node kthAncestor(Node root, int node )
    // {
    //     // Base case
    //     if (root == null)
    //         return null;
         
    //     if (root.data == node||
    //     (temp = kthAncestor(root.left,node)) != null ||
    //     (temp = kthAncestor(root.right,node)) != null)
    //     {
    //         if (k > 0)    
    //             k--;
             
    //         else if (k == 0)
    //         {
    //             // print the kth ancestor
    //             System.out.print("Kth ancestor is: "+root.data);
                 
    //             // return null to stop further backtracking
    //             return null;
    //         }
             
    //         // return current node to previous call
    //         return root;
    //     }
    //     return null;
    // }

    public Node kthAncestorGo(Node head,int k,int n){
        this.k = k;
        System.out.println(k);
        Node ans = kthAncester(head, this.k, n);
        return ans;

    }





    static int i = 0;
    public int PositionOfTheData(int b[], int value, int start, int end){
        for(int i = start; i <= end; i++ ){
            if(value == b[i]){
                return i;
            }
        }
        return -1;
    }

    public Node PreToIn(int a[] , int b[], int start, int end){
        if(start > end){
            return null;
        }
        int value = a[i];
        i++;
        Node head = new Node(value);
        if(start == end){
            return head;
        }
        int pos = PositionOfTheData(b,value,start,end);
        head.left = PreToIn(a, b, start, pos - 1);
        head.right = PreToIn(a, b, pos + 1, end);

        return head;
    }

    public void inOrder(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.data + " ");
        inOrder(head.left);
        inOrder(head.right);
    }


    public int isBelenced(Node head){
        if(head == null){
            return 0;
        }
        int left = isBelenced(head.left);
        if(left == -1){
            return -1;
        }
        int right = isBelenced(head.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
            return -1;
        }
        else{
            return Math.max(left, right) + 1;
        }
    }
    
    public boolean cheackTree(Node head){
        if(isBelenced(head) > 1){
            return false;
        }
        return true;
    }



    public int height(Node head){
        if(head == null){
            return 0;
        }
        return Math.max(height(head.left), height(head.right)) + 1;
    }

    public boolean isBelencedCheack(Node head){
        if(head == null){
            return true;
        }
        boolean left = isBelencedCheack(head.left);
        boolean right = isBelencedCheack(head.right);
        boolean dim = Math.abs(height(head.left) - height(head.right)) <= 1;

        if(left && right && dim){
            return true;
        }
        else{
            return false;
        }
    }

    class Balance{
        boolean chk;
        int hi;
        public Balance(boolean chk,int hi) {
            this.chk = chk;
            this.hi = hi;
        }
    }
    public Balance balanceClass(Node head){
        if(head == null){
            return new Balance(true,0);
        }

        Balance left = balanceClass(head.left);
        Balance right = balanceClass(head.right);

        boolean leftData = left.chk;
        boolean rightData = right.chk;
        boolean dim = Math.abs(left.hi - right.hi) <= 1;
        
        Balance b1 = new Balance((leftData && rightData && dim) ? true : false ,Math.max(left.hi, right.hi) + 1);
        return b1;
    }



    //-------------------------------------------------------------------------------------------------------------//
    static int count = 0;
    public static void headToLeaf(Node head,int arr[],int i,int k)
    {
        
        if(head == null)
        {
            return;
        }
        arr[i] = head.data;
        headToLeaf(head.left,arr,i+1,k);
        headToLeaf(head.right,arr,i+1,k);
            int sum = 0;
        for(int ind = i; ind >= 0 ; ind--){
            sum += arr[ind];
            if(sum == k){
                count++;
            }
        }
            // i--;
            // sum += arr[ind];
            // if(sum == k){
            //     count++;
            //     System.out.println("-");
            // }
            // System.out.print(arr[ind] + " ");
    }
    //-------------------------------------------------------------------------------------------------------------//












    class Bal{
        boolean chk = true;
        int hi = 0;
    }
    public Bal balClass(Node head){
        if(head == null){
            return new Bal();
        }

        Bal left = balClass(head.left);
        Bal right = balClass(head.right);

        boolean leftData = left.chk;
        boolean rightData = right.chk;
        boolean dim = Math.abs(left.hi - right.hi) <= 1;

        Bal b1 = new Bal();
        b1.hi = Math.max(left.hi, right.hi) + 1;

        if(leftData && rightData && dim){
            b1.chk = true;
        }
        else{
            b1.chk = false;
        }
        return b1;
    }


    public boolean equalsTree(Node head,Node head1){
        if(head == null && head1 == null){
            return true;
        }
        if(head != null && head1 == null){
            return false;
        }
        if(head == null && head1 != null){
            return false;
        }
        boolean left = equalsTree(head.left, head1.left);
        boolean right = equalsTree(head.right ,head1.right);
        boolean value = head.data == head1.data;
        if(left && right && value){
            return true;
        }
        else{
            return false;
        }


        // if(head == null && head1 == null){
        //     return true;
        // }
        // if(head == null || head1 == null){
        //     return false;
        // }
        // if(head.data == head1.data){
        //     return equalsTree(head.left,head1.left) && equalsTree(head.right,head1.right);
        // }
        // return false;
        
    }


    // class SumData{
    //     boolean isSum;
    //     int sum;

    //     public SumData(boolean isSum, int sum) {
    //         this.isSum = isSum;
    //         this.sum = sum;
    //     }
    // }

    // public SumData sumTreeData(Node head){
    //     if(head == null){
    //         return new SumData(true, 0);
    //     }

    //     if(head.left == null && head.right == null){
    //         SumData s1 = new SumData(true,head.data);
    //         return s1;
    //     }
    //     SumData left = sumTreeData(head.left);
    //     SumData right = sumTreeData(head.right);
        
    //     boolean leftData = left.isSum;
    //     boolean rightData = right.isSum;
    //     boolean condn = head.data == left.sum + right.sum;
        
    //     SumData s1 = new SumData((leftData && rightData && condn) ? true : false, (leftData && rightData && condn) ? 2*head.data : 0);
    //     return s1;
    // }



    class SumData{
        boolean isSum = true;
        int sum = 0;
    }

    public SumData sumTreeData(Node head){
        if(head == null){
            return new SumData();
        }

        if(head.left == null && head.right == null){
            SumData s2 = new SumData();
            s2.isSum = true;
            s2.sum = head.data;
            return s2;
        }
        SumData left = sumTreeData(head.left);
        SumData right = sumTreeData(head.right);
        
        boolean leftData = left.isSum;
        boolean rightData = right.isSum;
        boolean condn = head.data == (left.sum + right.sum);
        
        SumData s1 = new SumData();
        if((leftData && rightData && condn)){
            s1.isSum = true;
            s1.sum = 2 * head.data;
        }
        else{
            s1.isSum = false;
        }
        return s1;
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
}
