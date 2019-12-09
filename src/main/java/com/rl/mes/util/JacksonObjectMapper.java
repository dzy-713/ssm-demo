package com.rl.mes.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 重新配置ObjectMapper类
 * 解决mybatis懒加载导致无法序列化为json数据问题
 *
 */
public class JacksonObjectMapper extends ObjectMapper {

    public JacksonObjectMapper() {
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
}
