package bits;

/*
    Q. Given two integers a and b, return the sum of the two integers without using the + and - operators.
    Example 1:
    Input: a = 1, b = 1
    Output: 2

    Example 2:
    Input: a = 4, b = 7
    Output: 11
 */
public class SumOfTwoIntegers {
    public static int getSum(int a, int b) {
        return add(a, b);
    }

    private static int add(int a, int b) {
        if (a == 0 || b == 0) {
            return a | b;
        }

        /*
            XOR for summation without consideration of carry
            AND for checking of carry and if present shifting it to left
            to add into the those bits in the XOR result.
            once one of the no. turns zero we have got the answer
        */
        return add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        int n1 = 9, n2 = 11;
        System.out.println(getSum(n1, n2));
    }
}
