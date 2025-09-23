package doubleInt;


import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param A int整型ArrayList
     * @param n int整型
     * @param sum int整型
     * @return long长整型
     */
    public long countPairs (ArrayList<Integer> A, int n, int sum) {
        long result = 0l;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set =new HashSet<>();
        A.stream().forEach(i->{
            map.merge(i,1,Integer::sum);
            set.add(i);
        });
        for(int i:set){
            if(i*2==sum){
                result+= map.get(i)*(map.get(i)-1)/2;
            }else if(i*2<sum){
            result+=(long)map.getOrDefault(i,0)*map.getOrDefault(sum-i,0);
            }
        }

        return result;
    }
    public long countPair (ArrayList<Integer> A, int n, int sum) {
        long result = 0l;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:A){
            result+= map.getOrDefault(sum-i,0);
            map.merge(i,1,Integer::sum);
        }

        return result;
    }
}
