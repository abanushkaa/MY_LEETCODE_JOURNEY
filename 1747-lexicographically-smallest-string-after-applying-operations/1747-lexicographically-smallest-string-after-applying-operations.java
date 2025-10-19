import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        seen.add(s);
        
        String smallest = s;
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(smallest) < 0) {
                smallest = cur;
            }

            // 1️⃣ Add operation
            char[] arr = cur.toCharArray();
            for (int i = 1; i < arr.length; i += 2) {
                int newDigit = (arr[i] - '0' + a) % 10;
                arr[i] = (char) ('0' + newDigit);
            }
            String added = new String(arr);
            if (seen.add(added)) {
                q.add(added);
            }

            // 2️⃣ Rotate operation
            String rotated = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (seen.add(rotated)) {
                q.add(rotated);
            }
        }
        return smallest;
    }
}
