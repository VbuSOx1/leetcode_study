package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weib
 * @date 2021-05-17 15:44
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 * 杨辉三角二
 */
public class No119_Pascals_Triangle_II {

    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            return Arrays.asList(1);
        }
        if(rowIndex == 1){
            return Arrays.asList(1, 1);
        }
        List<Integer> lastRow = getRow(rowIndex - 1);
        List<Integer> lr = new ArrayList<>();
        lr.add(1);
        for(int i = 1; i < rowIndex; i++){
            lr.add(lastRow.get(i - 1) + lastRow.get(i));
        }
        lr.add(1);
        return lr;

    }

}
