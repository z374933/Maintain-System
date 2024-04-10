package com.zhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.entily.Billboard;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody //表示持久层
public interface BillboardMapper extends BaseMapper<Billboard> {
}
