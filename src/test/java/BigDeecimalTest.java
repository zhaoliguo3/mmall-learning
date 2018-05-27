import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Donqiuxote
 * @data 2018/4/14 12:29
 */
public class BigDeecimalTest {

    @Test
    public void test1(){
     //   System.out.println(0.05+0.01);
        float a = (float)0.0000000005;
        double b = 0.01;
//        System.out.println(a);
//        System.out.println(a+b);
        BigDecimal c = new BigDecimal("0.05");
        BigDecimal d = new BigDecimal("0.01");
   //     System.out.println(c.add(d));
    }
}
