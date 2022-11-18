package Prectices_12_01_2022.BinaryTreePro.Infix;

public class PreOrderToInprder {
    public static void main(String[] args) {
        
        int postorder[] = new int[]{3, 2, 1, 6, 5, 4 ,7};
        int inorder[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int end = postorder.length - 1;
        int st = 0;
        InfixData i1 = new InfixData();
        InfixData.Node head = i1.PreInOrder(postorder, inorder, st, end);
        i1.printData(head);
        System.out.println();
        System.out.println(i1.chackIsBT(head));

        i1. deletData(head,1);
        i1.printData(head);
    }
}

class InfixData{
        static int i = 0;

        public Node PreInOrder(int post[], int in[], int st, int end) {
        int val = post[i];
        if(st > end){
            return null;
        }
        i++;
        Node head = new Node(val);
        if(st == end){
            return head;
        }
        int pos = search(in, st, end, val);
        head.left = PreInOrder(post, in, st, pos - 1);
        head.right = PreInOrder(post, in, pos + 1, end);
        return head;
    }

    public int search(int in[], int st, int end, int val){
        for(int i = st; i <= end; i++){
            if(in[i] == val){
                return i;
            }
        }
        return -1;
    }

    public void printData(Node head){
        if(head != null){
            printData(head.left);
            System.out.print(head.data + " ");
            printData(head.right);
        }
    }



    public boolean chackIsBT(Node head){
        if(head == null){
            return true;
        }
        if(head.left != null && head.left.data > head.data){
            return false;
        }
    
        if(head.right != null && head.right.data < head.data){
            return false;
        }
        boolean left = chackIsBT(head.left);
        boolean right = chackIsBT(head.right);
        if(left == true && right == true){
            return true;
        }

        return false;
    }










    public Node deletData(Node head,int d)
	{
		Node temp;
		if(head == null)
		{
			return head;
		}
		
		else if(d < head.data)
		{
			head.left = deletData(head.left,d);
		}
		else if(d > head.data)
		{
			head.right = deletData(head.right,d);
		}
		else
		{
			if((head.left != null) && (head.right != null))
			{
				temp = maxDataNode(head.left);
				head.data = temp.data;
				head.left = deletData(head.left,head.data);
			}
			else
			{
				temp = head;
				if(head.left == null)
				{
					head = head.right;
				}
				
				else if(head.right == null)
				{
					head = head.left;
				}
				
				temp = null;
			}
		}
		
		return head;
	}

    public Node maxDataNode(Node head){
        if(head.right == null){
            return head;
        }
        return maxDataNode(head.right);
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
