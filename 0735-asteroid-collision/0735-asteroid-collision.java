class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int asteroid : asteroids) {

            boolean alive = true;

            while (alive && top >= 0 && stack[top] > 0 && asteroid < 0) {

                if (stack[top] < -asteroid) {
                    // Top asteroid explodes
                    top--;
                }
                else if (stack[top] == -asteroid) {
                    // Both explode
                    top--;
                    alive = false;
                }
                else {
                    // Current asteroid explodes
                    alive = false;
                }
            }

            if (alive) {
                stack[++top] = asteroid;
            }
        }

        int[] result = new int[top + 1];

        for (int i = 0; i <= top; i++) {
            result[i] = stack[i];
        }

        return result;
    }
}