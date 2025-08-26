class Solution {
    public int trap(int[] height) {
        int n= height.length;
        Stack <Integer> s = new Stack<>();
        int water=0;
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && height[i]>height[s.peek()]){
                int bottom = s.pop();
                
                if(s.isEmpty()) break;
                int left = s.peek();
                int distance= i-left-1;
                int boundHeight = Math.min(height[i],height[left])-height[bottom];
                water += distance*boundHeight;
            }
            s.push(i);
        }
        return water;
    }
}