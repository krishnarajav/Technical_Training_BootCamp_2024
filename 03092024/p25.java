/*
Using recursion technique write a program to reverse a string.
*/

public class p25 {
    public static void main(String[] args) {
        String str = "reverse";
        System.out.println(stringReversal(str));
    }

    static String stringReversal(String str) {
        if(str.isEmpty())
            return str;
        else    
            return stringReversal(str.substring(1)) + str.charAt(0);
    }
}
