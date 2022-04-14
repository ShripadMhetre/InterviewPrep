package string;

/*
    Q. Reverse only the vowels of the string.
    Example 1:
        Input: "hello"
        Output: "holle"

     Example 2:
        Input: "leetcode"
        Output: "leotcede"
 */
public class ReverseVowelsOfString {
    public static String reverseVowels(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length-1;

        while (left < right) {
            boolean leftIsVowel = isVowel(arr[left]);
            boolean rightIsVowel = isVowel(arr[right]);

            if (leftIsVowel && rightIsVowel) {
                swap(arr, left, right);
                left++;
                right--;
            }
            if (!leftIsVowel) ++left;
            if (!rightIsVowel) --right;
        }
        return new String(arr);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean isVowel(char letter) {
        char c = Character.toLowerCase(letter);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(reverseVowels(str));
    }
}
