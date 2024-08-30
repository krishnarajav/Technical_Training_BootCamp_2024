/*
Write an algorithm to determine if the spelling of a number is in the ascending order as per the English alphabet
*/

import java.util.Scanner;
public class p12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String words = convertToWords(n);
        //System.out.println(words);
        System.out.println(checkAlphabetic(words));
        scan.close();
    }

    //convert number into words
    static String convertToWords(int n) {
        char digit;
        String words = "";
        StringBuffer num = new StringBuffer(Integer.toString(n));
        while(num.length() > 0) {
            if(num.length() == 2 || num.length() == 1){
                words += firstTwenty(num.toString());
                return words;
            }
            switch (num.length()) {
                case 4: //for thousand
                    digit = num.charAt(0);
                    words += firstTwenty(Character.toString(digit)) + "Thousand ";
                    num.delete(0, 1);
                    break;
                case 3: // for hundred
                    digit = num.charAt(0);
                    words += firstTwenty(Character.toString(digit));
                    if(Integer.parseInt(Character.toString(digit)) != 0) 
                        words +="Hundred ";
                    num.delete(0, 1);
                    break;
                case 2: //for ten
                    words += firstTwenty(num.toString());
                    return words; 
                default:
                    System.exit(0);
            }
        }
        return "";
    }

    //to generate words of a number that ranges from 0 to 19
    static String firstTwenty(String num) {
        String first[] = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ",  "Thirteen ",  "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String tens[] = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        if(num.length() == 2) {
            if(num.charAt(0) == '1') {
                int number = Integer.parseInt(num);
                return first[number]; // for numbers from 10 to 19
            }
            else {
                return tens[Integer.parseInt(Character.toString(num.charAt(0)))] + first[Integer.parseInt(Character.toString(num.charAt(1)))]; //for ten's number
            }
        }
        else {
            return first[Integer.parseInt(num)]; //for unit's digit
        }
    }

    //check if letters in the words of a number are in the alphabetical order
    static boolean checkAlphabetic(String words) {
        int cur = 0, prev = 0;
        for(char ch : words.toCharArray()) {
            if(ch == ' ') //skip a whitespace in the string
                continue;
            cur = (int) ch;
            if(cur < prev) 
                return false;
            else 
                prev = cur;
        }
        return true;
    }
}
