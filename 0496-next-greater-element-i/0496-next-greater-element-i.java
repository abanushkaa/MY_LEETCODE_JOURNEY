class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            int nextGreater = -1;

            // Find index of x in nums2
            int j = 0;
            while (j < nums2.length && nums2[j] != x) {
                j++;
            }

            // Scan to the right for the next greater element
            for (int k = j + 1; k < nums2.length; k++) {
                if (nums2[k] > x) {
                    nextGreater = nums2[k];
                    break;
                }
            }

            result[i] = nextGreater; // assign inside the outer loop
        }

        return result;
    }
}
