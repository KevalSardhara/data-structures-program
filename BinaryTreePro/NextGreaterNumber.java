package Prectices_12_01_2022.BinaryTreePro;

public class NextGreaterNumber {
        public static void main(String[] args) {
            

            int a = 218765;
            // output : 251678;
            int c = 0;
            int n = a;
            while(a != 0){
                c++;
                a = a/10;
            }
            // System.out.println(c);
            int arr[] = new int[c];

            c = 0;
            while(n != 0){
                arr[c] = n%10;
                c++;
                n = n/10;
            }

            int temp;
            for(int i=0; i<c/2; i++){
                temp = arr[i];
                arr[i] = arr[c-1-i];
                arr[c-1-i] = temp;
            }

            int f = -1;
            int l = -1;
            for(int i=c-1-1; i>=0; i--){
                if(arr[i] < arr[i+1]){
                    int data = arr[i];
                    
                    arr[i] = arr[c-1];

                    f = i+1;
                    l = arr.length-2;

                
                    // System.out.print(f + " --- " + l);
                    // for(int j=f; j<=l; j++){
                    //     temp = arr[j];
                    //     arr[j] = arr[l];
                    //     arr[l] = temp;
                    //     l = l-1;
                    // }

                    
                    for(int j=l; j>=f; j--){
                        arr[j+1] = arr[j];
                    }

                    // System.out.println(f-l);
                    int k = arr.length;
                    for(int j=arr.length - (l-f); j <= k; j++){
                        temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                        k = k-1;
                    }
                    


                    arr[i+1] = data;
                    break;
                }
            }

            for(int i=0; i<c; i++){
                System.out.print(arr[i] + " ");
            }


        }
}
