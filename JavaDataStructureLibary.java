package Prectices_12_01_2022;
import java.util.ArrayList;
public class JavaDataStructureLibary {
    public static void main(String[] args) {
        ArrayList<Integer> i1 = new ArrayList<Integer>();
        ArrayList<Integer> i2 = new ArrayList<Integer>();

        i1.add(Integer.valueOf(56));
        i1.add(57);
        i1.add(58);
        i1.add(59);
        i1.add(510);
        i1.add(51111);
        System.out.println(i1);


        i1.remove(3);
        System.out.println(i1);

        i1.add(0, 999);

        System.out.println(i1);


        i2.add(Integer.valueOf(56));
        i2.add(57);
        i2.add(58);
        i2.add(59);
        i2.add(510);
        i2.add(51111);
        i1.addAll(i2);
        System.out.println(i1);

        for (int i = 0; i < i1.size(); i++){
            System.out.println(i1.get(i));
        }
    }
}
