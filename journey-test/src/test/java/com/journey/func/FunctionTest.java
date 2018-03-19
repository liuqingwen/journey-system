package com.journey.func;

import com.google.common.collect.Maps;
import com.journey.enums.aop.ResponseReturnType;
import com.journey.test.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

/**
 * @author liuqingwen
 * @date 2018/3/12.
 */
public class FunctionTest {

    @Test
    public void test() {

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
        BiFunction<Integer, String, User> biFunction = (id,  username) -> new User(id, username);
//        biFunction.andThen((user) -> user.setName("liu"));

//        System.out.println(biFunction.apply(1, "2"));
        System.out.println(biFunction.andThen((user) -> user.setName("liu")).apply(1, "2"));

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

    private List<User> batch(Map<Integer, String> maps) {

        BiFunction<Set<Integer>, Map<Integer, String>, List<User>> biFunction =
                (ids, maps1) -> ids.stream().map(id -> new User(id, maps1.getOrDefault(id, "-1"))).collect(toList());
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
}
