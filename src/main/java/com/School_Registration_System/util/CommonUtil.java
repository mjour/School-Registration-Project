package com.School_Registration_System.util;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

    public HashMap<String, Object> genResponse(int statusCode, String msg,
        Object data) {
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("status", statusCode);
        dataMap.put("msg", msg);
        dataMap.put("data", data);
        return dataMap;
    }

    public HashMap<String, Object> genResponse(HttpStatus statusCode,
        String msg, Object data) {
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("status", statusCode.value());
        dataMap.put("msg", msg);
        dataMap.put("data", data);
        return dataMap;
    }
}