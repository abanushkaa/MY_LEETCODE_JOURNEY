// import java.util.Arrays;
// import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);                 // default -1
        Stack<Integer> st = new Stack<>();    // store indices

        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while (!st.isEmpty() && nums[st.peek()] < nums[idx]) {
                ans[st.pop()] = nums[idx];
            }
            if (i < n) st.push(i); // push each index only once (first pass)
        }

        return ans;
    }
}
