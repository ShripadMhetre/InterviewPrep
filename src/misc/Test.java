package misc;

public class Test {
    public static String solution(String str, int keyIndex) {
        String ans = "";    // result string

        // loop over input string
        for (int i = 0; i < str.length(); i++) {
            int currDigit = str.charAt(i) - '0';
            if ( currDigit % 2 != 0) {  // if current digit is odd then we have to replace
                int replIndex = i + keyIndex;   // get index of character to replace with in clockwise way
                if (replIndex > str.length()-1) {
                    replIndex = replIndex % (str.length()-1);
                }
                // creating ans string
                ans = ans.substring(0, i) + str.charAt(replIndex) + ans.substring(i+1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
