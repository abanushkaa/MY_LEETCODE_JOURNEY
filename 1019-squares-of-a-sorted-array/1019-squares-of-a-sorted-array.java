class Solution {
    public int[] sortedSquares(int[] nums) {
        int n= nums.length;
        int res[] = new int[n];
        int left=0;int right=n-1;
        int pos = n-1;

        while(left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                res[pos] =nums[left]*nums[left];
                left++;
            }else{
                res[pos] = nums[right]*nums[right];
                right--;
            }
            pos--;
        }
        return res;
    }
}