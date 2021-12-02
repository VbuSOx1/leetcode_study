package Array_and_String;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weib
 * @date 2021-12-01 17:11
 * 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * 先排序
 */
public class No56_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        int row = intervals.length;
        if (row <= 1){
            return intervals;
        }
        quicksort(intervals, 0, row - 1);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int[] lastIntervals = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] r = intervals[i];
            if (lastIntervals[1] >= r[0] && lastIntervals[1] < r[1]){
                lastIntervals[1] = r[1];
            }
            if (lastIntervals[1] < r[0]){
                result.add(r);
                lastIntervals = r;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }


    public void quicksort(int[][] intervals, int start, int end) {
        if (start < end){
            int mid = position(intervals, start, end);
            quicksort(intervals, start, mid - 1);
            quicksort(intervals, mid + 1, end);
        }

    }

    public int position(int[][] intervals, int start, int end){
        // 以最后一个元素为基准
        int pivot = intervals[end][0];
        int p = start;
        for (int i = start; i < end; i++) {
            int v = intervals[i][0];
            if (v <= pivot){
                swap(intervals, i, p++);
            }
        }
        swap(intervals, p, end);
        return p;
    }

    public void swap (int[][] intervals, int p, int q) {
        int temp[] = intervals[p];
        intervals[p] = intervals[q];
        intervals[q] = temp;

    }


    @Test
    public void test(){
        int[][] test = {{1,4}, {0,0}};
        merge(test);
    }

}






