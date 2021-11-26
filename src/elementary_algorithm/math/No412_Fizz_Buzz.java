package elementary_algorithm.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weib
 * @date 2021-04-25 21:07
 * https://leetcode-cn.com/problems/fizz-buzz/
 * 412. Fizz Buzz
 */
public class No412_Fizz_Buzz {
    String d35 = "FizzBuzz";
    String d3 = "Fizz";
    String d5 = "Buzz";

    public List<String> fizzBuzz(int n) {
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1 + "";
            if( (i + 1) % 3 == 0 ){
                arr[i] = d3;
            }
            if( (i + 1) % 5 == 0 ){
                arr[i] = d5;
            }
            if( (i + 1) % 15 == 0 ){
                arr[i] = d35;
            }

        }
        return Arrays.asList(arr);
    }

    public List<String> fizzBuzz2(int n) {
        List<String> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if( (i + 1) % 15 == 0 ){
                arr.add(d35);
                continue;
            }
            if( (i + 1) % 3 == 0 ){
                arr.add(d3);
                continue;
            }
            if( (i + 1) % 5 == 0 ){
                arr.add(d5);
                continue;
            }
            arr.add(i + 1 +"");
        }
        return arr;
    }
}
