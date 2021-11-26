package elementary_algorithm.sort_and_search;

/**
 * @author weib
 * @date 2021-04-18 13:16
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 合并有序数组
 * 思路：先把nums1 往后移 n位 然后在进行归并
 *
 * 别人的思路： 直接从大到小比较
 */
public class No88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = m + n - 1;
        // nums1 后移n 位
        while(i >= 0){
            nums1[j--] = nums1[i--];
        }

        // nums1 下标
        i = n;
        // nums2 下标
        j = 0;
        // 新nums1 下标
        int k = 0;
        while(i < m + n || j < n ){
            if(nums1[i] < nums2[j]){
                nums1[k++] = nums1[i++];
            }else{
                nums1[k++] = nums2[j++];
            }
        }

        while(j < n){
            nums1[k++] = nums2[j++];
        }
    }
}
