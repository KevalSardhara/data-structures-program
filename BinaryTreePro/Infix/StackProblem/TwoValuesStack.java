package Prectices_12_01_2022.BinaryTreePro.Infix.StackProblem;

import java.util.Stack;

public class TwoValuesStack {
    public static void main(String[] args) {
        int a[] = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int b[] = new int[a.length];
        Stack<Integer> s1 = new Stack<Integer>();
        twoValuesStack(a,b,s1);
    }

    public static void twoValuesStack(int a[],int b[], Stack<Integer> s1){
        for(int i = 0; i < a.length; i++){
            int day = 1;
            while(!s1.isEmpty()){
                
            }
            s1.push(a[i]);
        }
    }
}
