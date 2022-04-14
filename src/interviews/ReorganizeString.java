package interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
    Q. Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
        Return any possible rearrangement of s or return "" if not possible.

        Example 1:
            Input: s = "aab"
            Output: "aba"

        Example 2:
            Input: s = "aaab"
            Output: ""
 */
public class ReorganizeString {
    public static String solution(String str) {
        if (str == null || str.length() == 0) return "";

        Map<Character, Integer> counts = new HashMap<>();

        for (char ch : str.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll((counts.keySet()));

        StringBuilder result = new StringBuilder();

        while (maxHeap.size() > 1) {
            char curr = maxHeap.poll();
            char next = maxHeap.poll();
            result.append(curr);
            result.append(next);

            counts.put(curr, counts.get(curr)-1);
            counts.put(next, counts.get(next)-1);

            if (counts.get(curr) > 0) {
                maxHeap.add(curr);
            }
            if (counts.get(next) > 0) {
                maxHeap.add(next);
            }
        }

        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();
            if (counts.get(last) > 1) return "";
            result.append(last);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "aabb";
        String res = solution(str);
        if (res.equals("")) {
            System.out.println("Not Possible...");
        } else {
            System.out.println(res);
        }
    }
}
