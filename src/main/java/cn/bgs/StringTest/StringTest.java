package cn.bgs.StringTest;

import java.util.function.Function;

public class StringTest {
    public static void main(String[] args) {
        TestString();
    }
    public static void TestString(){
        String str = "HellO";
        System.out.println(Test003(str, StringTest::toUpperCase));
    }

    private static String Test003(String a, Function<String,String> function) {
        return function.apply(a);
    }
    //字符串反转
    public static String Reverse (String s){
        StringBuffer sb=new StringBuffer(s);
        StringBuffer reverse = sb.reverse();
        return reverse.toString();
    }
    //字符串首字母大写
    public static String toUpperCase (String s){
        return s.toUpperCase();
    }
    //字符串全部小写
    public static String toLowerCase(String s){
        return s.toLowerCase();
    }
}
