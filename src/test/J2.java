package test; /**
 * @author weib
 * @date 2022-04-16 20:40
 */

import java.util.Scanner;

public class J2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            int num = sc.nextInt();
            int[] nums = new int[num];
            for (int i = 0; i<num; i++) {
                nums[i] = sc.nextInt();
            }
            for (int i = num-1; i >=0 ;i--) {
                if (num-i == (i+1)/2) {
                    System.out.println(nums[i]);
                    break;
                }
            }
            n--;
        }



    }


}
