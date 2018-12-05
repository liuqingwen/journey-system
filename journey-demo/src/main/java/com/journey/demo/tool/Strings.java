package com.journey.demo.tool;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author liuqingwen
 * @date 2018/10/16.
 */
public class Strings {

    public final static int STRING_BUILDER_INIT_SIZE = 1 << 6;
    public final static int STRING_BUILDER_DEFAULT_INIT_SIZE = 1 << 4;

    /**
     * 字符串拼接
     *
     * @param separator 连接符
     * @param args
     * @return
     */
    public static final StringBuilder joint(final String separator, Object... args) {
        return joint(STRING_BUILDER_INIT_SIZE, separator, args);
    }

    public static final StringBuilder joint(final int initSize, final String separator, Object... args) {
        Objects.requireNonNull(args, "args 不允许为空");
        final StringBuilder builder = new StringBuilder(initSize < STRING_BUILDER_DEFAULT_INIT_SIZE ? STRING_BUILDER_DEFAULT_INIT_SIZE : initSize); builder.append(args[0]);
        return Arrays.stream(args, 1, args.length).filter(arg -> arg != null).map(Object::toString).reduce(builder,
                (StringBuilder starter, String arg) -> starter.append(separator).append(arg), StringBuilder::append);
        //        return Arrays.stream(args).filter(arg -> arg != null).map(Object::toString).collect(Collectors.joining(separator));
    }

    public static final StringBuilder joint2(final int initSize, final String separator, Object... args) {
        Objects.requireNonNull(args, "args 不允许为空");
        return Arrays.stream(args).filter(arg -> arg != null).map(Object::toString).reduce(new StringBuilder(initSize < STRING_BUILDER_DEFAULT_INIT_SIZE ? STRING_BUILDER_DEFAULT_INIT_SIZE : initSize),
                (StringBuilder starter, String arg) -> starter.append(separator).append(arg), StringBuilder::append);
    }

}
