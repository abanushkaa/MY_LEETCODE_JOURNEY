class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length(); // Get length of array
        
        // 1. Find the peak index (maximum element)
        int peak = findPeak(mountainArr, 0, n - 1);
        
        // 2. Search in increasing part (left side of peak)
        int left = binarySearch(mountainArr, target, 0, peak, true);
        if (left != -1) return left;

        // 3. Search in decreasing part (right side of peak)
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    // Helper: Find index of the peak in mountain array
    private int findPeak(MountainArray arr, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) < arr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Helper: Binary search, can handle ascending or descending order
    private int binarySearch(MountainArray arr, int target, int low, int high, boolean ascending) {
        while (low <= high) {
            int mid= low + (high - low) / 2;
            int val = arr.get(mid);
            if (val == target) return mid;
            if (ascending) {
                if (val < target) low = mid + 1;
                else high = mid - 1;
            } else {
                if (val > target) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
