package com.journey.test;

/**
 * 子类 测试
 *
 * @author liuqingwen
 * @date 2017/11/15.
 */
public class SubclassTest {

    public static void main(String[] args) {

        SubClass3 subClass3 = new SubClass3("1", "2");
        subClass3.init();

    }

}


abstract class SubClass {

    private String string;

    public SubClass(String s) {
        this.string = s;
        this.print();
    }

    public abstract void init();

    public void print() {
        System.out.println("SubClass -> " + getString());
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}

abstract class SubClass2 extends SubClass {

    private String string2;

    public SubClass2(String s) {
        super(s);
        super.print();
    }

    @Override
    public void print() {
        System.out.println("SubClass2 -> " + getString2());
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }
}

class SubClass3 extends SubClass2 {

    public SubClass3(String s) {
        super(s);
    }

    public SubClass3(String s, String s2) {
        this(s);
        super.setString2(s2);
    }

    @Override
    public void init() {
        System.out.println(super.getString2());
    }
}
