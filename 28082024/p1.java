/*
Write a function that accepts a string input argument.  The function needs to return the transformed string by replacing all occurrences of the character ‘a’ with the character ‘b’ and vice versa.
*/

public class p1 {
    public static void main(String[] args) {
        String str = "abacus";
        System.out.println(stringTransform(str));
    }
    
    static String stringTransform(String str) {
        StringBuffer sb = new StringBuffer(str);
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'b' || str.charAt(i) == 'A' || str.charAt(i) == 'B') {
                if(str.charAt(i) == 'a')
                    sb.setCharAt(i, 'b');
                else if(str.charAt(i) == 'b')
                    sb.setCharAt(i, 'a');
                else if(str.charAt(i) == 'A')
                    sb.setCharAt(i, 'B');
                else if(str.charAt(i) == 'B')
                    sb.setCharAt(i, 'A');
            }
        }
        return sb.toString();
    }
}