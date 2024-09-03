package leetcode;

public class N476_Number_Complement {

    public int findComplement(int num) {
        int bitLength = Integer.toBinaryString(num).length();
        long base = (long) Math.pow(2, bitLength) - 1;
        return (int) (num ^ base);
    }

    // 다른 답
    public int findComplement2(int num) {
        if (num == 0) return 1;
        int bitLength = Integer.toBinaryString(num).length();
        int mask = (1 << bitLength) - 1;
        return num ^ mask;
    }
}
