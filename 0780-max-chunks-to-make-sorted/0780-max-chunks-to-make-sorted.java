class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxs=0;
        int chunks=0;
        for(int i=0;i<arr.length;i++){
            maxs= Math.max(maxs,arr[i]);
            if(maxs == i){
                chunks++;
            }
        }
        return chunks;
    }
}