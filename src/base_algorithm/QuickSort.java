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


    /**
     * 更容易理解的版本`
     * 别人的代码 -- 以边为基准点的代码
     * 代码更简单
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] array, int low, int high) {
        // 取最后一个元素作为中心元素
        int pivot = array[high];
        // 定义指向比中心元素大的指针，首先指向第一个元素
        int pointer = low;
        // 遍历数组中的所有元素，将比中心元素大的放在右边，比中心元素小的放在左边
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                // 将比中心元素小的元素和指针指向的元素交换位置
                // 如果第一个元素比中心元素小，这里就是自己和自己交换位置，指针和索引都向下一位移动
                // 如果元素比中心元素大，索引向下移动，指针指向这个较大的元素，直到找到比中心元素小的元素，并交换位置，指针向下移动
                swap(array, i, pointer++);

            }
            System.out.println(Arrays.toString(array));
        }
        // 将中心元素和指针指向的元素交换位置
        swap(array, pointer, high);
        return pointer;
    }

    public static void quickSort2(int[] array, int low, int high) {
        if (low < high) {
            // 获取划分子数组的位置
            int position = partition(array, low, high);
            // 左子数组递归调用
            quickSort2(array, low, position -1);
            // 右子数组递归调用
            quickSort2(array, position + 1, high);
        }
    }

    public static void main(String[] args) {
        //{1, 2, 3, 4, 5, 9, 10, 12, 5, 2};
        int[] nums = {20, 11, 6, 4, 5, 9, 10, 12, 5, 2};
        quickSort2(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
