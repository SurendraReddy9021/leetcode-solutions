
import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();

        String prefix = "";

        for (char ch : searchWord.toCharArray()) {

            prefix += ch;

            List<String> suggestions = new ArrayList<>();

            int index = Arrays.binarySearch(products, prefix);

            if (index < 0) {
                index = -index - 1;
            }

            for (int i = index; i < products.length && suggestions.size() < 3; i++) {

                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                } else {
                    break;
                }
            }

            result.add(suggestions);
        }

        return result;
    }
}
