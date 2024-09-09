/*
Find the route from top left corner of a matrix to the bottom right corner of a matrix such that the sum of the numbers is 
a) Maximum
b) Minimum
The traversal can be horizonal, vertical or diagonal.

Example:
Input:
4 3 2 1 6
7 8 5 6 4
3 9 4 8 3
2 1 7 5 9
2 1 6 4 7

Output:
a) Maximum: 4->7->8->9->4->8->5->9->7
b) Minimum: 4->8->4->5->7
*/

import java.util.Scanner;
public class p24 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n  = scan.nextInt();
        int arr[][] = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) 
                arr[i][j] = scan.nextInt();
        System.out.println();  
        System.out.println("Maxpath: "+maxSumPath(m, n, arr));  
        System.out.println("Minpath: "+minSumPath(m, n, arr));
        scan.close();
    }

    static String maxSumPath(int m, int n, int arr[][]) {
        int matrix[][] = new int[m][n]; //new matrix to store sum from start to endpoint
        matrix[0][0] = arr[0][0];
        int i, j, max;
        for(i = 0; i < m - 1; i++)  
            matrix[i + 1][0] = arr[i + 1][0] + matrix[i][0]; //calculate sum on 1st column
        for(j = 0; j < n - 1; j++)  
            matrix[0][j + 1] = arr[0][j + 1] + matrix[0][j]; //calculate sum on 1st row
        i = 1;
        while(i < m) {
            j = 1;
            while(j < n) {
                //find max sum to add to current element
                max = Math.max(matrix[i - 1][j - 1], matrix[i - 1][j]); //find max between left diagonal and top element
                max = Math.max(max, matrix[i][j - 1]); //find max between previously found max and left element
                matrix[i][j] = arr[i][j] + max; //add max to current element
                j++;
            }
            i++;
        }
        /*for(i = 0; i < m; i++) { //to print matrix with max sum 
            for(j = 0; j < n; j++) 
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }*/
        //to print path 
        //traverse matrix from last element to arr[0][0]
        //at every step find maximizing neighbour
        //add each element in reversed form and in the last reverse the whole string to print it properly
        i = m - 1; j = n - 1;
        StringBuffer sb = new StringBuffer(String.valueOf(arr[i][j]));
        sb.reverse();
        String res = sb + ">-"; 
        sb.setLength(0);
        do {
            if(i > 0 && j > 0) {
                if(matrix[i - 1][j - 1] >= matrix[i - 1][j] && matrix[i - 1][j - 1] >= matrix[i][j - 1]) {
                    sb.append(arr[i - 1][j - 1]);
                    i--; j--;
                }
                else if(matrix[i - 1][j] >= matrix[i - 1][j - 1] && matrix[i - 1][j] >= matrix[i][j - 1]) {
                    sb.append(arr[i - 1][j]);
                    i--;
                }
                else {
                    sb.append(arr[i][j - 1]);
                    j--;
                }
                sb.reverse();
                res = res + sb + ">-";
                sb.setLength(0);
            }
            else {// if i == 0 or j == 0 then add every element on i == 0 or j == 0 respectively
                if(i == 0) {
                    while(j > 0) {
                        sb.append(arr[0][j - 1]);
                        res =  res + sb.reverse() + ">-";
                        sb.setLength(0);
                        j--;
                    }
                }
                else {
                    while(i > 0) {
                        sb.append(arr[i - 1][0]);
                        res =  res + sb.reverse() + ">-";
                        sb.setLength(0);
                        i--;
                    }
                }
            }
        }while(i != 0 && j != 0);
        sb.append(matrix[0][0]);//add leftout first element to string in reverse form
        res =  res + sb.reverse() + ">-";
        sb.setLength(0);
        sb = new StringBuffer(res);
        sb.reverse(); //reverse the whole string to make it proper path
        System.out.println("Max Sum = "+matrix[m - 1][n - 1]);
        return sb.delete(0, 2).toString();
    }

    static String minSumPath(int m, int n, int arr[][]) {
        int matrix[][] = new int[m][n]; //new matrix to store sum from start to endpoint
        matrix[0][0] = arr[0][0];
        int i, j, min;
        for(i = 0; i < m - 1; i++)  
            matrix[i + 1][0] = arr[i + 1][0] + matrix[i][0]; //calculate sum on 1st column
        for(j = 0; j < n - 1; j++)  //calculate sum on 1st row
            matrix[0][j + 1] = arr[0][j + 1] + matrix[0][j];
        i = 1;
        while(i < m) {
            j = 1;
            while(j < n) {
                //find min sum to add to current element
                min = Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]); //find min between left diagonal and top element
                min = Math.min(min, matrix[i][j - 1]); //find min between previously found min and left element
                matrix[i][j] = arr[i][j] + min; //add min to current element and store in matrix
                j++;
            }
            i++;
        }
        /*for(i = 0; i < m; i++) {
            for(j = 0; j < n; j++) 
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }*/
        //to print path 
        //traverse matrix from last element to arr[0][0]
        //at every step find manimizing neighbour
        //add each element in reversed form and in the last reverse the whole string to print it properly
        i = m - 1; j = n - 1;
        StringBuffer sb = new StringBuffer(String.valueOf(arr[i][j]));
        sb.reverse();
        String res = sb + ">-"; 
        sb.setLength(0);
        do {
            if(i > 0 && j > 0) {
                if(matrix[i - 1][j - 1] <= matrix[i - 1][j] && matrix[i - 1][j - 1] <= matrix[i][j - 1]) {
                    sb.append(arr[i - 1][j - 1]);
                    i--; j--;
                }
                else if(matrix[i - 1][j] <= matrix[i - 1][j - 1] && matrix[i - 1][j] <= matrix[i][j - 1]) {
                    sb.append(arr[i - 1][j]);
                    i--;
                }
                else {
                    sb.append(arr[i][j - 1]);
                    j--;
                }
                sb.reverse();
                res = res + sb + ">-";
                sb.setLength(0);
            }
            else {// if i == 0 or j == 0 then add every element on i == 0 or j == 0 respectively
                if(i == 0) {
                    while(j > 0) {
                        sb.append(arr[0][j - 1]);
                        res =  res + sb.reverse() + ">-";
                        sb.setLength(0);
                        j--;
                    }
                }
                else {
                    while(i > 0) {
                        sb.append(arr[i - 1][0]);
                        res =  res + sb.reverse() + ">-";
                        sb.setLength(0);
                        i--;
                    }
                }
            }
        }while(i != 0 && j != 0);
        sb = new StringBuffer(res);
        sb.reverse();
        System.out.println();
        System.out.println("Min Sum = "+matrix[m - 1][n - 1]);
        return sb.delete(0, 2).toString();
    }
}
