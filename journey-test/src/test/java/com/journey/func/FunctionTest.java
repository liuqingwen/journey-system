package com.journey.func;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.journey.enums.aop.ResponseReturnType;
import com.journey.test.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author liuqingwen
 * @date 2018/3/12.
 */
public class FunctionTest {


    @FunctionalInterface
    public interface FourFunction<A,B,C,D,R> {

        R applay(A a, B b, C c, D d);

    }

    public static void tes(Runnable runnable) {


//        List<User>
//        Map<String, List<User>>
//        Map<String, Map<String, List<User>>>

        Lists.newArrayList().stream().parallel();
        Lists.newArrayList().stream().sequential();


    }


    @Test
    public void test() {

        Runnable runnable = new Runnable(){@Override public void run() {}};
//        System.out.println(runnable.run(););

//        Callable<String>

        Callable<String> callable = () -> {
            return "1";
        };

        tes(() -> System.out.println(1));







        List<String> list = new ArrayList<String>(){{ add("1"); }};



        ResponseReturnType responseReturnType = ResponseReturnType.FAIL;
        System.out.println(((Supplier<String>)(() -> {switch(responseReturnType) {
            case FAIL: //return ResponseReturnType.FAIL.getDescription();
            case SUCCESS: return ResponseReturnType.SUCCESS.getDescription();
            default: return "不知道什么情况";
        }})).get());

    }

    Map<Integer, String> maps ;
    {
        maps = new HashMap<Integer, String>(12){
            {
                put(1, "2"); put(2, null); put(3, "4");
            }
        };
    }

    @Test
    public void test2() {

        BiConsumer<Integer, String> biConsumer = (id, username) -> new User(id, username);
        biConsumer.andThen((id, username) -> new User(id, id+username));

        biConsumer.accept(1, "2");

        // return R , params Integer,String
//        BiFunction<Integer, String, User> biFunction = ((BiFunction<Integer, String, User>) ((id,  username) -> new User(id, username))).andThen();


//        BiFunction<Integer, String, User> biFunction1 = new BiFunction<Integer, String, User>() {
//            @Override
//            public User apply(Integer id, String username) {
//                return new User(id, username);
//            }
//        };
        Comparator.comparing((User user) -> user.getName());

        //
//        Lists.newArrayList().sort(Comparator.naturalOrder());


//        Collections.sort();
//        Arrays.sort();

//        Stream.of().filter().filter().map().collect()


//        groupingBy(key, value, (key1, key2) -> key1)


        Optional.empty().orElse("");
//        Optional.empty().orElseGet(() -> new User());
//        Optional.empty().orElseThrow()



        Comparator.naturalOrder();


        Set<Integer> set = new HashSet<>();

        Predicate<Integer> predicate = (Integer i) -> i % 2 == 0;
//        predicate.or((Integer i) -> i)

        Lists.newArrayList(1, 2, 4, 5).stream().filter(predicate).collect(toSet());



//        IntStream.range(0, 10).forEach(i -> System.out.println(biFunction.apply(1, "2")));
//        IntStream.rangeClosed(0, 10).forEach(i -> System.out.println(biFunction.apply(1, "2")));



//        biFunction = biFunction.andThen((user) -> user.setName("liu"));

//        System.out.println(biFunction.apply(1, "2"));
//        System.out.println(biFunction.andThen((user) -> user.setName("liu")).apply(1, "2"));

        // 组合
        List<User> batch = batch(Maps.newHashMap(maps));
        System.out.println(batch);

        // 自定义 Predicate
        System.out.println(batch(Maps.newHashMap(maps), user -> StringUtils.isNotBlank(user.getName())));

//        System.out.println(batch(maps, user -> StringUtils.isNotBlank(user.getName()),
//                Comparator.<User>naturalOrder().thenComparing(user -> user.getName()).reversed()));
        // 自定义 Predicate comparator
        System.out.println(batch(Maps.newHashMap(maps), user -> StringUtils.isBlank(user.getName()),
                Comparator.comparing((User user) -> user.getId()).thenComparing(Comparator.comparing(user -> user.getName()))));

    }

    private int add(int i, int j) {
        return i +j ;
    }

    private List<User> batch(Map<Integer, String> maps) {



        BiFunction<Set<Integer>, Map<Integer, String>, List<User>> biFunction =
                (ids, maps1) -> ids.stream().map(id -> new User(id, maps1.getOrDefault(id, "-1"))).collect(toList());

//        List<User>
//        List<UserName>

//        Stream.empty().reduce(0, Integer::sum);
//
//        Map<Id, User> = users.stream().collect(toMap(User::getId, user));
//
//        users.stream().map(User::getName).distinct().colection(toList())

        return biFunction.andThen((users) -> {
            users.removeIf((user) -> user.getId() % 2 != 0);
            return users;
        }).apply(maps.keySet(), maps);
    }

    private List<User> batch(Map<Integer, String> maps, final Predicate<User> predicate) {
        BiFunction<Set<Integer>, Map<Integer, String>, List<User>> biFunction =
                (ids, maps1) -> ids.stream().map(id -> new User(id, maps1.getOrDefault(id, "-1"))).collect(toList());
        return biFunction.andThen((users) -> {
            users.removeIf(user -> predicate.test(user));
            return users;
        }).apply(maps.keySet(), maps);
    }

    private List<User> batch(Map<Integer, String> maps, final Predicate<User> predicate, Comparator<User> comparator) {

        BiFunction<Set<Integer>, Map<Integer, String>, List<User>> biFunction =
                (ids, maps1) -> ids.stream().map(id -> new User(id, maps1.getOrDefault(id, "-1"))).collect(toList());

        List<User> apply = biFunction.andThen((users) -> {
            users.removeIf(user -> predicate.test(user));
            return users;
        }).apply(maps.keySet(), maps);

        // 排序
        apply.sort(comparator);

        return apply;
    }

    // BinaryOperator
    @Test
    public void test3() {

//        &&

        Comparator<User> comparator = Comparator.comparing((User user) -> user.getName()).thenComparing((User user) -> user.getId());
        BinaryOperator<User> binaryOperator = BinaryOperator.maxBy(comparator);
        System.out.println(binaryOperator.apply(new User(1, "2"), new User(2, "2")));

//        BiFunction<User, User, User> biFunction = (User u1, User u2) -> u2.getName().compareTo(u1.getName()) >= 0 ? u1 : u2;

    }

    // Supplier
    @Test
    public void test4() {

        User o = Optional.<User>empty().orElse(new User(1, "2"));
        User o1 = Optional.<User>empty().orElseGet(() -> new User(1, "2"));
        System.out.println(o);
        System.out.println(o1);
    }

    @Test
    public void test5() {

        List<Integer> collect = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7).stream().limit(3).skip(2).collect(toList());
        System.out.println(collect);
    }

    @Test
    public void test6() {

//        Optional.empty().orElseGet()

        Long collect = Stream.generate(() -> new Random().nextInt()).limit(10).collect(counting());
        System.out.println(collect);
        Long collect1 = Stream.generate(() -> new Random().nextInt()).limit(20).collect(counting());
        System.out.println(collect1);

    }

    @Test
    public void test07() {

        BinaryOperator<String> binaryOperator = (x, y) -> x + y;
        BinaryOperator<String> binaryOperator2 = String::concat;
        BinaryOperator<String> binaryOperator3 = (x, y) -> x.concat(y);
    }

    @Test
    public void test08() {

        Map<String, List<String>> collect = Stream.of("1", "2", "3").collect(Collectors.groupingBy(v -> v));

    }

}
