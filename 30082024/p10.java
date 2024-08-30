/*
Input
1 2 3
4 5 6
7 8 9

Output
7 4 1
8 5 2
9 6 3
*/

import java.util.Scanner;
public class p10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int arr[][] = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) 
                arr[i][j] = scan.nextInt();
        System.out.println();  
        rotateby90(m, n, arr);        
        scan.close();
    }

    static void rotateby90(int m, int n, int arr[][]) {
        int output[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                output[i][j] = arr[m-j-1][i]; 
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }      
    }
}
