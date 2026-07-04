class Solution {
    public int totalFruit(int[] fruits) {

        int low=0;
        int ans=0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int high=0;high<fruits.length;high++){
            int right=fruits[high];
            freq.put(right,freq.getOrDefault(right,0)+1);
            while(freq.size()>2){
                int left=fruits[low];
                freq.put(left,freq.get(left)-1);
                if(freq.get(left)==0){
                    freq.remove(left);
                }
                low++;
            }
            // if(freq.size()==2|| freq.size()<2){
                ans=Math.max(ans,high-low+1);
            
        }
        return ans;
    }
}