package com.mikewoo.study.common;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eric Gui
 * @date 2018/8/13
 */
public class CommonResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public CommonResult() {
        put("code", 0);
    }

    public static CommonResult error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static CommonResult error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static CommonResult error(int code, String msg) {
        CommonResult r = new CommonResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static CommonResult ok(String msg) {
        CommonResult r = new CommonResult();
        r.put("msg", msg);
        return r;
    }

    public static CommonResult ok(Map<String, Object> map) {
        CommonResult r = new CommonResult();
        r.putAll(map);
        return r;
    }

    public static CommonResult ok() {
        return new CommonResult();
    }

    public CommonResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public CommonResult data(Object value) {
        super.put("data", value);
        return this;
    }

    public static CommonResult apiError(String msg) {
        return error(1, msg);
    }
}
