class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Stack to store surviving asteroids
        Stack<Integer> stack = new Stack<>();

        // Iterate through each asteroid
        for (int a : asteroids) {
            // Flag to check if current asteroid gets destroyed
            boolean destroyed = false;

            // Collision happens only if:
            // 1. Current asteroid moves left (a < 0)
            // 2. Top of the stack asteroid moves right (stack.peek() > 0)
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                if (stack.peek() < -a) {
                    // Top asteroid is smaller → it explodes
                    stack.pop();
                    // Continue checking if current asteroid will hit another
                    continue;
                } else if (stack.peek() == -a) {
                    // Both asteroids have same size → both explode
                    stack.pop();
                }
                // If we reach here, current asteroid is destroyed
                destroyed = true;
                break;
            }

            // If current asteroid survived all collisions, push it to stack
            if (!destroyed) {
                stack.push(a);
            }
        }

        // Convert stack to array for result
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
