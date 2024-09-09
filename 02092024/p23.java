/*
Create an unordered list of book titles and write a program that DOES NOT USE any inbuilt search or sort functions and accomplishes the following
1. Search for a title using linear search
2. Sort the book titles using "selection sort"
3. Search for a title in the sorted list using binary search
*/

public class p23 {
    public static void main(String[] args) {
        String arr[] = {
        "Tom Lake", 
        "Holly", 
        "The Exchange", 
        "House of Flame and Shadow", 
        "Funny Story", 
        "Poverty, by America", 
        "Elon Musk", 
        "Pageboy",
        "Prequel",
        "The Woman in Me",
        "Gone Girl",
        "The Girl with the Dragon Tattoo",
        "The Silence of the Lambs",
        "Rebecca",
        "Shutter Island",
        "The Da Vinci Code",
        "Before I Go to Sleep",
        "The Woman in White",
        "The Talented Mr. Ripley",
        "Big Little Lies",
        "The Diary of a Young Girl",
        "Long Walk to Freedom",
        "The Story of My Experiments with Truth",
        "I Know Why the Caged Bird Sings",
        "The Autobiography of Malcolm X",
        "Bossy Pants",
        "Becoming",
        "Steve Jobs",
        "Born a Crime",
        "All Quiet on the Western Front",
        "War and Peace",
        "The Things They Carried",
        "Catch-22",
        "A Farewell to Arms",
        "The Red Badge of Courage",
        "For Whom the Bell Tolls",
        "Slaughter",
        "The Naked and the Dead",
        "The Book Thief"};
        String search = "Prequel";
        int pos = linearSearch(arr, search);
        if(pos != -1)
            System.out.println("\""+search+"\" found at position "+pos);
        else
            System.out.println("\""+search+"\" not found");
        arr = selectionSort(arr);
        System.out.println();
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        System.out.println();
        pos = binarySearch(arr, search);
        if(pos != -1)
            System.out.println("\""+search+"\" found at position "+pos);
        else
            System.out.println("\""+search+"\" not found");
    }

    static int linearSearch(String arr[], String search) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].toUpperCase().equals(search.toUpperCase()))
                return i + 1;
        }
        return -1;
    }
    
    static String[] selectionSort(String arr[]) {
        int min, i, j;
        for(i = 0; i < arr.length - 1; i++) {
            min = i;
            for(j = i + 1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[min]) < 0)
                    min = j;
            }
            if(min != i) { 
                String temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    static int binarySearch(String arr[], String search) {
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int comparison = search.compareTo(arr[mid]);
            if(comparison == 0)
                return mid;
            else if(comparison < 0) 
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}