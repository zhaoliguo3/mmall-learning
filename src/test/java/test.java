import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * @author Donqiuxote
 * @data 2018/5/12 14:02
 */
public class test {

    public static Map<Integer, String> danwei = new HashedMap();

    public static Map<Integer, String> code = new HashedMap();

    public static void test3(int a, int b) {

//
//
        System.out.println(a / (int) Math.pow(10, b));
        if (b > 0){
            System.out.print(code.get(a / (int) Math.pow(10, b)) + danwei.get(b%8));
            test3(a % (int) Math.pow(10, b), b - 1);
        }
        if (b == 0){
            System.out.print(code.get(a / (int) Math.pow(10, b)));
        }

    }


    private static int sum = 0;

    public static int test2(int a) {
        if (a / 10 != 0) {
            sum++;
            return test2(a / 10);
        }
        return sum;
    }

    public static void test1() {

        danwei.put(0, "");
        danwei.put(1, "十");
        danwei.put(2, "百");
        danwei.put(3, "千");
        danwei.put(4, "万");
       // danwei.put(4, "万");


        code.put(0, "零");
        code.put(1, "一");
        code.put(2, "二");
        code.put(3, "三");
        code.put(4, "四");
        code.put(5, "五");
        code.put(6, "六");
        code.put(7, "七");
        code.put(8, "八");
        code.put(9, "九");


    }

    public static void main(String[] args) {
//        System.out.println("lslalal");
//        System.out.print(175/(int)Math.pow(10,2));
        test1();

        test3(123456,test2(123456));

    }
}
