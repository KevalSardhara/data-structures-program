package Prectices_12_01_2022.BinaryTreePro.Infix.StackProblem;

public class MaxConsicutedOnce {
    public static void main(String[] args) {
        int a[] = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int p = -1, q = -1,j;
        int k = 3;
        int max = 0;
        for(int i = 0; i < a.length; i++) {
            int c = 1;
            int count = 0;
            for(j = i; j < a.length; j++) {
                if(a[j] == 0 && c <= k){
                    c++;
                }
                else if(a[j] == 1){
                    count++;
                }
                else{
                    break;
                }
            }
            if(max < c + count-1){
                p = i;
                q = j-1;
                max = c + count-1;
            }
        }

        System.out.println(max + " " + p + " to " + q);
    }
}
