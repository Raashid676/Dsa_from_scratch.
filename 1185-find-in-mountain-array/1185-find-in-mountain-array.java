


class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        // Step 1: Find the peak index
        int peak = peakIndexOfTheArr(mountainArr);

        // Step 2: Search the ascending half
        int firstTry = binarySearch(mountainArr, target, 0, peak, true);

        if (firstTry != -1) {
            return firstTry;
        }

        // Step 3: Search the descending half
        return binarySearch(
            mountainArr,
            target,
            peak + 1,
            mountainArr.length() - 1,
            false
        );
    }

    // Find the peak index
    public int peakIndexOfTheArr(MountainArray mountainArr) {

        int l = 0;
        int r = mountainArr.length() - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    // Binary search for ascending or descending order
    public int binarySearch(
        MountainArray mountainArr,
        int target,
        int l,
        int r,
        boolean ascending
    ) {

        while (l <= r) {

            int mid = l + (r - l) / 2;

            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            }

            if (ascending) {

                if (target > value) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

            } else {

                if (target > value) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}