class Solution {
    public boolean hasSameDigits(String s) {
        // Convert string to list of digits
        while (s.length() > 2) {
            StringBuilder next = new StringBuilder();

            for (int i = 0; i < s.length() - 1; i++) {
                int a = s.charAt(i) - '0';
                int b = s.charAt(i + 1) - '0';
                int sum = (a + b) % 10;
                next.append(sum);
            }

            s = next.toString();
        }

        // Now s has exactly 2 digits
        return s.charAt(0) == s.charAt(1);
    }
}
