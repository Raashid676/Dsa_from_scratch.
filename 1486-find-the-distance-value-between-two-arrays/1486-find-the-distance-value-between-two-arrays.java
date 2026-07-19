import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr2);

        int count = 0;

        for (int num : arr1) {

            int left = 0;
            int right = arr2.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arr2[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            boolean valid = true;

            // Check insertion position
            if (left < arr2.length && Math.abs(arr2[left] - num) <= d) {
                valid = false;
            }

            // Check previous element
            if (left > 0 && Math.abs(arr2[left - 1] - num) <= d) {
                valid = false;
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }
}