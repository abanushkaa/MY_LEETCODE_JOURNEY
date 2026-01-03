class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int officer=0;
        int res=0;
        int cm=1;
        while(cm<n){
            if(nums[cm]==nums[cm-1]){
                cm++;
                continue;
            }
            nums[officer+1]=nums[cm];
            officer++;
            res++;
            cm++;
        }
        return officer+1;
    }
}