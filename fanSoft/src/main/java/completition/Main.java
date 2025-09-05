package completition;

import java.util.Arrays;

public class Main {
    public static int result=0;
    public static boolean hasOrdered=false;
    public int Solve (int N, int K, int[] R) {
        //贪心? 动态规划? 匹配问题 贪心!分差==K优先匹配
        //区间缩进法 //分差匹配问题
        if (N == 0) return result;
        if ( !hasOrdered ) {
            Arrays.sort(R);
        }
        hasOrdered = true;
        int n = R.length;
        int[] NextR = new int[n / 2];
        boolean[] isvisited = new boolean[n];
        for (int i = K; i > 0; i--) {
            for (int l = n - 1; l >= n / 2; l--) {
                for (int j = 0; j < n / 2; j++) {
                    if (!isvisited[l] && !isvisited[j] && R[l] - R[j] == i) {
                        result++;
                        isvisited[l] = true;
                        isvisited[j] = true;
                    }
                }
            }
        }
        for (int l = n - 1; l >= n / 2; l--) {
            NextR[l - n / 2] = R[l];
        }
        return Solve(N - 1, K, NextR);
    }
}
