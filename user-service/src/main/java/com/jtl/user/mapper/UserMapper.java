package com.jtl.user.mapper;

import com.jtl.user.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author JT.L
 * @date 2020/2/22 18:01:19
 * @description
 */
@Repository
public interface UserMapper extends Mapper<User> {
}
