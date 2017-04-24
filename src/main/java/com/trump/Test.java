package com.trump;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/3/28.
 */
public class Test {

    protected final static Logger logger = LoggerFactory.getLogger(Test.class);

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
//        testLog();

        int nums[] = new int[]{1, 2, 3};
        //参数-引用数据类型（对象/数组）
        //这时实际参数与形式参数指向同一个地址
        //在方法执行中，对形式参数的操作实际上就是对实际参数的操作，
        // 这个结果在方法结束后被保留了下来，所以方法执行中形式参数的改变将会影响实际参数。
        test(nums);   //a即存储单元地址的引用


        //基本类型 boolean、char、byte、short、int、long、float、double。
        //引用类型就是那些可以通过new来创建对象的类型（基本上都是派生自Object）。

//        http://www.cnblogs.com/monodin/p/3451104.html
//        https://www.zhihu.com/question/31203609
    }

    public static void test(int num[]) {
        for (int i = 0; i < num.length; i++) {
            num[i] += 10;
        }
    }

    private static void testLog() {
        logger.debug("DEBUG TEST 这个地方输出DEBUG级别的日志");
        logger.info("INFO test 这个地方输出INFO级别的日志");
        logger.error("ERROR test 这个地方输出ERROR级别的日志");
    }

}
