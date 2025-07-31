class Solution {
    public int findMin(int[] nums) {
        int n= nums.length;
        int start=0, end=n-1;
        while(start<end){
            int mid= start + (end-start)/2;
            // int next=(mid+1)%n ;
            // int prev=(mid-1+n)%n;
            // if (nums[mid]<=nums[next] && nums[mid]<=nums[prev])
                // return mid;
            if (nums[mid]>nums[end]){
                start=mid+1;
            }else
                end=mid;
            
        }
        return nums[start];
    }
}