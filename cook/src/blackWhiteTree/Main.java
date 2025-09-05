package blackWhiteTree;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Boolean> blackOrWhite=new ArrayList<>() ;
        for (int i = 1; i < N+1 ; i++) {
            arr.add(sc.nextInt()) ;
        }
        String blackOrWhiteStr = sc.next();
        for(int i=1;i<N+1;i++){
            if(blackOrWhiteStr.charAt(i)=='B')
            { blackOrWhite.add(false);continue;}
                blackOrWhite.add(true);
        }
        int[] node = new int[N+1];
        for (int i = 0; i < N-1; i++) {
            int k = sc.nextInt();
            int v = sc.nextInt();
            node[v] = k;
        }
        for(int i=0;i<K;i++){
            if (sc.nextInt()==1){
                int loc=sc.nextInt()-1;
                blackOrWhite.set(loc,blackOrWhite.get(loc));
            }
            else {
                int result=1;
                int loc=sc.nextInt()-1;
                while(loc!=0){
                  result =  lcm2(result,arr.get(loc))%(1000000000+7);
                }
                System.out.println(result);
                loc=node[loc];
            }
        }

    }
    static public int lcm2(int a, int b){
        int lcm1=lcm(a,b);
        return b*a/lcm1;

    }
    static public int lcm(int a, int b) {
        if (a == b) return a;
        if(a%b==0||b%a==0) return a>b? b:a;
        if (a > b) return lcm(a % b, b);
        if (a < b) return lcm(b % a, a);
        return 1;
    }

}
