package interviews;

import java.util.*;

/*
    Q. You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

    There are two types of logs:

    Letter-logs: All words (except the identifier) consist of lowercase English letters.
    Digit-logs: All words (except the identifier) consist of digits

    Reorder these logs so that:
        1. The letter-logs come before all digit-logs.
        2. The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
        3. The digit-logs maintain their relative ordering.

    Return the final order of the logs.

    Example 1:
    Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
    Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
    Explanation:
    The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
    The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".

    Example 2:
    Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
    Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 */
public class ReorderDataInLogFiles {
    // Without extra lists
    public static String[] reorder(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            int index1 = log1.indexOf(' ');
            String id1 = log1.substring(0, index1);
            String main1 = log1.substring(index1+1);

            int index2 = log2.indexOf(' ');
            String id2 = log2.substring(0, index2);
            String main2 = log2.substring(index2+1);

            boolean isDigit1 = Character.isDigit(main1.charAt(0));
            boolean isDigit2 = Character.isDigit(main2.charAt(0));

            if (!isDigit1 && !isDigit2) {
                return main1.compareTo(main2) == 0 ? id1.compareTo(id2) : main1.compareTo(main2);
            }

            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });

        return logs;
    }

    // With extra space for digitLogs and letterLogs lists
    public static String[] reorderLogFiles(String[] logs) {
        List<String> ans = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        List<String[]> letterLogs = new ArrayList<>();

        for (final String log : logs) {
            final int i = log.indexOf(' ');
            if (Character.isDigit(log.charAt(i + 1)))
                digitLogs.add(log);
            else
                letterLogs.add(new String[] {log.substring(0, i), log.substring(i + 1)});
        }

        Collections.sort(letterLogs, new Comparator<String[]>() {
            @Override
            public int compare(String[] l1, String[] l2) {
                return l1[1].compareTo(l2[1]) == 0 ? l1[0].compareTo(l2[0]) : l1[1].compareTo(l2[1]);
            }
        });

        for (String[] letterLog : letterLogs)
            ans.add(letterLog[0] + " " + letterLog[1]);

        for (final String digitLog : digitLogs)
            ans.add(digitLog);

        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
//        String[] ans = reorderLogFiles(logs);
        String[] ans = reorder(logs);

        for (String str: ans) {
            System.out.println(str + " ");
        }
    }
}
