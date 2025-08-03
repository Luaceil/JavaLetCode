package Hash;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class intersection {
    public int[] intersection(int[] nums1 ,int[] nums2)
    {
        Set<Integer> result1=new HashSet<Integer>();
        Set<Integer> result=new HashSet<Integer>();
        for(int i:nums1)
        result1.add(i);
        for(int i:nums2) {
            if (result1.contains(i)) {
                result.add(i);
            }
        }
        int[] res=new int[result.size()];
        int j=0;
        for(int i:result)
        {
            res[j]=i;
            j++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
        /**
         * 将 Set<Integer> 转换为 int[] 数组：
         * 1. stream() : Collection 接口的方法，将集合转换为 Stream<Integer>
         * 2. mapToInt(Integer::intValue) :
         *    - 中间操作，将 Stream<Integer> 转换为 IntStream
         *    - 使用方法引用 Integer::intValue，将 Integer 对象拆箱为 int 基本类型
         * 3. toArray() : 终端操作，将 IntStream 转换为 int[] 数组。
         */
    }
}
