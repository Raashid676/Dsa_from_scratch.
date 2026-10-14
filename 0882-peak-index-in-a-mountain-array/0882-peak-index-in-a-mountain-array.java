


class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 1;
        int n = arr.length;
        int end = n - 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid - 1] < arr[mid]) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}