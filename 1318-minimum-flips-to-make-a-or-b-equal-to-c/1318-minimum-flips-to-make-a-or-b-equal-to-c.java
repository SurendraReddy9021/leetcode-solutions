class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;

        while (a != 0 || b != 0 || c != 0) {
            int abit = a & 1;
            int bbit = b & 1;
            int cbit = c & 1;

            if ((abit | bbit) != cbit) {
                if (cbit == 1) {
                    // Both a and b are 0, so flip one of them
                    flips++;
                } else {
                    // c is 0, so every 1 in a or b must be flipped
                    flips += abit + bbit;
                }
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
}