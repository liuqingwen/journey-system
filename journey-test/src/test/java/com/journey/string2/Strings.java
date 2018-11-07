package com.journey.string2;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author liuqingwen
 * @date 2018/6/11.
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

    public static final boolean equals(String arg, String arg2) {
        return arg == null ? arg2 == null : arg.equals(arg2);
    }

    public static final boolean equalsIgnoreCase(String arg, String arg2) {
        return arg == null ? arg2 == null : arg.equalsIgnoreCase(arg2);
    }

    public static final boolean isBlank(String arg) {
        return arg == null || arg.trim().length() == 0;
    }

    public static final boolean isNotBlank(String arg) {
        return !isBlank(arg);
    }

    /**
     * 格式化字符串 - velocity-toolbox.xml 在使用
     * @param url
     * @param arg
     * @return
     */
    public static final String format(String url, String... arg) {
        Objects.requireNonNull(url, "url is require not null");
        Objects.requireNonNull(arg, "arg is require not null");
        return String.format(url, arg);
    }

}
