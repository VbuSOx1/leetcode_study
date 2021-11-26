package base_algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author weib
 * @date 2020-12-13 16:23
 * 快排
 */
public class QuickSort {

    public static void quickSort(int[] nums, int startIndex, int endIndex){
        if(nums == null || startIndex >= endIndex){
            return;
        }
        int mid = position(nums, startIndex, endIndex);
        quickSort(nums, startIndex, mid -1);
        quickSort(nums, mid + 1, endIndex);
    }
    /**
     * 选取中间元素为基点
     * @param nums
     * @return
     */
    private static int position(int[] nums, int startIndex, int endIndex){
        int mid = (startIndex + endIndex) / 2;
        int base = nums[mid];
        swap(nums, mid, startIndex);
        int lowerPoint = startIndex ;
        int greaterPoint = endIndex + 1;
        while(lowerPoint < greaterPoint){
            // 注意这两个地方   nums[lowerPoint] <= base  这个地方 取 < 或者 <= 都可以
            while(++lowerPoint < endIndex && nums[lowerPoint] <= base){};
            while(--greaterPoint > startIndex && nums[greaterPoint] >= base){};
            if(lowerPoint < greaterPoint){
                swap(nums, lowerPoint, greaterPoint);
            }
        }
        // 最后一定是与greater 交换  lower之前 都比 基值小， 包括 greater
        swap(nums, startIndex, greaterPoint);
        return greaterPoint;
    }

    public static void main(String[] args) {
        //{1, 2, 3, 4, 5, 9, 10, 12, 5, 2};
        int[] nums = {1, 11, 6, 4, 5, 9, 10, 12, 5, 2};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }


    /**
        不是正规的 快排 ， 每一次 排序没有放在中间点上
     * @param arrs
     * @param left
     * @param right
     */
    private static void quickSortMid(int[] arrs, int left, int right) {
        //首先判断角标是否越界
        if(left<right){
            //用变量将中间值记录下来，不记录下来会使中间值在下面代码执行过程中发生改变，因为数组在下面发生了重排，这时再取值就不准了
            int cen = arrs[(left+right)/2];
            int i = left-1;
            int j = right+1;
            while(true){
                while(arrs[++i] < cen);
                while(arrs[--j] > cen);
                if(i>=j){
                    break;
                }
                swap(arrs, i, j);
            }
            quickSortMid(arrs,left,i-1);
            quickSortMid(arrs,j+1,right);
        }
    }
    private static void swap(int[] arrs, int i, int j) {
        int temp= 0;
        temp = arrs[i];
        arrs[i]= arrs[j];
        arrs[j]=temp;
    }
}
