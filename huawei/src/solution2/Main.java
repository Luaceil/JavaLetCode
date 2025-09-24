package solution2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m =sc.nextInt();
        int[] firstLights =new int[n];
        for(int i=0;i<n;i++){
            firstLights[i] =sc.nextInt();
        }
        //存储每个开关影响的灯 x->y
        List<Integer>[] differ =new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            differ[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            differ[x].add(y);
        }
        int minSwichCount = Integer.MAX_VALUE;
        List<Integer> bestPlan = null;
        //枚举可能的开关状态
        for(int state = 0;state<(1<<n);state++){
            int[] nowLights = new int[n];
            System.arraycopy(firstLights,0,nowLights,0,n);
            List<Integer> currentScheme = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(((state>>i)&1)==1){
                    int swichDex =i +1;
                    currentScheme.add(swichDex);
                    nowLights[i]^=1;
                    for(int y: differ[swichDex]){
                        int lightIdx = y-1;
                        nowLights[lightIdx]^=1;
                    }
                }
            }
            boolean isAllOff = true;
            for(int light: nowLights){
                if(light!=0){
                    isAllOff =false;
                    break;
                }
            }
            if(isAllOff){
                int switchCount = Integer.bitCount(state);
                if(switchCount<minSwichCount||(switchCount==minSwichCount&&isLexSmaller(currentScheme, bestPlan))){
                    minSwichCount=switchCount;
                    bestPlan =new ArrayList<>(currentScheme);
                }
            }
        }
        if(bestPlan == null){
            System.out.println(-1);
        }else {
            for(int i = 0; i< bestPlan.size(); i++){
                if(i>0) System.out.print(" ");
                System.out.print(bestPlan.get(i));
            }
            System.out.println();
        }
        sc.close();
    }
    private  static  boolean isLexSmaller(List<Integer> current,List<Integer> best){
        if(best ==null){
            return true;
        }
        for(int i=0;i<current.size();i++){
            if(current.get(i)<best.get(i)){
                return true;
            }else if(current.get(i)>best.get(i)){
                return false;
            }
        }
        return false;
    }
}
