package stack_and_queue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author weib
 * @date 2021-06-07 9:20
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 逆波兰表达式求值
 *
 * 递归
 */
public class No150EvaluateReversePolishNotation {
    HashSet<String> optor = new HashSet<>(Arrays.asList(new String[]{"+", "-", "*", "/"}));
    int lastIndex = 0;
    public int evalRPN(String[] tokens) {
        lastIndex = tokens.length;
        return eval(tokens);
    }


    public int eval(String[] tokens){
        lastIndex -= 1;
        int curIndex = lastIndex;
        if(optor.contains(tokens[curIndex])){
            int n1 = eval(tokens);
            int n2 = eval(tokens);
            switch (tokens[curIndex]){
                case "+" : return n2 + n1;
                case "-" : return n2 - n1;
                case "*" : return n2 * n1;
                case "/" : return n2 / n1;
                default: return 0;
            }
        }else {
            return Integer.parseInt(tokens[lastIndex]);

        }
    }

    @Test
    public void testt(){
        String[] token = {"4","13","5","/","+"} ;
        System.out.println(evalRPN(token));
    }
}
