package yu;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
1
3
1 1 2
1 2 3
 */
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
            System.out.println();
            System.out.print("arr:");
            Arrays.stream(arr).forEach(a->{System.out.print(a+" ");});
            System.out.println();
            System.out.print("brr:");
            Arrays.stream(brr).forEach(b->{System.out.print(b+" ");});
            boolean fl=true;
            System.out.println();
            for (int i = 0; i < N; i++) {
                System.out.println();
                System.out.print(i+":");
                Set<Integer> allset = new HashSet<>();
                //记录需要满足的set
                for (int j = 0; j < 31; j++) {
                    if (((brr[i] >> j) & 1) == 1) {
                        allset.add(j);
                    }
                }
                System.out.println();
                System.out.print("allset:");
                allset.forEach(b->{System.out.print(b+" ");});
                Set<Integer> set = new HashSet<>(allset);
                for (int j = 0; j <=i; j++) {
                    boolean[] ll = new boolean[31];
                    boolean flag = true;
                    for (int k = 0; k < 31; k++) {
                        if (((arr[j] >> k) & 1) == 1) {
                            if (!allset.contains(k)) { //超界 舍弃
                                flag =false;
                                break;
                            }
                            ll[k]=true;
                        }
                    }
                    if(!flag) continue;
                    System.out.print("hit:");
                    for(int k=0;k<31;k++){
                        if(ll[k]){
                                    System.out.print(k+" ");
                            if (set.contains(k)) {set.remove(k);}
                        }
                    }
                }
                System.out.print("restSet:");
                set.forEach(b->{System.out.print(b+" ");});
                if(!set.isEmpty()){fl=false;break;}
                System.out.println();
            }
            System.out.println();
            if(fl){System.out.println("Yes");}else System.out.println("No");
        }

    }
}
