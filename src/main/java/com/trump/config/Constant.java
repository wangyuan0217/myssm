package com.trump.config;

/**
 * 项目中用到的常量
 */
public class Constant {

    /**
     * 接口返回的code
     */
    public static class Response {
        public static final int OK = 200; //成功
        public static final int NULL_PARAM = 201; //缺少参数
        public static final int USER_NOT_EXIST = 202; //用户不存在
        public static final int WRONG_PASS = 203; //密码错误
        public static final int UNKNOWN_ERROR = 204; //未知错误
    }

    public static class Others {
        //....
    }

}
