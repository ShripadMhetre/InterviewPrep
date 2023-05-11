package searching;

import java.util.Arrays;

/*
    Q. Minimise the maximum number of pages read by student
        constraint - only contiguous books can be allocated to the same student

        e.g. arr = [10, 20, 5, 15, 5], k = 2
            ans: 30
            Explaination: student1 reads 10, 20 & student2 reads 5, 15, 5
                        So, 10+20 = 30 & 5+15+5= 25
                        Maximum out of 30 and 25 is 30 which is the minimum value out of any other combination possible.
 */
public class AllocateMinimumPages {

    private static int minPages(int[] arr, int k) {
        int min = Arrays.stream(arr).max().getAsInt();
        int max = Arrays.stream(arr).reduce(0, (a, b) -> a + b);

        return 0;
    }

    private static boolean isFeasible(int[] arr, int k, int res) {
        return false;
    }

    public static void main(String[] args) {
        return;
    }
}
