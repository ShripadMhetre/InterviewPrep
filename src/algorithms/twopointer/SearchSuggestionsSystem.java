package algorithms.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Q. You are given an array of strings products and a string searchWord.
        Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord.
        If there are more than three products with a common prefix return the three lexicographically minimums products.

        Return a list of lists of the suggested products after each character of searchWord is typed.

        Example 1:
        Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
        Output: [
            ["mobile","moneypot","monitor"],
            ["mobile","moneypot","monitor"],
            ["mouse","mousepad"],
            ["mouse","mousepad"],
            ["mouse","mousepad"]
        ]
        Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
        After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
        After typing mou, mous and mouse the system suggests ["mouse","mousepad"]

        Example 2:
        Input: products = ["havana"], searchWord = "havana"
        Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]

        Example 3:
        Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
        Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 */
public class SearchSuggestionsSystem {
    // Time :- O(NlongN) for sorting + N*M for looping over searchWord and two pointer algo.
    public static List<List<String>> solve(String[] products, String searchWord) {
        // sort the array so that all string in lexicographical order.
        Arrays.sort(products);

        List<List<String>> res = new ArrayList<>();
        int l = 0, r = products.length-1;

        // looping over the character of searchWord to match with products using two pointers approach
        for (int i = 0; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);

            // If current product length less than the current index of searchWord OR the character is not matching then skip.
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != ch)) l++;
            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != ch)) r--;

            // We want at max 3 matching products but matches can be less than 3 as well
            int remainingStrings = r - l + 1;
            int min = Math.min(3, remainingStrings);

            List<String> currItems = new ArrayList<>();

            // adding the first 3 OR "min" string to result.
            for (int j = 0; j < min; j++) {
                currItems.add(products[l+j]);
            }

            res.add(currItems);
        }

        return res;
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";

        List<List<String>> res = solve(products, searchWord);

        for (List<String> curr: res) {
            for (String item: curr) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
