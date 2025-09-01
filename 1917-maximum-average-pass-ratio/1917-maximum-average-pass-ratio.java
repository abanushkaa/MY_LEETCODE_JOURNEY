import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max heap based on gain
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])  // sort by gain descending
        );

        // Initialize heap
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = calcGain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        // Assign extra students
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            pass++;
            total++;
            double gain = calcGain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        // Compute final average
        double sum = 0.0;
        for (double[] entry : pq) {
            sum += entry[1] / entry[2];
        }

        return sum / classes.length;
    }

    // Helper to calculate gain of adding 1 student
    private double calcGain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double) pass / total;
    }
}
