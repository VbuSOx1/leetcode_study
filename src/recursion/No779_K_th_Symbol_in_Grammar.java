package recursion;

import org.junit.jupiter.api.Test;

/**
 * @author weib
 * @date 2021-05-19 23:40
 */
public class No779_K_th_Symbol_in_Grammar {
    public int kthGrammar(int n, int k) {
        if(n == 1){
            return 0;
        }
        int last = kthGrammar(n - 1, ((k>>1) + (k&1)));
        // k 为奇数
        if((k & 1) == 1){
            return last;
        }
        return last ^ 1;
    }
    @Test
    public void test(){

        System.out.println(kthGrammar(4,7));
    }
}
