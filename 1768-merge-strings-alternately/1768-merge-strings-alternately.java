class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int i = 0, j = 0;

        // Add characters alternately
        while (i < word1.length() || i < word2.length()) {
            if(i<word1.length()){
            result.append(word1.charAt(i));
            }
            if(i<word2.length()){
            result.append(word2.charAt(i));
            }
            i++;
        
       
        }
        return result.toString();

  /*      // Append remaining characters of word1
        while (i < word1.length()) {
            result.append(word1.charAt(i));
            i++;
        }

        // Append remaining characters of word2
        while (j < word2.length()) {
            result.append(word2.charAt(j));
            j++;
        }

        return result.toString();*/
    }
}