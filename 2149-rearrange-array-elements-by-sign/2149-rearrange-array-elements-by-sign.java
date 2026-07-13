class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        List <Integer> pos =new ArrayList<>();
        List <Integer> neg =new ArrayList<>();
        for(int num: nums){
            if(num>0) pos.add(num);
            else neg.add(num);
        }
        int[] result = new int[n];
        int i = 0, p = 0, ng = 0;
        
        while(p < pos.size() && ng < neg.size()){
            result[i++] = pos.get(p++);
            result[i++] = neg.get(ng++);
        }
        return result;
    }
}
 /*while (p < pos.size() && ng < neg.size()) {
        result[i++] = pos.get(p++);
        result[i++] = neg.get(ng++);
    }

    return result;
}*/