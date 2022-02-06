package algorithms.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {
    // Time Complexity :- O(2*N) ~= O(N)
    public static int solution(String s) {
        // invalid input check
        if (s == null || s.length() == 0) return 0;

        int i = 0, j = 0, max = 0;
        // set keeps the unique character for current window
        Set<Character> set = new HashSet<>();

        // i pointer is always ahead of j or at max can be equal.
        while (i < s.length()) {
            char ch = s.charAt(i);
            // If set contains current character (i.e. ch) then restarting the window
            // So remove characters from previous window using j pointer
            while (set.contains(ch)) {
                set.remove(s.charAt(j));
                ++j;
            }

            // above while loop removes current character as well hence adding it again to restart the window
            set.add(ch);

            // updating the max if current window greater than previous max
            max = Math.max(max, i - j + 1);

            ++i;
        }



        return max;
    }
    public static void main(String[] args) {
        String str = "PWWKEW";
        System.out.println(solution(str));
    }
}
