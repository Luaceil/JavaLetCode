package main.java;

import java.util.Arrays;

public class SearchRange {
    public int searchRange(int[] nums, int target,boolean canequal)
    {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        int mid = 0;
        while(left <= right)
        {
             mid = left + (right - left) / 2;
            if(nums[mid]>target||(canequal&&nums[mid]==target))
            {
                right = mid - 1;   //等于时还收缩 就是找第一个
                                   // 不等于时收缩 找第一个大于的
                ans = mid;
            }
            else
            {
                left = mid - 1;
            }

        }
        return canequal? ans: ans-1;
    }
}
