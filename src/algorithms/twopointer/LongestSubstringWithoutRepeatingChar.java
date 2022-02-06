package algorithms.twopointer;

/*
    Q. Given a string s, find the length of the longest substring without repeating characters.

        Example :
            1.  s: “mississippi”
                Result: 3
                Explanation: Longest valid substrings are “mis” and “sip”, both of length 3.
 */
public class LongestSubstringWithoutRepeatingChar {
    public static int longestSubstringWithoutRepeat(String s) {
        // corner case
        if (s == null || s.length() == 0) return 0;

        // array to store count of each char
        char[] chars = new char[256];

        // stores the required max length
        int res = 0;

        int left = 0, right = 0;

        // we track the end (i.e. right) character.
        // if its count > 1 then keep incrementing start (i.e. left) index
        // and decrementing the count of the previous start character
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            // keep updating max length
            res = Math.max(res, right-left+1);

            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "mississippi";
        int len = longestSubstringWithoutRepeat(str);
        System.out.println("length of longest substring without repeat character: " + len);
    }
}
