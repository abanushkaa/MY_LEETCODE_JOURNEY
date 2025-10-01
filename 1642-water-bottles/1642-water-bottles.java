class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int consumed = 0;
        
        while (numBottles >= numExchange) {
            consumed += numExchange;     // drink numExchange bottles
            numBottles -= numExchange;   // reduce them
            numBottles += 1;             // exchange empties for 1 new bottle
        }
        
        return consumed + numBottles;    // add leftover bottles
    }
}
