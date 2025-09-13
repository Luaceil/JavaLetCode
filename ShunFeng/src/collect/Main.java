package collect;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //map+前缀和
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] arr = new int[N+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        //map.merge(arr[0],0,(o1,o2)->{return o2;});
        map.put(arr[0],0);
        for(int i=1;i<N+1;i++){
            arr[i]=sc.nextInt()+arr[i-1];
            //map.merge(arr[i],i,(o1,o2)->{return o2;});
            map.put(arr[i],i);
        }
        map.forEach((o1,o2)->{
            System.out.println(o1+" : "+o2);
        });

        while(Q!=0){
            int q =sc.nextInt();
            String flag = "No";
            for(int i=0;i<N;i++){
                if(map.containsKey(arr[i]+q)){
                    flag ="Yes";
                    break;
                }
            }
            if(Q!=1){
            System.out.print(flag+" ");}
            else{
                System.out.print(flag);
            }
            Q--;
        }
        sc.close();
    }
}
