package bits;

/*
    Q. Given a 32-bit unsigned integer n, reverse the bits of the binary representation of n and return the result.
    Example 1:
    Input: n = 00000000000000000000000000010101
    Output: 2818572288 (10101000000000000000000000000000)
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res += (bit << (31 - i));
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
