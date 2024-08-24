package algorithms;
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

        // KMP logic once we have LPS array of pattern
        int i = 0, j = 0;   // i for string and j for pattern
        while (i < l1) {
            // if characters match then increment both pointers
            if (str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                // if we already at 0th index of pat i.e. no partial match
                // then simply start from next character of string
                if (j == 0) {
                    i++;
                } else {  // partial match hence we won't compare from the start of pattern
                    j =  lps[j-1];
                }
            }

            // returning as soon as we find first occurrence of pattern
            if (j == pat.length()) {
                System.out.println("Index of occurrence: " + (i - pat.length()));
                j = 0;  // resetting the pattern index to match next occurrences in string
            }
        }
    }

    public static void computeLPS(String pat, int[] lps) {
        // i -> current character index
        int prevLPS = 0, i = 1;

        while (i < lps.length) {
            // if characters match then incrementing upon previous lps value
            if (pat.charAt(i) ==  pat.charAt(prevLPS)) {
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            } else {
                if (prevLPS == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prevLPS = lps[prevLPS-1];
                }
            }
        }

        // Using index for previous (i.e. prevInd) instead of prevLPS
//        int prevInd = 0, i = 1;
//        while (i < pat.length()) {
//            if (pat.charAt(i) == pat.charAt(lps[prevInd])) {
//                lps[i] = lps[prevInd] + 1;
//                prevInd = i;
//                i++;
//            } else {
//                if (lps[prevInd] == 0) {
//                    lps[i] = 0;
//                    i++;
//                } else {
//                    prevInd = lps[lps[prevInd]-1];
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        String str = "oonionssionspl";
        String pat = "onions";

//        String str = "aaaxaaaa";
//        String pat = "aaaa";

        KMP(str, pat);
    }
}
