package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weib
 * @date 2021-12-15 10:36
 */
public class Test {
    @org.junit.Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.next());
        }
        for (int i = 0; i < t; i++) {
            
        }

    }
}
