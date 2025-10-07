import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        
        // Map to store last day a lake was filled
        Map<Integer, Integer> fullLakes = new HashMap<>();
        // TreeSet to store available dry days
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];

            if (lake == 0) {
                // Potential day to dry any lake later
                dryDays.add(i);
                ans[i] = 1; // default (we may change it later)
            } else {
                ans[i] = -1; // raining day

                if (fullLakes.containsKey(lake)) {
                    // Lake already full — need to find a dry day
                    int lastRainDay = fullLakes.get(lake);
                    Integer dryDay = dryDays.higher(lastRainDay); // next dry day after last rain

                    if (dryDay == null) {
                        // No dry day available → flood unavoidable
                        return new int[0];
                    }

                    // Dry this lake on that dryDay
                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }

                // Mark lake as full now
                fullLakes.put(lake, i);
            }
        }

        return ans;
    }
}
