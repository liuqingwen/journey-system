package base.java8.test;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/1/30.
 */
public class LazyTest {

    @Test
    public void test() {

        LazyList<Integer> lazyList = LazyList.from(2);
        int two = lazyList.head();
        int three = lazyList.tail().head();
        int four = lazyList.tail().tail().head();

        System.out.println(two + " " + three + " " + four);

    }

    @Test
    public void test1() {

        LazyList<Integer> lazyList = LazyList.from(2);
        int two = LazyList.primes(lazyList).head();
        int three = LazyList.primes(lazyList).tail().head();
        int five = LazyList.primes(lazyList).tail().tail().head();

        System.out.println(two + " " + three + " " + five);

    }

}
