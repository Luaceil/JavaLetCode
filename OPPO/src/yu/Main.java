package yu;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = in.nextInt();
            }
            int[] brr = new int[N];
            for (int i = 0; i < N; i++) {
                brr[i] = in.nextInt();
            }
            boolean fl=true;
            for (int i = 0; i < N; i++) {
                Set<Integer> allset = new HashSet<>();
                //记录需要满足的set
                for (int j = 0; j < 31; j++) {
                    if (((brr[i] >> j) & 1) == 1) {
                        allset.add(j);
                    }
                }
                Set<Integer> set = new HashSet<>(allset);
                for (int j = 0; j < N; j++) {
                    boolean[] ll = new boolean[31];
                    boolean flag = true;
                    for (int k = 0; k < 31; k++) {
                        if (((arr[j] >> k) & 1) == 1) {
                            if (!allset.contains(j)) { //超界 舍弃
                                flag =false;
                                break;
                            }
                            ll[k]=true;
                        }
                    }
                    if(!flag) continue;
                    for(int k=0;k<31;k++){
                        if(ll[k]){
                            if (set.contains(k)) set.remove(k);
                        }
                    }
                }

                if(!set.isEmpty()){fl=false;break;}
            }
            if(fl){System.out.println("Yes");}else System.out.println("No");
        }

    }
}
