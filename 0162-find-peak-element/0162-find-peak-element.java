// class Solution {
//     public int findPeakElement(int[] nums) {
//         int n = nums.length;
//         for(int i =0;i<n;i++){
//             if(( i==0 || nums[i]>nums[i-1]) && (i== n-1 || nums[i]>nums[i+1])){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak lies on the left side (including mid)
                high = mid;
            } else {
                // Peak lies on the right side
                low = mid + 1;
            }
        }

        // low == high is the peak index
        return low;
    }
}
