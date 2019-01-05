import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqingwen
 * @date 2018/9/10.
 */
public class DynamicProxyTest {

    public static void main(String[] args) {

        ClassOperate classOperate = new ClassOperate();
        System.out.println("pre dynamic test params == java-version:" + System.getProperty("java.version"));
        ClassOperate classOperate2 = new DynamicProxyByCodeGenerationLibrary(classOperate).<ClassOperate>newProxyInstance();
        IClassOperate iClassOperate = new DynamicProxyByInvocationHandler(classOperate).<IClassOperate>newProxyInstance();

        // pre hot
        int executeCount = 10_000;
        System.out.println("pre dynamic test params == executeCount:" + executeCount + ", java-version:" + System.getProperty("java.version"));
        preHotExecute(classOperate, executeCount);
        preHotExecute(classOperate2, executeCount);
        preHotExecute(iClassOperate, executeCount);

        // 10000

        Map<String, IClassOperate> map = new HashMap<>();
        map.put("native", classOperate);
        map.put("cgProxy", classOperate2);
        map.put("jdkProxy", iClassOperate);

        int repeatCount = 3;
        int executeCount2 = 100_000;
        compareExecute(repeatCount, executeCount2, map);

        executeCount2 = 500_000;
        compareExecute(repeatCount, executeCount2, map);

        executeCount2 = 5_000_000;
        compareExecute(repeatCount, executeCount2, map);

        executeCount2 = 50_000_000;
        compareExecute(repeatCount, executeCount2, map);
    }

    // 预热执行
    private static void preHotExecute(IClassOperate classOperate, int executeCount) {

        long stime = System.currentTimeMillis();
        for (int index = 0; index < executeCount; index++) {
            classOperate.test();
        }
        System.out.println("[" + classOperate.getClass().getName()+"] " + (System.currentTimeMillis() - stime));

    }

    private static void compareExecute(int repeatCount, int executeCount, Map<String, IClassOperate> map) {

        System.out.println("dynamic test params == repeatCount:" + repeatCount + ", executeCount:" + executeCount + ", java-version:" + System.getProperty("java.version"));
        String line = "----------------------------------------";
        for (int index = 0; index < repeatCount; index++) {

            System.out.println(line);
            for (Map.Entry<String, IClassOperate> entry : map.entrySet()) {

                long stime2 = System.currentTimeMillis();
                String v2 = "[" + entry.getKey() + "] -执行";
                for (int index2 = 0; index2 < executeCount; index2++) {
                    entry.getValue().test();
                }
                System.out.println(v2 + "-耗时：" + (System.currentTimeMillis() - stime2));
            }
            System.out.println(line);
        }
//        for (Map.Entry<String, IClassOperate> entry : map.entrySet()) {
//
//            System.out.println(line);
//            long stime2 = System.currentTimeMillis();
//            String v2 = "[" + entry.getKey() + "] -执行";
//            System.out.println(v2);
//            for (int index = 0; index < repeatCount; index++) {
//
////                System.out.println(equalLine);
//                String v = entry.getKey() + "-执行-"+index+"";
//                System.out.println(v);
//                long stime = System.currentTimeMillis();
//                for (int index2 = 0; index2 < executeCount; index2++) {
//                    entry.getValue().test();
//                }
//                System.out.println(v + "-耗时：" + (System.currentTimeMillis() - stime));
////                System.out.println(equalLine);
//
//            }
//            System.out.println(v2 + "-耗时：" + (System.currentTimeMillis() - stime2));
//            System.out.println(line);
//        }

    }


}
