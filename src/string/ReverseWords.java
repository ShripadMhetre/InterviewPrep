package string;

/*
    Q. You are given an array of characters arr that consists of sequences of characters separated by
    space characters. Each space-delimited sequence of characters defines a word. Implement a function
    reverseWords that reverses the order of the words in the array in the most efficient manner.

    input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
                'm', 'a', 'k', 'e', 's', '  ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

    output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
              'm', 'a', 'k', 'e', 's', '  ',
              'p', 'e', 'r', 'f', 'e', 'c', 't' ]
 */
public class ReverseWords {
    // T.C. - O(N) & S.C. - O(1)
    public static char[] reverseWords(char[] arr) {
        if (arr.length <= 1) return arr;

        int n = arr.length;
        // reverse complete string
        reverse(arr, 0, n-1);

        int startIdx = -1;
        // now start reversing indivisual word characters
        for (int i = 0; i < n; i++) {
            if (arr[i] == ' ') {
                if (startIdx >= 0) {
                    reverse(arr, startIdx, i - 1);
                    startIdx = -1;
                }
            } else if (i == n-1) {
                if (startIdx >= 0) reverse(arr, startIdx, i);
            } else if (startIdx < 0) {
                startIdx = i;
            }
        }

        return arr;
    }

    // utility method to reverse the substring given
    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] arr = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};

//        char[] arr = {'b', ' ', ' ', 'a'};

        System.out.println("Original: " + "|" +String.valueOf(arr) + "|");

        char[] ans = reverseWords(arr);

        System.out.println("Reversed: " + "|" + String.valueOf(ans) + "|");
    }
}
