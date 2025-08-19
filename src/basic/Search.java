package basic;

public class Search {

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) return true;
            if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(arr, 5)); // true
        System.out.println(binarySearch(arr, 2)); // false
    }
}
