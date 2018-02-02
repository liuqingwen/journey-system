package base.java8.test;

import java.util.function.Predicate;

/**
 * @author liuqingwen
 * @date 2018/1/30.
 */
public interface MyList<T> {

    T head();

    MyList<T> tail();

    MyList<T> filter(Predicate<T> p);

    default boolean isEmpty() {
        return true;
    }
}
