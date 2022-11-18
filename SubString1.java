package Prectices_12_01_2022;

public class SubString1 {
    public static void main(String[] args) {
        String str = "ABC";
        String ans = "";
        int n = str.length();
        subStringData(str,ans, n);

    }
    public static void subStringData(String str,String ans, int n){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            String ptr = str.substring(0,i) + str.substring(i+1);
            subStringData(ptr,ans + ch,n);
        }
    }
}
