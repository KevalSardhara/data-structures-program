package Prectices_12_01_2022;

public class DisePosition {
    public static void main(String[] args) {
        int s = 4;
        int e = 4;
        int c = disePosition(s, e);
        System.out.println(c);
    }
    public static int disePosition(int s, int e){
        if(s == e){
            return 1;
        }
        if(s > e){
            return 0;
        }

        int count = 0;
        for(int i = 1; i <= 6; i++){
            count = count + disePosition(s + i,e);
        }
        return count;
    }
}
