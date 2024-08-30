/* 
    Suppose N = 7, output should be 
               1
              232
             34543
            4567654
           567898765
          67890109876
         7890123210987
*/

public class p7 {
    public static void main(String[] args) {
        int n = 2;
        drawpyramid(n);
    }
    
    static void drawpyramid(int n) {
        int i, j, k, temp;
        //Iterate through rows
        for(i = 0; i < n; i++) {
            //Print n-row blanks 
            for(j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            temp = i;
            //Print numbers until half (including middle number)
            for(k = 0; k <= i; k++) {
                if(temp == 9)
                    temp = -1;
                System.out.print(++temp);
            }
            //Print next to middle number
            for(k = 0; k < i; k++) {
                if(temp == 0)
                    temp = 10;
                System.out.print(--temp);
            }
            System.out.println(); 
        }
    }
}