package dp;

/*
    Q. Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
        A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

        For example, "ace" is a subsequence of "abcde".
        A common subsequence of two strings is a subsequence that is common to both strings.

        Example 1:
        Input: text1 = "abcde", text2 = "ace"
        Output: 3
        Explanation: The longest common subsequence is "ace" and its length is 3.

        Example 2:
        Input: text1 = "abc", text2 = "abc"
        Output: 3
        Explanation: The longest common subsequence is "abc" and its length is 3.

        Example 3:
        Input: text1 = "abc", text2 = "def"
        Output: 0
        Explanation: There is no such common subsequence, so the result is 0.
 */
public class LongestCommonSubsequence {
    public static int recursive(String str1, String str2, int m, int n) {
        if (m < 0 || n < 0) return 0;

        if (str1.charAt(m) == str2.charAt(n))
            return 1 + recursive(str1, str2,m-1, n-1);

        int excl1 = recursive(str1, str2, m-1, n);
        int excl2 = recursive(str1, str2, m, n-1);

        return Math.max(excl1, excl2);
    }

    public static int bottomUpDP(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        String str1 = "abcde", str2 = "ace";
//        int lcs = recursive(str1, str2, str1.length()-1, str2.length()-1);
        int lcs = bottomUpDP(str1, str2);
        System.out.println("Max LCS Length: " + lcs);
    }
}
