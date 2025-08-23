class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> outerList = new ArrayList<>();
        Arrays.sort(nums);
        for (int a = 0; a < n; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;  // skip duplicates for a
            for (int b = a + 1; b < n; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;  // skip duplicates for b
                int c = b + 1, d = n - 1;
                while (c < d) {
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d]; // Use long to avoid overflow
                    if (sum < target) {
                        c++;
                    } else if (sum > target) {
                        d--;
                    } else {
                        outerList.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        d--;
                        // skip duplicates for c
                        while (c < d && nums[c] == nums[c - 1]) c++;
                        // skip duplicates for d
                        while (c < d && nums[d] == nums[d + 1]) d--;
                    }
                }
            }
        }
        return outerList;
    }
}
