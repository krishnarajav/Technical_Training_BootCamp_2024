/*
Given an array of integers, write a function that returns true if there is a Pythagorean triplet (a, b, c) that satisfies a2 + b2 = c2.
= {3, 1, 4, 6, 5} 
: True,  There is a Pythagorean triplet (3, 4, 5).
= {10, 4, 6, 12, 5} 
: False, There is no Pythagorean triplet. 
*/

import java.util.Scanner;
public class p9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        System.out.println(pythagoreanTriplet(n, arr));
        scan.close();
    }

    static boolean pythagoreanTriplet(int n, int arr[]) {
        int i, j, k;
        for(i = 0; i < n-1; i++) {
            for(j = i+1; j < n; j++) {
                for(k = 0; k < n; k++) {
                    if(k == i || k == j) 
                        continue;
                    else if((arr[i]*arr[i])+(arr[j]*arr[j]) == (arr[k]*arr[k])) 
                        return true;
                    else 
                        continue;
                }
            }
        }
        return false;
    }
}
