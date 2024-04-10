package com.zhang.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.entily.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class DataVO<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;
}
