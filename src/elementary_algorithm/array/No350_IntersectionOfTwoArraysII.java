package elementary_algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author weib
 * @date 2020-12-12 22:46
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 */
public class No350_IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int size = size1 < size2 ? size1 : size2;
        HashMap<Integer, Integer> hashMap = new HashMap<>(size);
        int[] shortNums = size1 < size2 ? nums1 : nums2;
        int[] longNums = size1 < size2 ? nums2 : nums1;
        for(int i = 0; i < size; i++)
        {
            Integer v =  hashMap.getOrDefault(shortNums[i], 0);
            hashMap.put(shortNums[i], v + 1);
        }

        int[] intersection = new int[size];
        int index = 0;
        for(int i = 0; i < longNums.length; i++){
            int num = longNums[i];
            Integer v = hashMap.get(num);
            v = v == null ? 0 : v;
            if(v > 0){
                intersection[index++] = num;
            }
            v--;
            hashMap.put(num, v);
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

}
