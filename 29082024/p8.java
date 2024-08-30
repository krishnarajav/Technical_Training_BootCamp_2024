/*
Take an array as user input and print the Next Greater Element (NGE) for every element. 
The  for an element x is the first greater element on the right side of x in the array. Elements for which no greater element exist, consider the next greater element as -1. 

Input Array [7, 45, 3, 32, 74]
Output Array [45, 74, 32, 74, -1]

Input Array [9, 8, 7, 6, 10]
Output Array [10, 10, 10, 10, -1]
*/

import java.util.Scanner;
public class p8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        nge(n, arr);
        scan.close();
    }

    static void nge(int n, int arr[]) {
        int output[] = new int[n];
        int i, j;
        for(i = 0; i < n - 1; i++) {
            for(j = i + 1; j < n; j++) {
                if(arr[j] > arr[i]) {
                    output[i] = arr[j];
                    break;
                }
            }
            if(j == n && (arr[j - 1] < arr[i] || arr[j - 1] == arr[i]))
                output[i] = -1;
        }
        output[n - 1] = -1;
        for(i = 0; i < n; i++)
            System.out.print(output[i]+" ");
    }
}
