package subSequence;

public class Main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串 提供的字符串
     * @return int整型
     */
    public int longestPalindromeSubseq (String s) {
        int N =s.length();
        int[][] dp =new int[N][N];
        int result =0;
        for(int i=N;i>=0;i--){
            for(int j=i;j<N;j++){
                if(i==j){
                    dp[i][j]=1;
                } else {
                    if(s.charAt(i)==s.charAt(j)&&i+1<N&&j-1>=0){
                        dp[i][j]=dp[i+1][j-1];
                    }
                    dp[i][j]=Math.max(dp[i][j],Math.max(dp[i+1][j],dp[i][j-1]));
                }
                result = Math.max(dp[i][j],result);
            }
        }
        return result;
    }
}