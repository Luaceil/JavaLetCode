public class Main {
    public static void main(String[] args) {
        int[][] ab =new int[][]{{1,2,3,4},{1,4,3,2},{}};
    }
    public int solution(int[][] ab_dau) {
        // 在这⾥写代码
        int N = ab_dau.length;
        int flag=0;
        int result =0;
        for(int i=0;i<N;i++){
            int M = ab_dau[i].length;
            int[] diff = new int[M];
            int[] predex = new int[M];
            for(int j=1;j<M;j++){
                diff[j] = ab_dau[i][j]-ab_dau[i][j-1];
                predex[j] = diff[j] +predex[j-1];
            }
            int beginDate=0;
            int maxValue = -Integer.MAX_VALUE;
            int minPre = 0;  //前j项最小值
            int preIndex = 0;
            int dateLast =0;
            for(int j=0;j<M;j++){
                int currentMax = predex[j] -minPre;
                if(maxValue<currentMax)
                {
                    beginDate=preIndex;
                    dateLast= j-preIndex+1;
                    maxValue = currentMax;

                }
                if (predex[j]<minPre){
                    minPre = predex[j];
                    preIndex = j;
                }
            }
           if(result < maxValue/dateLast){
               flag = i;
           }
        }
        return flag;
    }
}
