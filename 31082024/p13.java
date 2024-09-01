/*
You are given a string.  If the string has some “#”, in it you have to move all the hashes to the front of the string and return the whole string back.
Input - Move#From#Here#ToStart
output  - ###MoveFromHereToStart
*/

public class p13 {
    public static void main(String[] args) {
        String input = "Move#From#Here#ToStart";
        System.out.println(formatString(input));
    }

    static String formatString(String input) {
        StringBuffer sb = new StringBuffer(input);
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '#'){
                sb.delete(i, i + 1);
                sb.insert(0, '#');
            }
        }
        return sb.toString();
    }
}
