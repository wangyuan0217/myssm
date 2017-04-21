package com.trump.controller;

import com.trump.config.Constant;
import com.trump.domain.ResponseObj;
import com.trump.util.GsonUtil;
import com.trump.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/3/28.
 */
public class BaseController {

    public static Logger logger = LoggerFactory.getLogger(BaseController.class);

    public ResponseObj responseObj;    //bean对象


    /**
     * 获取提交参数，取不到就以空字符串代之
     *
     * @param key
     * @return
     */
    protected String getParameter(HttpServletRequest request, String key) {
        return request.getParameter(key) == null ? "" : request.getParameter(key).trim();
    }

    /**
     * 获取提交参数，取不到就报参数以定义字符串代替
     *
     * @param key
     * @return
     */
    protected String getParameterWithDefValue(HttpServletRequest request, String key, String defValue) {
        return StringUtil.isBlank(request.getParameter(key)) ? defValue : request.getParameter(key).trim();
    }

    /**
     * 构造一个参数为空时的 标准json格式
     *
     * @param nullTip json中message提示文字
     * @return
     */
    public String getNullParamReturn(String nullTip) {
        if (responseObj == null)
            responseObj = new ResponseObj();
        responseObj.setCode(Constant.Response.NULL_PARAM);
        responseObj.setMessage(nullTip);
        responseObj.setData(new Object());  //构造  data:{}
        return toJsonStr(responseObj);
    }

    /**
     * 有code message 构造一个标准的json返回数据 data {}
     *
     * @param code
     * @param message
     * @return
     */
    public String getCommonReturn(int code, String message) {
        return getCommonReturn(code, message, null);
    }

    /**
     * 由code message data 构造一个标准的json返回数据
     *
     * @param code
     * @param message
     * @param object
     * @return
     */
    public String getCommonReturn(int code, String message, Object object) {
        if (responseObj == null)
            responseObj = new ResponseObj();
        responseObj.setCode(code);
        responseObj.setMessage(message);
        responseObj.setData(object != null ? object : new Object());
        return toJsonStr(responseObj);
    }

    /**
     * 将Object对象转换成为标准的json字符串
     *
     * @param obj
     * @return
     */
    protected String toJsonStr(Object obj) {
        return GsonUtil.toJson(obj);
    }

}
