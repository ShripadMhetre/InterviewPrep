package algorithms;

public class KMPAlgorithm {
    public static void KMP(String str, String pat) {
        int l1 = str.length();
        int l2 = pat.length();

        if (l1 < l2) {
            System.out.println("pat cannot be found in string as string is less than pattern length.");
            return;
        }
        if (l1 == l2) {
            System.out.println("Both strings are same: " + str.equals(pat));
            return;
        }

        int[] lps = new int[l2];
        computeLPS(pat, lps);

        int i = 0, j = 0;

        while (i < l1-l2+1) {
            if (str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else i++;
            }

            if (j == l2) {
                System.out.println("Pattern found from index " + i + " to index " + j);
                j = lps[j-1];
            }
        }
    }

    public static void computeLPS(String pat, int[] lps) {
        int N = lps.length;
        int i = 0, j = 1;

        lps[0] = 0;

        while (j < N) {
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) i = lps[i-1];
                else {
                    lps[j] = 0;
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String str = "onionssionspl";
        String pat = "onions";

        KMP(str, pat);

    }
}
