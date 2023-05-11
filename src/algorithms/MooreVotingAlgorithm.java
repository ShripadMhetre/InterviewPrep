package algorithms;


/*
    Q. Majority Elements in an Array - (i.e. element occurring more than N/2 times in the array)

    1. Brute Force -> O(N2) - counting the frequencies of all elements
    2. O(NlogN) -> sort the array and then in linear time count frequencies of elements
    3. 0(N) time and space -> using hashmap to store frequencies

    most optimal - O(N) time and constant space - below solution - Boyer Moore's Voting algorithm
 */
public class MooreVotingAlgorithm {
    private static int solution(int[] arr) {
        int n = arr.length;
        int ansIndex = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[ansIndex]) count++;
            else count--;

            if (count == 0) {
                ansIndex = i;
                count = 1;
            }
        }

        count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[ansIndex]) count++;
        }

        return count > n/2 ? arr[ansIndex] : -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 1, 2};
        int ans = solution(arr);
        System.out.println("Majority element: " + ans);
    }
}
