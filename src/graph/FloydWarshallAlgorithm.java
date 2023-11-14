package graph;


import java.util.Arrays;

/*
    Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j.
    If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
    Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.
    If there is no possible path from vertex i to vertex j , B[i][j] = -1

    Note: Rows are numbered from top to bottom and columns are numbered from left to right.

    Example :-
    Input -
            A = [ [0 , 50 , 39]
                  [-1 , 0 , 1]
                  [-1 , 10 , 0] ]

    Output -
            [ [0 , 49 , 39 ]
               [-1 , 0 , -1 ]
               [-1 , 10 , 0 ] ]

    Explanation -
    Shortest Path from 1 to 2 would be 1 ---> 3 ---> 2 and not directly from 1 to 2,
    All remaining distances remains same.
 */

/*
    Info :-
    The Floyd Warshall Algorithm is an all pair shortest path algorithm unlike Dijkstra and Bellman Ford
    which are single source shortest path algorithms. This algorithm works for both the directed and undirected
    weighted graphs. But, it does not work for the graphs with negative cycles (where the sum of the edges in a
    cycle is negative). It follows Dynamic Programming approach to check every possible path going via every
    possible node in order to calculate shortest distance between every pair of nodes.
 */
public class FloydWarshallAlgorithm {
    public static int[][] floydWarshall(int[][] A) {
        int N = A.length;

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][k] != -1 && A[k][j] != -1) {
                        if (A[i][j] == -1 || A[i][k] + A[k][j] < A[i][j]) {
                            A[i][j] = A[i][k] + A[k][j];
                        }
                    }
                }
            }
        }

        return A;
    }
    public static void main(String[] args) {
        int[][] A = {{0, 50, 39}, {-1, 0, 1}, {-1, 10, 0}};
        int[][] ans = floydWarshall(A);

        System.out.println(Arrays.deepToString(ans));
    }
}
