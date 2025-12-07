// class Solution {
//     public int search(int[] nums, int target) {
//         int l= 0;
//         int r= nums.length-1;
//         while(l<=r){
//             int mid=(l+r)/2;
//             if(nums[mid]==target){
//                 return mid;
//             }else if(target<nums[mid]){
//                 r=mid-1;
//             }else{
//                 l=mid+1;
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0;int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]== target) return mid;
            else if(target> nums[mid]) low= mid+1;
            else high=mid-1;
        }
        return -1;
    }
}