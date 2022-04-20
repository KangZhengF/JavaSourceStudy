package com.kang.mapper;

import com.kang.entity.UserPO;

public interface UserMapper {
    UserPO selectUserById(Integer id);
}
