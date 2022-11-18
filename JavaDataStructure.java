package Prectices_12_01_2022;

import java.util.LinkedList;

public class JavaDataStructure {
    public static void main(String[] args) {
        LinkedList <Integer> l1 = new LinkedList<Integer>();
        Integer i1 = Integer.valueOf(122222);
        int i = i1.intValue();

        System.out.println(i);

        l1.add(Integer.valueOf(56));
        l1.add(Integer.valueOf(999));
        l1.add(99);
        l1.add(100);
        System.out.println(l1);

        int s1 = Integer.parseInt("551");
        l1.add(s1);
        System.out.println(l1);

        l1.removeLast();
        l1.removeLast();
        System.out.println(l1);

        System.out.println(l1.getLast());
        l1.add(2, 1111111111);
        System.out.println(l1);


        for(int l : l1) {
            System.out.println(l);
        }

        
        // Data d1 = new Data();
        // System.out.println(Data.a);
        // }

        // static class Data{
        //     static int a = 12;
        // }


        
        Data d1 = new Data();
        System.out.println(d1.a);
    }

        static class Data{
            int a = 12;
        }
}
