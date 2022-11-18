package Prectices_12_01_2022.BinaryTreePro.Infix.StackProblem;

import java.util.Stack;

public class RainWater {
    public static void main(String[] args) {
        Stack<Integer> s2 = new Stack<Integer>();
        int a[] = new int[]{4,2,1,5,6,3,2,4,2};
        int b[] = new int[a.length];
        int c[] = new int[a.length];

        rainWaterPro(a, b, c, s2);
        for (int i = 0; i < a.length; i++){
            System.out.print(b[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < a.length; i++){
            System.out.print(c[i] + " ");
        }



        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++){
            int ans = (c[i] - b[i] - 1) * a[i];
            if(max < ans){
                max = ans;
            }
        }
        System.out.println();
        System.out.println(max);


    }
    public static void rainWaterPro(int a[], int b[], int c[], Stack<Integer> s2){
        for(int i = 0; i < a.length; i++){
            while(!s2.isEmpty()){
                if(a[s2.peek()] < a[i]){
                    b[i] = s2.peek();
                    s2.push(i);
                    break;
                }
                s2.pop();
            }
            if(s2.isEmpty()){
                b[i] = -1;
                s2.push(i);
            }
        }

        while(!s2.isEmpty()){
            s2.pop();
        }

        for(int i = a.length - 1; i >= 0; i--){
            while(!s2.isEmpty()){
                if(a[s2.peek()] < a[i]){
                    c[i] = s2.peek();
                    s2.push(i);
                    break;
                }
                s2.pop();
            }
            if(s2.isEmpty()){
                c[i] = a.length;
                s2.push(i);
            }
        }




    }

}
