package base_algorithm;

import base_algorithm.QuickSort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author weib
 * @date 2021-04-04 22:38
 */
public class BinarySearch {


    @org.junit.Test
    public void test(){

        int[] arr = {10, 3, 4, 8, 6, 10, 1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }



    public void quickSort(int[] arr, int s, int e) {
        if (s < e) {
            int p = pos(arr, s , e);
            quickSort(arr, s, p-1);
            quickSort(arr, p+1, e);
        }
    }

    public int pos(int[] arr, int s, int e) {
        int p = s;
        int pivot = arr[e];
        for (int i = s; i < e; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, p++);
            }
        }
        swap(arr, e, p);
        return p;
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
