package Prectices_12_01_2022.BinaryTreePro;



public class CamalCase {
    public static void main(String[] args) {
        String str = "     cats AND*-Dogs-are   Awesome   ";
        // str = "a b c d-e-f%g";
        // str = "BOB loves-coding";
        System.out.println(camalCase(str));
    }
    public static String camalCase(String str){
        String ans = "";
        int a = 1;

        for(int i=0; i<str.length(); i++){
            
            if(((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) 
            && (a == 1)){
                char val = str.charAt(i) >= 65 && str.charAt(i) <= 90 ? (char)(32 + str.charAt(i)) : str.charAt(i);
                ans = ans + val;
                a = 0;
            }
            else if(((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122) ) && str.charAt(i-1) != ' ') {

                if((str.charAt(i-1) >= 33 && str.charAt(i-1) <= 47)){
                    char val = str.charAt(i) >= 65 && str.charAt(i) <= 90 ? (str.charAt(i)) : (char)(str.charAt(i)-32);
                    ans = ans + val;
                }
                else{
                    char val = str.charAt(i) >= 65 && str.charAt(i) <= 90 ? (char)(32 + str.charAt(i)) : str.charAt(i);
                    ans = ans + val;
                }
                
            }
            else if(((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) && str.charAt(i-1) == ' '){
                char val = str.charAt(i) >= 65 && str.charAt(i) <= 90 ? (str.charAt(i)) : (char)(str.charAt(i)-32);
                ans = ans + val;
            }
        }

        return ans;
    }
}



// public class CamalCase {
//     public static void main(String[] args) {
//         String str = "cats AND*Dogs-are Awesome";
//         str = "a b c d-e-f%g";
//         str = "BOB loves-coding";
//         System.out.println(camalCase(str));
//     }
//     public static String camalCase(String str){
//         String ans = "";
//         int a = 1;

//         for(int i=0; i<str.length(); i++){
            
//             if(((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) 
//             && (a == 1)){
//                 char val = str.charAt(i) >= 65 && str.charAt(i) <= 90 ? (char)(32 + str.charAt(i)) : str.charAt(i);
//                 ans = ans + val;
//                 a = 0;
//             }
//             else if(((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122) ) && str.charAt(i-1) != ' ') {

//                 if((str.charAt(i-1) >= 33 && str.charAt(i-1) <= 47)){
//                     char val = str.charAt(i) >= 65 && str.charAt(i) <= 90 ? (str.charAt(i)) : (char)(str.charAt(i)-32);
//                     ans = ans + val;
//                 }
//                 else{
//                     char val = str.charAt(i) >= 65 && str.charAt(i) <= 90 ? (char)(32 + str.charAt(i)) : str.charAt(i);
//                     ans = ans + val;
//                 }
                
//             }
//             else if(((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) && str.charAt(i-1) == ' '){
//                 char val = str.charAt(i) >= 65 && str.charAt(i) <= 90 ? (str.charAt(i)) : (char)(str.charAt(i)-32);
//                 ans = ans + val;
//             }
//         }

//         return ans;
//     }
// }


// Examples
// Input: "cats AND*Dogs-are Awesome"
// Output: catsAndDogsAreAwesome
// Input: "a b c d-e-f%g"
// Output: aBCDEFG


// For example: if str is "BOB loves-coding" then your program should return the string bobLovesCoding.



// else if(((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) && str.charAt(i-1) <= 46 && (str.charAt(i-1) >= 58 && str.charAt(i-1) <= 64) && str.charAt(i-1) >= 91 && str.charAt(i-1) <= 96 && str.charAt(i-1) >= 123){
//     char val = str.charAt(i) >= 65 && str.charAt(i) <= 90 ? (str.charAt(i)) : (char)(str.charAt(i)-32);
//     ans = ans + val;
// }