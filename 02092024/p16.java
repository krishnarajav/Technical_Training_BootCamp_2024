/*
Traverse a matrix clockwise.  Ask user to enter number of rows and number of columns in a 2 dimension matrix.  Using these numbers, ask user to enter the matrix elements.  Once the matrix elements are entered, program needs to start from the top left corner of the matrix and traverse the matrix in clockwise spiral and print all values in a single line.
E.g.
Input 1: 3 3
Input 2: 9 8 1
         2 5 4
         3 0 7
Output: 9 8 1 4 7 0 3 2 5
*************
Input 1: 2 4
Input 2: 8 4 2 6
         1 7 9 3
Output: 8 4 2 6 3 9 7 1
*/

import java.util.Scanner;
public class p16 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int arr[][] = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) 
                arr[i][j] = scan.nextInt();
        System.out.println();  
        matrixTraversal(m, n, arr);        
        scan.close();
    }

    static void matrixTraversal(int m, int n, int arr[][]) {
        int i = 0, j = 0, temp = 0;
        if(m < n)
            temp = m;
        else
            temp = n;
        int iter = (int) Math.ceil((double)temp/2);
        int count = 0;
        while(count < iter) {
            // Traverse left to right
            while(j < n - count) {
                System.out.print(arr[i][j]+" ");
                j++;
            }
            j--;
            i++;
            // Traverse top to bottom
            while(i < m - count) {
                System.out.print(arr[i][j]+" ");
                i++;
            }
            i--;
            j--;
            // Traverse right to left
            while(j >= count) {
                System.out.print(arr[i][j]+" ");
                j--;
            }
            j++;
            i--;
            // Traverse bottom to top
            while(i >= count + 1) {
                System.out.print(arr[i][j]+" ");
                i--;
            }
            i++;
            j++;
            count++;
        }
    }
}