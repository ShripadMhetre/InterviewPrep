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
        // if no. of students more than no. of books then impossible to allocate
        if (k > arr.length) return -1;

        // setting answer boundary
        int left = Arrays.stream(arr).max().getAsInt(); // minPages can atleast be a book with max pages
        int right = Arrays.stream(arr).reduce(0, (a, b) -> a + b); // single student can read all pages if k = 1

        // binary search algorith to discard half the answer space for logarithmic T.C.
        while (left <= right) {
            int mid = left + (right-left)/2;

            // if required students more than K for current chosen page count (i.e. mid)
            // then move to right (i.e. allocate more pages)
            if (studentsRequired(arr, k, mid) > k) {
                left = mid + 1;
            } else { // if required student == k or less than k then move left
                right = mid - 1;
            }
        }

        // left boundary will be the answer.
        return left;
    }

    private static int studentsRequired(int[] arr, int k, int allowedPages) {
        int countStudents = 1;
        int currPages = 0;

        for (int i = 0; i < arr.length; i++) {
            if (currPages + arr[i] <= allowedPages) {
                currPages += currPages + arr[i];
            } else {
                currPages = arr[i];
                countStudents++;
            }
        }

        return countStudents;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 15, 5};
        int k = 2;

        System.out.println(minPages(arr, k));

    }
}
