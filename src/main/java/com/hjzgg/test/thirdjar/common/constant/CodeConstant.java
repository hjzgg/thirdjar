package com.hjzgg.test.thirdjar.common.constant;

public class CodeConstant {

    /**
     * 普通code常量
     */
    public static class Normal {

        public static final String SUCCESS = "0";

        public static final String SUCCESS_MSG = "SUCCESS";

        public static final String FAILURE = "9999";

        public static final String FAILURE_MSG = "网络异常";

        public static final String LOGIN_FAILURE = "9000";

    }

    /**
     * 异常常量
     */
    public static class ParamCheck {

        /**
         * 值错误码, 主要用于上传参数错误
         */
        public static final String VALUE_ERROR_CODE = "1001";
    }

    /**
     * 业务请求
     */
    public static class BusinessHttp {

        public static final String REQUEST_FAILURE = "1101";

        public static final String REQUEST_SUCCESS = "0";

        public static final String IPOS_REQUEST_SUCCESS = "1";

        public static final String IPOS_MSG = "msg";
    }

    /**
     * 业务异常码
     */
    public static class Business {

        public static final String NULL_VALUE = "2001";

    }
}
