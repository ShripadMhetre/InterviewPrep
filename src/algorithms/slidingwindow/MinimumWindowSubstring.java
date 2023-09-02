package algorithms.slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    // TC - O(2*N + M) ~ O(N+M)
    public static String minWindow(String s, String t) {
        int sLength = s.length(), tLength = t.length();

        // Hashmap maintaining current state of t string char counts
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch: t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        // count is current count of characters from t string which are yet to be included in the answer string
        int left = 0, right = 0, count = map.size(), minLength = Integer.MAX_VALUE;
        int start = 0, end = 0; // start and end index of answer substring

        while (right < sLength) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar)-1);
                // if the frequency of right character = 0 then all the occurrences of that char captured
                if (map.get(rightChar) == 0) count--;
            }

            // if all t string characters found then we try to minimize the substring by stripping out chars from left index
            if (count == 0) {
                while (count == 0) {
                    char leftChar = s.charAt(left);
                    if (map.containsKey(leftChar)) {
                        map.put(leftChar, map.get(leftChar)+1);
                        if (map.get(leftChar) > 0) count++;
                    }

                    // setting up the answer substring
                    if (right-left+1 < minLength) {
                        minLength = right-left+1;
                        start = left;
                        end = right;
                    }

                    left++;
                }
            }

            right++;
        }

        return minLength != Integer.MAX_VALUE ? s.substring(start, end+1) : "";
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
