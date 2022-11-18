package Prectices_12_01_2022;

import Prectices_12_01_2022.MaltipalClassExess;
import Prectices_12_01_2022.Class1.Class2.Class3;


public class MaltipalClassExess{
    public static void main(String[] args) {
        Class1 c1 = new Class1();
        Class1.Class2 c2 = c1.new Class2();

        Class3 c3 = new Class3();
        c2.class33();
        c3.class3();
    }
}

class Class1{

    class Class2{
        public void class33(){
            System.out.println("class3");
        }
        static class Class3{
            
            public void class3(){
                System.out.println("class3");
            }
        }
    }
}
