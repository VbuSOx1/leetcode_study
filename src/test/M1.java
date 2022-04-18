package test;

import java.util.Scanner;

/**
 * @author weib
 * @date 2022-04-16 10:07
 */


public class M1 {


    public class Main {

        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
