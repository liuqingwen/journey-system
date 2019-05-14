package com.journey.string2;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author liuqingwen
 * @date 2018/9/6.
 */
public class StringTest {

    @Test
    public void test() {

        String[] strings = StringUtils.delimitedListToStringArray("i am java develop", "", "liu");
        System.out.println(Arrays.toString(strings));

        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement.getClassName() + "#" + stackTraceElement.getMethodName());
            if ("main".equalsIgnoreCase(stackTraceElement.getMethodName())) {
                System.err.println(stackTraceElement.getClassName() + "#" + stackTraceElement.getMethodName());
            }
        }

    }

    @Test
    public void test2() {

        System.out.println("abc".indexOf("b"));

    }

    @Test
    public void test3() {

        String str = "liuqingwen";
        System.out.println(reverse(str));

    }

    private String reverse(String arg) {

        char[] chars = arg.toCharArray();
        int length = chars.length;
        if (length < 2) {
            return arg;
        }

        char t;
        for (int index = 0; index < length; index++) {
            if (index > (length - 1 - index)) {
                break;
            }
            t = chars[index];
            chars[index] = chars[length - 1 - index];
            chars[length - 1 - index] = t;

        }

        return new String(chars);
    }

    @Test
    public void test4() {

        String s = "qq.txt";
        int index = -1;
        System.out.println((index = s.indexOf(".")) > -1 ? s.substring(0, index) : s);

    }

    @Test
    public void test5() {

        StringBuilder stringBuilder = new StringBuilder(1 << 5);
        stringBuilder.append("1").append(",").append("2").append(",").append("3").append(",").append("4").append(",")
                .append("5").append(",").append("6").append(",");
        System.out.println(stringBuilder.lastIndexOf(","));
        System.out.println(stringBuilder.length());
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));

    }

    @Test
    public void test6() {

        System.out.println("http://www.jiuxian.com/jalsdkfjalsd".replace("http://www.", "").indexOf("jiuxian.com"));

    }

    @Test
    public void test7() {

        String fromUrl = "from=http://test70member.jiuxian.com/trademanage/my_order-9.htm";
        int index1 = 0, index2 = 0;
        Pattern compile = Pattern.compile("(from=)?((http://)|(https://))?\\w+\\.\\w+\\.com.*");
        Pattern compile2 = Pattern.compile("(from=)?((http://)|(https://))?\\w+\\.com.*");
        if (compile.matcher(fromUrl).matches()) {
            index1 = fromUrl.indexOf(".");
            index2 = fromUrl.indexOf("com");
        }
        if (compile2.matcher(fromUrl).matches()) {
            index1 = -1;
            index2 = fromUrl.indexOf(".") + 1;
        }

        if (index1 != 0 && index2 > 0) {
            String jiuxian = fromUrl.substring(index1 + 1, index2 - 1);
            if (!jiuxian.equals("jiuxian")) {
                fromUrl = null;
            } else {
                if (fromUrl.indexOf("from=") >= 0) {
                    fromUrl = fromUrl.substring(
                            fromUrl.indexOf("from=") + 5, fromUrl.length());
                }
            }
        }

        System.out.println(fromUrl);
    }

    @Test
    public void test8() {

        try {
            URL url = new URL("https://test70login.jiuxian.com/login.htm?from=http://test70member.jiuxian.com/trademanage/my_order-9.htm");
            System.out.println(url.getHost());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test9() {

        String takePath = "/Users/liuqingwen/公司/酒仙网/workspace/root/target/ROOT/tmp/20181107/运费导入模板1541589953335.xlsx";
        String namespace = "/exception";
        int lastIndex = takePath.lastIndexOf("/");
        int lastBeforeIndex = takePath.substring(0, takePath.lastIndexOf("/")).lastIndexOf("/");
        System.out.println(Strings.joint("", takePath.substring(0, lastBeforeIndex), namespace, takePath.substring(lastBeforeIndex, lastIndex), takePath.substring(lastIndex)).toString());

    }

    @Test
    public void test10() {
        int[] ints = new int[]{1, 2};
        for (int index = 0; index < ints.length / 2; index++) {
            ints[index] = ints[index] ^ ints[ints.length - 1 - index];
            ints[ints.length - 1 - index] = ints[index] ^ (ints[ints.length - 1 - index]);
            ints[index] = ints[index] ^ (ints[ints.length - 1 - index]);
        }

        System.out.println(Arrays.toString(ints));
        System.out.println((-5 & 5));

//        0010
//        1101
    }

    @Test
    public void test11() {

        System.out.println(Strings.joint2(Strings.STRING_BUILDER_DEFAULT_INIT_SIZE, ",", "1", "2", "3"));
        System.out.println(Strings.joint3(Strings.STRING_BUILDER_DEFAULT_INIT_SIZE, ",", "1", "2", "3").toString());

    }

    @Test
    public void test12() {

        class StringAppend {

            public void add() {
                String str = "a";
                long s = System.currentTimeMillis();
                for (int index = 0; index < 1_000_000; index++) {
                    str += "b";
                }
                System.out.println("add-" + str);
                System.out.println(System.currentTimeMillis() - s + "-add");
            }

            public void format() {
                String str = "";
                long s = System.currentTimeMillis();
                for (int index = 0; index < 1_000_000; index++) {
                    str = String.format("a%s", "b");
                }
                System.out.println("format-" + str);
                System.out.println(System.currentTimeMillis() - s + "-format");
            }
        }

        new StringAppend().add();
        new StringAppend().format();

    }

    @Test
    public void test13() {

        System.out.println(Pattern.compile("\\s*[,，、；;]\\s*").split("skin")[0]);

    }

    @Test
    public void test14() {

//        System.out.println(2028025265 % 3);
        System.out.println(2028025265 % 100);

    }

    public static String get() {

        try {
            return "2";
        } finally {
            return "1";
        }

    }
}
