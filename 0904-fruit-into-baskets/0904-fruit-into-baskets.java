class Solution {
    public int totalFruit(int[] fruits) {

        int lastFruit = -1;
        int secondLastFruit = -1;

        int lastFruitCount = 0;
        int currentWindow = 0;
        int maxWindow = 0;

        for (int fruit : fruits) {

        
            if (fruit == lastFruit || fruit == secondLastFruit) {
                currentWindow++;
            } 
     
            else {
                currentWindow = lastFruitCount + 1;
            }

           
            if (fruit == lastFruit) {
                lastFruitCount++;
            } else {
                lastFruitCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            maxWindow = Math.max(maxWindow, currentWindow);
        }

        return maxWindow;
    }
}