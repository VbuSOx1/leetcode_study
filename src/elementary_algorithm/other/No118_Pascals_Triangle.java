package elementary_algorithm.other;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author weib
 * @date 2021-05-11 14:39ya
 * 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
public class No118_Pascals_Triangle {

    public List<List<Integer>> generate(int numRows) {
        if(numRows == 1){
            List<List<Integer>> llr = new ArrayList();
            llr.add(Arrays.asList(1));
            return llr;
        }
        if(numRows == 2){
            List<List<Integer>> llr = generate(1);
            llr.add(Arrays.asList(1, 1));
            return llr;
        }
        else{
            List<List<Integer>> llr = generate(numRows - 1);
            List<Integer> lr = new ArrayList<>();
            lr.add(1);
            for(int i = 1; i < numRows - 1; i++){
                List<Integer> lastRow = llr.get(llr.size() - 1);
                lr.add(lastRow.get(i - 1) + lastRow.get(i));
            }
            lr.add(1);
            llr.add(lr);
            return llr;
        }
    }

    public List<Integer> t1(){
        List b = new ArrayList();
        b.add(123);
        b.add("就是说啊");
        b.add(Arrays.asList("woaini","789"));
        System.out.println(b);
        return new ArrayList(Arrays.asList("123","就是说啊","3456"));
    }

    public void t2(){
        List<Integer> iis = t1();
        iis.add(1);
        System.out.println(iis);
    }

    @Test
    public void test(){
        t2();
    }


}


















