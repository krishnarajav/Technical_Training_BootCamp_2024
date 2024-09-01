/*
What logic will you use to reverse an integer without using any string functions?  
Input: 6752 
Output: 2576 
*/

public class p15 {
    public static void main(String args[]) {
        int n = 1204;
        System.out.println(reverseNum(n));
    }

    static int reverseNum(int n) {
        int res = 0, rem;
        while(n > 0) {
            rem = n % 10;
            res = res * 10 + rem;
            n /= 10;
        }
        return res;
    }
}