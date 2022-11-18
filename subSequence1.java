package Prectices_12_01_2022;

public class subSequence1 {
    public static void main(String[] args) {
        String str = "ABC";
        String ans = "";
        int n = str.length();
        subSequence1(str, ans, 0);
    }
    public static void subSequence1(String str, String ans, int i){
        if(str.length() == i){
            System.out.println(ans);
            return;
        }
            char ch = str.charAt(i);
            subSequence1(str, ans, i+1);
            subSequence1(str, ans + ch, i+1);
    }
}
