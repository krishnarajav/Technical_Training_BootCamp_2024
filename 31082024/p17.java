/*
Print sum of left diagonal and right diagonal of a n x n square matrix
Input
3
1 3 5
2 4 6
3 7 1

Left diagonal sum = 1 + 4 + 1 = 6
Right diagonal sum = 3 + 4 + 5 = 12
*/

import java.util.Scanner;
public class p17 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[][] = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) 
                arr[i][j] = scan.nextInt();
        System.out.println();  
        diagonalSum(n, arr);        
        scan.close();
    }

    static void diagonalSum(int n, int arr[][]) {
        int i = 0;
        int lDsum = 0, rDsum = 0;
        while(i < n) {
            lDsum += arr[i][i];
            i++;
        }
        System.out.println(lDsum);
        int iter = (int) Math.ceil((double)n/2);
        i = 0;
        while(i < iter) {
            if(i != n - i - 1)
                rDsum = rDsum + arr[i][n-i-1] + arr[n-i-1][i];
            else
                rDsum = rDsum + arr[i][i];
            i++;
        }
        System.out.println(rDsum);
    }
}
