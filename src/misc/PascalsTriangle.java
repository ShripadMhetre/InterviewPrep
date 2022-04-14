package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>(Arrays.asList(1));
            for (int j = 1; j < i; j++) {
                List<Integer> prev = result.get(i-1);
                curr.add(prev.get(j-1) + prev.get(j));
            }
            if (i > 0) curr.add(1);
            result.add(curr);
        }
        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res = generate(numRows);

        for (List<Integer> row: res) {
            for (int ele: row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
