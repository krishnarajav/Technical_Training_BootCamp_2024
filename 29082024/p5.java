/*
Get an input string S from the user.  If the string consists of ‘*’ and ‘#’, program needs to find the minimum number of ‘*’ or ‘#’ to make it a valid string. The string is considered valid if the number of ‘*’ and ‘#’ are equal. The ‘*’ and ‘#’ can be at any position in the string.
Note : The output will be zero, positive or negative integer based on number of ‘*’ and ‘#’ in the input string.

Sample test cases 
Input: Str#ing*Con**sists#of, output: 3* - 2# = 1
Input  Less*a##ndMo##re#, output: 1* - 5# = -4
Input: Equ##al**Num#*bers, output: 3* - 3# = 0
*/

import java.util.Scanner;
public class p5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int diff = minCharactersNeeded(str);
        if(diff == 0)
            System.out.println("Valid string");
        else 
            System.out.println("String needs addidtional "+diff+" * or #");
        scan.close(); 
    }

    static int minCharactersNeeded(String str) {
        int asterisk = 0, hash = 0;
        for(char ch : str.toCharArray()) {
            if(ch == '*' || ch == '#') {
                if(ch == '*') 
                    asterisk++;
                else 
                    hash++;
            }
        }
        int diff = Math.abs(hash - asterisk);
        return diff;
    }
}
