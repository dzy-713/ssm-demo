package com.rl.mes.auth;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 */
@Setter
@Getter
public class UrlFilter implements Serializable {
    private Long id;
    private String name; //url名称/描述
    private String url; //地址
    private String roles; //所需要的角色，可省略
    private String permissions; //所需要的权限，可省略
}