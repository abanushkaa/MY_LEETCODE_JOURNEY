class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;
        int rev=0;
        int orig=x;
        while(x>0){
            int last= x%10;
            rev=rev*10+last;
            x=x/10;
            if(rev==orig){
                return true;
            }
        }
        return false;
    }
}