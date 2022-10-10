package com.jay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jay.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getUser();
}
