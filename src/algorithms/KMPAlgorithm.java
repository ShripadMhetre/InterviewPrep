package algorithms;

import java.util.ArrayList;

/*
    pat = "bba" string = "aabbbba"


 */
public class KMPAlgorithm {
    public static void KMP(String str, String pat) {
        int l1 = str.length();
        int l2 = pat.length();

        if (l1 < l2) {
            System.out.println("ERR: string length is less than pattern length.");
            return;
        }
        if (l1 == l2) {
            System.out.println("Both strings are same: " + str.equals(pat));
            return;
        }

        int[] lps = new int[l2];
        // create LPS array for pattern
        computeLPS(pat, lps);

        ArrayList<Integer> res = new ArrayList<>();

        // KMP logic once we have LPS array of pattern
        int i = 0, j = 0;   // i for string and j for pattern
        while (i < l1) {
            // if characters match then increment both pointers
            if (str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                // Use lps value of previous index to avoid redundant comparisons
                if (j != 0) {
                    j =  lps[j-1];
                } else {
                    // if we already at 0th index of pat i.e. no partial match
                    // then simply start from next character of string
                    i++;
                }
            }

            // If the entire pattern is matched store the start index in result
            if (j == pat.length()) {
                System.out.println("Index of occurrence: " + (i - pat.length()));
                j = lps[j - 1];;  // resetting the pattern index to match next occurrences in string
            }
        }
    }

    public static void computeLPS(String pat, int[] lps) {
        // i -> current character index
        int prevLPS = 0, i = 1;

        while (i < pat.length()) {
            // if characters match then incrementing upon previous lps value
            if (pat.charAt(i) ==  pat.charAt(prevLPS)) {
                prevLPS++;
                lps[i] = prevLPS;
                i++;
            } else {
                if (prevLPS != 0) {
                    // Update len to the previous lps value to avoid redundant comparisons
                    prevLPS = lps[prevLPS-1];
                } else {
                    // If no matching prefix found, set lps[i] to 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String str = "oonionssionspl";
        String pat = "onions";

//        String str = "aaaxaaaa";
//        String pat = "aaaa";

        KMP(str, pat);
    }
}
