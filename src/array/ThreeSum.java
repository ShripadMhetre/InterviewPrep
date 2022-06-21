package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length == 0) return res;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;

            int l = i+1, r = arr.length-1;
            while (l < r) {
                int currSum = arr[i] + arr[l] + arr[r];
                if (currSum > 0) r--;
                else if (currSum < 0) l++;
                else {
                    res.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    l++;
                    while (arr[l] == arr[l-1]) l++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {0, -2, -2, 0, 0, 2};
        List<List<Integer>> res = threeSum(arr);

        for (List<Integer> triplet: res) {
            for (Integer ele: triplet) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
