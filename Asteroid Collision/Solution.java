class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!s.isEmpty() && s.peek() > 0 && a < 0) {
                if (Math.abs(s.peek()) < Math.abs(a)) {
                    s.pop(); 
                    continue;
                } else if (Math.abs(s.peek()) == Math.abs(a)) {
                    s.pop(); 
                }
                destroyed = true;
                break;
            }

            if (!destroyed) {
                s.push(a);
            }
        }

        int[] result = new int[s.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = s.pop();
        }
        return result;
    }
}
