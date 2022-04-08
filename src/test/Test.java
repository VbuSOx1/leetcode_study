package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author weib
 * @date 2021-12-15 10:36
 */
public class Test {
    @org.junit.Test
    public void test(){
        String a = "a";
        String ab = new String("a");
        System.out.println(" " + a.equals(ab) );
        System.out.println(" " + a == ab );

    }
}
