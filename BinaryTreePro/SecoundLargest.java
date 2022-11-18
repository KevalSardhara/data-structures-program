package Prectices_12_01_2022.BinaryTreePro;
import java.util.Scanner;

public class SecoundLargest {
    public static void main(String[] args){
        System.out.println("main");
        int a[] = new int[]{12,56,89,10,12,47,32,64,19,48};
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MAX_VALUE;
        Scanner sc = new Scanner(System.in);
        int c = 1;
        int n = sc.nextInt();
        int ans = -1;
        while(c <= n){
            for(int i=0; i<a.length; i++){
                if(max < a[i]){
                    if(max2 > a[i]){
                        max = a[i];
                        ans = a[i];
                    }
                }
            }
            max2 = max;
            max = Integer.MIN_VALUE;
            c++;
        }
        System.out.println(ans);
        sc.close();
    }
}
