/*
Given an array of integers and an integer sum as inputs, find a pair of numbers (a, b) in the array where a + b = sum.
Input array: 
[5, 2, 4, 1, 3]
Input Sum: 7
Output: [5,2], [4,3]
*/

import java.util.Scanner;
public class p11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        int sum = scan.nextInt();
        pairSum(n, arr, sum);
        scan.close();
    }

    static void pairSum(int n, int arr[], int sum) {
        for(int i = 0; i < n-1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] + arr[j] == sum)
                    System.out.print("["+arr[i]+", "+arr[j]+"]    ");
            }
        }
    }
}
