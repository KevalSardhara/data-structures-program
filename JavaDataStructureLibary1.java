package Prectices_12_01_2022;
import java.util.Stack;
public class JavaDataStructureLibary1 {


    public static void addBottam(int data, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        addBottam(data, s);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        addBottam(top,s);
    }

    // public static void data(){
    //     data1();

    // }
            
    // public static void data1(){
            
    // }
    public static void main(String[] args) {
        Stack <Integer> s = new Stack<Integer>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(11);
        s.push(22);
        s.push(33);
        System.out.println(s);
        addBottam(4,s); 
        reverseStack(s);
        // data();
               

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
