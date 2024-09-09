/*
Duplicate Number problem.  Given an array of n+1 integers where each integer is between 1 and n (inclusive), there is exactly one duplicate number. Find the duplicate number using only one for loop.

Example: Input: [1, 3, 4, 2, 2], Output: 2
*/

public class p19 {
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 2, 2};
        System.out.println(duplicateNumber(arr.length, arr));
    }

    static int duplicateNumber(int n, int arr[]) {
        n = n - 1;
        int actual_sum = (n * (n + 1)) / 2; //calculate sum from 1 to n
        int arr_sum = 0;
        for(int i = 0; i < n + 1; i++)
            arr_sum = arr_sum + arr[i]; //calculate array sum
        return (arr_sum - actual_sum); //find exceeding number in the array
    }
}
