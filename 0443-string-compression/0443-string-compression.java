class Solution {
    public int compress(char[] chars) {
        int read = 0;
        int write = 0;

        while (read < chars.length) {
            char current = chars[read];
            int count = 0;

            // Count consecutive characters
            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = current;

            // Write the count if greater than 1
            if (count > 1) {
                String countStr = String.valueOf(count);

                for (char c : countStr.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}