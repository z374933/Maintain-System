package com.zhang.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Map;
@Data
@ToString
public class DataJson {
    private Integer code;
    private String msg;
    private Map<String,String> data;
}
