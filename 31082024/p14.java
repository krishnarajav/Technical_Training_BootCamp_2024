/*
You’re given a string where multiple characters are repeated consecutively. You’re supposed to reduce the size of this string using mathematical logic given as in the example below :
Input = abbbccddddde
Output = ab3c2d5e
*/

public class p14 {
    public static void main(String[] args) {
        String input = "aa";
        System.out.println(reduceString(input));
    }

    static String reduceString(String input) {
        int count = 0;
        char cur, prev = '\0';
        String res = "";
        for(int i = 0; i < input.length(); i++) {
            cur = input.charAt(i);
            if(cur == prev) {
                count = count + 1;
                prev = cur;
                if(i == input.length() - 1)
                    res += Character.toString(prev) + count;
            }
            else if(i == 0){
                prev = cur;
                count = 1;
                if(input.length() == 1)
                    res += Character.toString(prev);
                continue;
            }
            else {
                if(count == 1) {
                    res += Character.toString(prev);
                    prev = cur;
                    if(i == input.length() - 1) {
                        res += Character.toString(cur);
                        continue;
                    }
                    continue;
                }
                res += Character.toString(prev) + count;
                prev = cur;
                count = 1;
                
            }
        }
        return res;
    }
}
