class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getHours(piles, mid) <= h) {
                right = mid; // mid might be the answer
            } else {
                left = mid + 1; // discard too-small speeds
            }
        }

        return left; // or right, since left == right here
    }

    private int getMax(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            if (pile > max) max = pile;
        }
        return max;
    }

    private int getHours(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceil(pile / k)
        }
        return hours;
    }
}
