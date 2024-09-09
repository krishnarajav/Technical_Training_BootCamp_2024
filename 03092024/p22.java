/*
The Container with Most Water problem or Trap Rain Water problem.
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai), find two lines that together with the x-axis forms a container that holds the most water without any line protruding above the surface of the water.  

Example: 
Input: [1,8,6,2,5,4,8,3,7]
Output: 40
*/
public class p22 {
    public static void main(String[] args) {
        int arr[] = {6, 5, 8, 9, 2, 3, 1};
        mostWater(arr);
    }

    static void mostWater(int arr[]) {
        int n = arr.length;
        int i, j, k = 0, maxArea = 0;
        for(i = 0; i < n - 1; i++) { //iterate through 0 to n - 1
            for(j = i + 1; j < n; j++) { //iterate through i + 1 to n
                int min = Math.min(arr[i], arr[j]); //calculate min of 2 endpoints to find breadth
                int area = min * (j - i); //calculate area 
                if(area > maxArea) { 
                    for(k = i + 1; k < j; k++) { //find if any in between element is greater than min of 2 endpoints
                        if(arr[k] > min) //if any element found to be greater than 2 endpoints stop iteration and don't update maxArea
                            break;  
                    }
                    if(k == j && arr[k - 1] <= min) //if iterating between 2 endpoints has no greater element than min of these 2 endpoints update maxArea = area 
                        maxArea = area;   
                }
            }
        }
        System.out.println(maxArea);
    }
}
