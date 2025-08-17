import java.util.*;

class Solution {
    // Helper class to store value and original index
    class Pair {
        int val;
        int idx;
        Pair(int v, int i) {
            val = v;
            idx = i;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n]; // final answer array
        Arrays.fill(result, 0); // initialize with 0

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i); // store (value, original index)
        }

        // Use merge sort to count smaller elements
        mergeSort(arr, 0, n - 1, result);

        return Arrays.asList(result);
    }

    // Modified merge sort
    private void mergeSort(Pair[] arr, int left, int right, Integer[] result) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, result);
        mergeSort(arr, mid + 1, right, result);

        merge(arr, left, mid, right, result);
    }

    // Merge step that also counts "smaller elements to the right"
    private void merge(Pair[] arr, int left, int mid, int right, Integer[] result) {
        List<Pair> temp = new ArrayList<>();

        int i = left;       // pointer for left half
        int j = mid + 1;    // pointer for right half
        int rightCount = 0; // how many numbers from right side are smaller

        while (i <= mid && j <= right) {
            if (arr[i].val <= arr[j].val) {
                // arr[i] is greater than 'rightCount' elements from right half
                result[arr[i].idx] += rightCount;
                temp.add(arr[i]);
                i++;
            } else {
                // arr[j] is smaller → will increase count for left elements
                rightCount++;
                temp.add(arr[j]);
                j++;
            }
        }

        // Add remaining left elements
        while (i <= mid) {
            result[arr[i].idx] += rightCount;
            temp.add(arr[i]);
            i++;
        }

        // Add remaining right elements
        while (j <= right) {
            temp.add(arr[j]);
            j++;
        }

        // Copy back to original array
        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }
    }
}
