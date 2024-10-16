package leetcode;

public class N338_Counting_Bits {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    public int[] countBits2(int n) {
        int[] ans = new int[n+1];

        int sq = 1;
        int cnt = 1;
        while (cnt <= n) {
            ans[cnt] = 1 + ans[cnt-sq];
            cnt++;
            sq = cnt >= sq*2 ? sq * 2 : sq;
        }

        return ans;
    }

    public int[] countBits3(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
