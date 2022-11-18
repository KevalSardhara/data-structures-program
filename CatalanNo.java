package Prectices_12_01_2022;

public class CatalanNo {
    public static void main(String[] args) {
        int n = 10;
        int a[] = new int[n];
        a[0] = 1;
        a[1] = 1;

        // for(int i = 2; i < n; i++){
        //     sum = 0;
        //     for(int j = 0; j < i; j++){
        //         sum += a[j] * a[i-1-j];
        //     }
        //     a[i] = sum;
        // }

        System.out.println(catlanNumber(10));

        for(int j = 0; j < n; j++){
            a[j] =catlanNumber(j);
        }
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
    }
    public static int catlanNumber(int n){
            if(n <= 1){
                return 1;
            }
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum = sum + catlanNumber(i) + catlanNumber(n-i-1);
            }
            return sum;
    }
}
