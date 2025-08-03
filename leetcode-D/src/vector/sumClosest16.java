package vector;


import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;
import static java.lang.Math.min;


/// 给定一个数组，要求在这个数组中找出 3 个数之和离 target 最近。
/// Given array nums = [-1, 2, 1, -4], and target = 1.
/// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
public class sumClosest16 {
    public static void main(String[] args) {
        int target = 1;
        int[] nums = new int[]{10,20,30,40,50,60};
       int[] result = sumCloset(nums,target);
        Arrays.stream(result).forEach(System.out::println);
      ///  ArrayList<Integer> numsArray = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    public static int[] sumCloset(int[] nums,int target) {
        Arrays.sort(nums);
        int loss = Integer.MAX_VALUE;
        int[] result =new int[3] ;
        for(int i=0;i< nums.length;i++){
            int j=i+1,k= nums.length-1;
            while(j<k){
                int lossNew =nums[j]+nums[k]+nums[i]-target;
                if(Math.abs(lossNew)<loss) {
                    result =new int[]{nums[i],nums[j],nums[k]};
                    loss =abs(lossNew);
                }
                if(lossNew>0) k--;
                else j++;
            }
        }
        return result;
    }
}
