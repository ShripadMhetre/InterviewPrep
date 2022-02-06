package algorithms.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class KSubstringVowels {
    public static int[] kSubstringVowels (String s, int k) {
        if (s.length() < k) return new int[0];

        // set to check whether character is vowel or not
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int count = 0;
        int[] ans = new int[s.length()-k+1];

        // calculate no. of vowels for first window of size k
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) count++;
        }

        ans[0] = count; // store the count for first substring

        // sliding the window for remaining characters
        for (int i = k; i < s.length(); i++) {
            // if current character also vowel then increment count.
            if (vowels.contains(s.charAt(i))) count++;

            // if the first character of previous window was vowel then
            // decrement the count as current window won't be having that character
            if (vowels.contains(s.charAt(i-k))) count--;

            // store the count
            ans[i-k+1] = count;
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "substring";
        int k = 2;

        int[] arr = kSubstringVowels(str, k);

        System.out.println("No. of vowels in each substring of size k are: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
