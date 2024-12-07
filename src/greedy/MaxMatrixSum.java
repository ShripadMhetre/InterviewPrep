package greedy;

/*
    Q. You are given an n x n integer matrix. You can do the following operation any number of times:

    Choose any two adjacent elements of matrix and multiply each of them by -1.
    Two elements are considered adjacent if and only if they share a border.

    Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements
    using the operation mentioned above.

    Example 1:
        Input: matrix = [[1,-1],[-1,1]]
        Output: 4
        Explanation: We can follow the following steps to reach sum equals 4:
        - Multiply the 2 elements in the first row by -1.
        - Multiply the 2 elements in the first column by -1.

    Example 2:
        Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
        Output: 16
        Explanation: We can follow the following step to reach sum equals 16:
        - Multiply the 2 last elements in the second row by -1.
 */
public class MaxMatrixSum {
    /*
        Greedy approach - since we can perform the operation any number of times, when there are even no. of negetives
            we can shift them to adjacent elements and make them +ve. Hence the ans is max sum possible considering all
            elements +ve
            Also, for odd no. of -ve elements (i.e. even no. + 1) - we can just subtract the min absolute element from
            max sum

         T.C. - O(N2)
     */
    public static int solution(int[][] mat) {
        int N = mat.length; // n * n matrix
        int minAbs = Integer.MAX_VALUE;
        int negetives = 0;
        int maxSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int currAbs = Math.abs(mat[i][j]);
                minAbs = Math.min(minAbs, currAbs);
                maxSum += currAbs;

                if (mat[i][j] < 0) negetives++;
            }
        }

        if (negetives % 2 == 1) {
            maxSum -= 2 * minAbs;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};
        System.out.println(solution(mat));
    }
}
