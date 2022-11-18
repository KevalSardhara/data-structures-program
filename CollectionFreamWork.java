package Prectices_12_01_2022;

import java.util.Stack;
// import java.util.ArrayList;


public class CollectionFreamWork {
    public static void main(String[] args) {

        Stack <Integer> s1 = new Stack<Integer>();
        s1.add(189);
        s1.add(156);
        s1.add(199);
        s1.add(148);
        s1.add(112);

        System.out.println("Stack " + s1);
        System.out.println(s1.get(2));

        for(int i = 0; i < s1.size(); i++){
            System.out.println(s1.get(i));
        } 
    }
}
class Google{
    
}
