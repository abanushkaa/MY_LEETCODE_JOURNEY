class Solution {
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int a : nums){
            int count=0;
            int temp=0;
            for(int i=1;i*i<=a;i++){
                if(a%i==0 ){
                    if(i==a/i){
                        count++;
                        temp+=i;
                    }else{
                        count+=2;
                        temp+=i;
                        temp+=a/i;
                    }
                }
            }
            if(count==4){
                sum+=temp;
            }
        }
        return sum;
    }
}