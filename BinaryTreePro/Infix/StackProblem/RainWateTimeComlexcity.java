package Prectices_12_01_2022.BinaryTreePro.Infix.StackProblem;
import java.util.Stack;

public class RainWateTimeComlexcity {
    public static void main(String[] args) {
        int a[] = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        Stack<Integer> s1 = new Stack<Integer>();
        System.out.println(rainWater(a,s1));
    }

    public static int rainWater(int a[], Stack<Integer> s1){
        int ans = 0;
        // for(int i = 0; i < a.length; i++){

        //     while(!s1.isEmpty() && a[s1.peek()] < a[i]){
        //         int curr = s1.peek();
        //         s1.pop();
        //         if(s1.isEmpty()){
        //             break;
        //         }
        //         int diff = i - s1.peek() - 1;
        //         ans = ans + (Math.min(a[s1.peek()],a[i]) - a[curr]) * diff;
        //     }
        //         s1.push(i);
        // }
        // return ans;

        
        for(int i = 0; i < a.length; i++){
            while(!s1.isEmpty() && a[s1.peek()] < a[i]){
                int curr = s1.peek();
                s1.pop();
                if(s1.isEmpty()){
                    break;
                }
                int diff = i - s1.peek() - 1;
                ans = ans + (Math.min(a[s1.peek()],a[i]) - a[curr]) * diff;
            }
            s1.push(i);
        }
    
        return ans;
    }
}
