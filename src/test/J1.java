package test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author weib
 * @date 2022-04-16 19:41
 */
public class J1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<String> stack = new Stack<>();
        while (n > 0) {
            stack.clear();
            boolean tag = true;
            int lineNum = sc.nextInt();
            String c = sc.nextLine();
            for (int i = 0; i < lineNum; i++){
                String textLine = sc.nextLine().trim();
                if (tag && textLine.startsWith("end")) {
                    // 出栈
                    String sLine = stack.isEmpty()?null:stack.pop();
                    if (sLine == null || !textLine.endsWith(sLine)){
                        tag = false;
                    }
                }else {
                    stack.add(textLine);
                }
            }
            if (tag && stack.isEmpty()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            n--;
        }
    }
}
