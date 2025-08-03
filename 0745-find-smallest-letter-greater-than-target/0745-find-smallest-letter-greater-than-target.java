class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n =letters.length;
        if(target >= letters[n-1])
            return letters[0];
            int start=0,end=letters.length-1;
            int ans=-1;
            while(start<=end){
                int mid= start+(end-start)/2;
                if(letters[mid] > target){
                    
                    end=mid-1;
                    ans=mid;
                }else {
                    start=mid+1;
                }
                
            }
            return letters[ans];
    }
}