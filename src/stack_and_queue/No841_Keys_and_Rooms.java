package stack_and_queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author weib
 * @date 2021-10-14 22:26
 * https://leetcode-cn.com/problems/keys-and-rooms/
 * 广度优先
 */
public class No841_Keys_and_Rooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] roomVisit = new int[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int room = queue.poll();
            if (roomVisit[room] == 1) {
                continue;
            }
            roomVisit[room] = 1;
            List<Integer> keys = rooms.get(room);
            queue.addAll(keys);
        }
        for (int i : roomVisit) {
            if(i == 0){
                return false;
            }
        }
        return true;
    }

}
