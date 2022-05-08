package hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weib
 * @date 2022-05-08 14:45
 * 406. 根据身高重建队列
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * 找规律的题 身高从大小排列，身高相同，按k从小到大排列
 */
public class No_406_queue_reconstruction_by_height {

    // 找规律
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a , b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][]);
    }
}
