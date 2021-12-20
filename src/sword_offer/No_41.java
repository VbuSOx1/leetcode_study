package sword_offer;

import org.junit.Test;

/**
 * @author weib
 * @date 2021-12-20 20:03
 *  41. 数据流中的中位数
 *  https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 *
 *  更好的解法 两个优先级队列 一个小根堆 一个大根堆，看题解
 *  关注中位数，其他的数字顺序不关系，刚好符合一个大根堆 一个小根堆的思想 太强了
 */
public class No_41 {
    class Link{
        int val;
        Link next;
        Link(int val, Link next) {
            this.val = val;
            this.next = next;
        }
    }
    int size;
    Link valStream;

    /** initialize your data structure here. */
    public No_41() {
        // 哨兵
        valStream = new Link(0, null);
        size = 0;
        // sortedList = new LinkedList<>();
    }

    public void addNum(int num) {
        Link cur = valStream;
        Link pre = valStream;
        while (cur != null) {
            pre = cur;
            cur = cur.next;
            if (cur == null || cur.val >= num){
                break;
            }
        }
        pre.next = new Link(num, cur);
        size++;
    }

    public double findMedian() {
        if (size % 2 == 0) {
            int index = size / 2;
            Link p = this.get(index - 1);
            return (double)(p.val + p.next.val) / (double)2;
        }
        return this.get(size/2).val;
    }

    public Link get(int index) {
        Link p = valStream;
        while (index >= 0){
            p = p.next;
            index--;
        }
        return p;
    }


    @Test
    public void test(){
        No_41 t = new No_41();
        t.addNum(1);
        System.out.println(t.findMedian());
    }

}
