package resource_game;

import java.util.ArrayList;

/*
某游戏有个玩法会每小时产出相应的资源(>=0),玩家可以通过累积该资源换取一定的奖励。
给定一个一维整数数组res,其中res[i]表示从开始到i小时中累积的资源总量。
问题1:
给定领取奖励所需要的资源总量target,请计算可以领取该奖励的最早时间,如果无法领奖返回-1。
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param res int整型ArrayList
     * @param target int整型
     * @return int整型
     */
    //log2(n) --二分查找
    public int prize (ArrayList<Integer> res, int target) {
        int right = res.size()-1;
        int left = 0;
        int result=-1;
        while(left<=right){
            int mid = left+(right-left)/2; //避免超int
            if((mid==(res.size()-1))){
                if(res.get(mid)>=target)
                return mid+1;
                else
                    return -1;
            }
            if(res.get(mid)<target&&res.get(mid+1)>=target){
                return mid+2;
            }
            if(res.get(mid)>target){
                right = mid-1;
                continue;
            }
            if(res.get(mid+1)<target){
                left =mid+1;
            }
        }

        return result+1;
    }
}
