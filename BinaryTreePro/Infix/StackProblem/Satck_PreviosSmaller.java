package Prectices_12_01_2022.BinaryTreePro.Infix.StackProblem;

import java.util.Stack;

public class Satck_PreviosSmaller {
    public static void main(String[] args) {
        
        int a[] = new int[]{4,10,5,8,20,15,3,12};
        int b[] = new int[a.length];
        Stack<Integer> s1 = new Stack<Integer>();
        previousSmall(a, b, s1);
        for (int i = 0; i < a.length; i++){
            System.out.print(b[i] + " ");
        }
    }
    public static void previousSmall(int a[],int b[], Stack<Integer> s1) {
        // Previous Smallest
        // for(int i = 0; i < a.length; i++){
        //     while(!s1.isEmpty()){
        //         if(s1.peek() <= a[i]){
        //             b[i] = s1.peek();
        //             s1.push(a[i]);
        //             break;
        //         }
        //         s1.pop();
        //     }
        //     if(s1.isEmpty()){
        //         b[i] = -1;
        //         s1.push(a[i]);
        //     }
        // }

        // Previous Greatter

        // for(int i = 0; i < a.length; i++){
        //     while(!s1.isEmpty()){
        //         if(s1.peek() >= a[i]){
        //             b[i] = s1.peek();
        //             s1.push(a[i]);
        //             break;
        //         }
        //         s1.pop();
        //     }
        //     if(s1.isEmpty()){
        //         b[i] = -1;
        //         s1.push(a[i]);
        //     }
        // }

        // Next Greatter
        // for(int i = a.length - 1; i >= 0; i--){
        //     while(!s1.isEmpty()){
        //         if(s1.peek() <= a[i]){
        //             b[i] = s1.peek();
        //             s1.push(a[i]);
        //             break;
        //         }
        //         s1.pop();
        //     }
        //     if(s1.isEmpty()){
        //         b[i] = -1;
        //         s1.push(a[i]);
        //     }
        // }

        // Next Smallest

        for(int i = a.length - 1; i >= 0; i--){
            while(!s1.isEmpty()){
                if(s1.peek() >= a[i]){
                    b[i] = s1.peek();
                    s1.push(a[i]);
                    break;
                }
                s1.pop();
            }
            if(s1.isEmpty()){
                b[i] = -1;
                s1.push(a[i]);
            }
        }


    }
}
