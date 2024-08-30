/*
Every decimal number can be changed into its binary form. Suppose your computer has it’s own Corona Virus, that eats binary digits from the right side of a number. Suppose a virus has 6 spikes, it will eat up 6 binary digits in your numbers.
You will have a bunch of numbers, and your machine will have a virus with n spikes, you have to calculate what will be the final situation of the final numbers.


First input, a single Integer N
Second input space separated integers of the bunch of values
Third input a single integer n, the number of spikes in Corona for Computer


Example:
Input:
5
1 2 3 4 5
2

Output:
0 0 0 1 1

Deloitte 2022
*/

import java.util.Scanner;
public class p6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        int spikes = scan.nextInt();    
        scan.close();
        ComputerCorona(n, arr, spikes);
    }

    static void ComputerCorona(int n, int arr[], int spikes) {
        for(int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer(Integer.toBinaryString(arr[i])); //Convert integer to binary
            if(sb.length() <= spikes) { //if spikes >= binary postions, make it 0
                sb.delete(0, sb.length());
                sb.append("0");
                arr[i] = Integer.parseInt(sb.toString(), 2);
                continue;
            }
            sb.reverse();
            sb.delete(0, spikes);
            sb.reverse();
            arr[i] = Integer.parseInt(sb.toString(), 2);
        }
        for(int i = 0; i < n; i++) 
            System.out.print(arr[i]+" ");
    }
}