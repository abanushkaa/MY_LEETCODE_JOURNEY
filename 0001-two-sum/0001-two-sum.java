class Solution {
    class Pair{
        int value;
        int index;
        Pair(int value,int index){
            this.value=value;
            this.index=index;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Pair[] pairs=new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            pairs[i]=new Pair(nums[i],i);
        }
        Arrays.sort(pairs, (a,b)-> a.value - b.value);
        int i=0;
        int j=pairs.length-1;
        while(i<j){
            int sum=pairs[i].value+pairs[j].value;
            if(sum==target){
                return new int[]{pairs[i].index,pairs[j].index};
               
            }
            if(sum<target){
                i++;
            }else if(sum>target){
                j--;
            }
        }
        return null;
    }
}