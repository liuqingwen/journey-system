/**
 * @author liuqingwen
 * @date 2018/9/10.
 */
public class ClassOperate implements IClassOperate {

    @Override
    public String test() {
        String s = "我是ClassOperate" + "#" + "test";
//        System.out.println("我是ClassOperate#test");
        return s;
    }
}
