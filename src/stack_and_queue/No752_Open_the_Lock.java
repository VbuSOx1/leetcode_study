package stack_and_queue;

import org.junit.Test;

import java.util.*;

/**
 * @author weib
 * @date 2021-05-30 10:06
 * https://leetcode-cn.com/problems/open-the-lock/
 * 打开转盘锁
 * 思路: 找到每个轮子最快达到target的转动次数
 * 然后分别假设最后一个转动的 是 1,2,3,4
 * 看最后转动哪个 次数最小
 * 正序转动次数 n
 * 逆序转动次数 10-n
 *
 * 以上思路不对:看题解 用 BFS
 */
public class No752_Open_the_Lock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        queue.offer(null);
        int count = 1;
        while(!queue.isEmpty()){
            if(queue.peek() == null){
                count++;
                queue.poll();
                if(queue.peek() != null){
                    queue.offer(null);
                }

                continue;
            }
            if(queue.peek().equals(target)){
                return count;
            }
            if(deadendSet.contains(queue.peek())){
                queue.poll();
                continue;
            }
            String curStr = queue.poll();
            visited.add(curStr);
            for(int i = 0; i < 4; i++ ){
                int curInt = Integer.parseInt(curStr.substring(i, i+1));
                String pre = curStr.substring(0, i);
                String end = curStr.substring(i + 1);
                String add = pre+ (curInt + 1 + 10 )%10 + end;
                String sub = pre+ (curInt - 1 + 10 )%10 + end;
                if(!visited.contains(add)){
                    queue.offer(add);
                    visited.add(add);
                }
                if(!visited.contains(sub)){
                    queue.offer(sub);
                    visited.add(sub);
                }
            }
        }
        return -1;
    }
    @Test
    void testtt(){
        System.out.println("1234".substring(4,4));
    }

}





























