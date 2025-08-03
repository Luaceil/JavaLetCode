package vector;

import static java.lang.Math.min;

public class minarr209 {
    public  static int minarr(int target ,int[] nums)
    {
        int sum=0;
        int left=0;
        int result=Integer.MAX_VALUE;
        for(int right=0;right< nums.length;right++)
        {
            sum+=nums[right];
            while(sum>=target)
            {
                result=min(result,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
