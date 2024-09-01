/*
Print top and bottom triangle sums in a n x n matrix.

Input 1: 4
Input 2:      2 4 6 8
              1 3 5 7
              3 7 1 3
              4 0 6 0
Top Sum = 2 + 4 + 6 + 8 + 3 + 5 = 28
Bottom Sum = 4 + 0 + 6 + 0 + 7 + 1 = 18

Input 1: 3
Input 2: 9 6 3
              8 4 2
              1 4 7
Top Sum = 9 + 6 + 3 + 4 = 22
Bottom Sum = 1 + 4 + 7 + 4 = 16
*/
import java.util.Scanner;
public class p18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[][] = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) 
                arr[i][j] = scan.nextInt();
        System.out.println();  
        System.out.println(triangleTopSum(n, arr)+"\n"+triangleBottomSum(n, arr));        
        scan.close();
    }

    //topsum calculation
    static int triangleTopSum(int n, int arr[][]) {
        int iter = (int) Math.ceil((double)n/2);
        int topSum = 0;
        int i = 0;
        while(i < iter) {
            topSum = topSum + arr[i][i];
            i++;
        }
        i = 0;
        while(i < iter) {
            if(i != n - i - 1)
                topSum += arr[i][n-i-1];
            else
                break;
            i++;
        }
        i = 1;
        while(i < n - 1) {
            topSum += arr[0][i];
            i++; 
        }
        return topSum;
    }

    //bottomsum calculation
    static int triangleBottomSum(int n, int arr[][]) {
        int iter = (int) Math.ceil((double)n/2);
        int bottomSum = 0;
        int i = 0;
        if(n % 2 == 0)
            i = iter;
        else 
            i = iter - 1;
        while(i < n) {
            bottomSum = bottomSum + arr[i][i];
            i++;
        }
        i = iter;
        while(i < n) {
            if(i != n - i - 1)
                bottomSum += arr[i][n-i-1];
            else
                break;
            i++;
        }
        i = 1;
        while(i < n - 1) {
            bottomSum += arr[n - 1][i];
            i++; 
        }
        return bottomSum;
    }
}
