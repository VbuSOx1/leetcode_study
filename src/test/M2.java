package test;

import java.util.Scanner;

/**
 * @author weib
 * @date 2022-04-16 10:15
 */
public class M2 {
    public class Main {
        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int sh = sc.nextInt();
            int sm = sc.nextInt();
            int eh = sc.nextInt();
            int em = sc.nextInt();

            int h = (eh - sh) * 60;
            int m = em - sm;
            System.out.println(h + m);
        }
    }
}
