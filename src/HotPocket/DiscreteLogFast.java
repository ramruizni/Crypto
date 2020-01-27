package HotPocket;

class DiscreteLogFast {

    static int discreteLogarithmFast(int a, int b, int m) {
        int n = (int) (Math.sqrt(m) + 1);

        // Calculate a ^ n
        int an = 1;
        for (int i = 0; i < n; ++i)
            an = (an * a) % m;

        int[] value = new int[m];

        // Store all values of a^(n*i) of LHS
        for (int i = 1, cur = an; i <= n; ++i) {
            if (value[cur] == 0)
                value[cur] = i;
            cur = (cur * an) % m;
        }

        for (int i = 0, cur = b; i <= n; ++i) {
            // Calculate (a ^ j) * b and check
            // for collision
            if (value[cur] > 0) {
                int ans = value[cur] * n - i;
                if (ans < m)
                    return ans;
            }
            cur = (cur * a) % m;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(discreteLogarithmFast(2, 3, 5));
        System.out.println(discreteLogarithmFast(3, 7, 11));
    }
}