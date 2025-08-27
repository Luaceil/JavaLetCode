package squareWithFixedStick;

import java.util.*;
///断给定的木棒是否能组合成一个正方形
/*
 3
 4 1 1 1 1
 5 10 20 30 40 50
 8 1 7 2 6 4 4 3 5
 */
public class Main {
    static int arrived=0;
    static int obj;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arrs = new ArrayList<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int m = sc.nextInt();
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                line.add(sc.nextInt());
            }
            arrs.add(line);
        }
        for (int i = 0; i < N; i++) {
            arrs.get(i).sort((a1, a2) -> {
                return a2 - a1;
            });
            arrs.get(i).forEach(a->System.out.print(a+" "));
            int sum = 0;
            for (int j = 0; j < arrs.get(i).size(); j++) {
                sum += arrs.get(i).get(j);
            }
            if (sum % 4 != 0) {
                System.out.println("no");
                continue;
            }
            obj = sum / 4;
            boolean[] visited = new boolean[arrs.get(i).size()];
            if(dfs(arrs.get(i), obj, 0,visited,0)){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }

        }
    }
    static boolean dfs (ArrayList<Integer> list,int target, int find, boolean[] visited,int num){
        if(num==4){
            return true;
        }
        if(target==0){
            System.out.println("target"+num);
           return dfs(list,obj,0,visited,num+1);
        }
        if(find==list.size()||target<0){
            return false;
        }
        for(int i=find;i<list.size();i++){
            if(visited[i]) continue;
            visited[i]=true;
            if( dfs(list,target-list.get(i),i+1,visited,num)){
                return true;
            }
            visited[i]=false;
        }
        return false;


    }
}