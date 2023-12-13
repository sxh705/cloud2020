package com.atguigu.springcloud.tools;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    public static String toJsonStr(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(obj);
            return s;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJsonStrPretty(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            return s;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
