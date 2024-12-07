package com.wang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.domain.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    @Select("SELECT t1.perms FROM sys_menu t1 " +
            "INNER JOIN sys_role_menu t2 ON t2.`menu_id`=t1.`id` " +
            "INNER JOIN sys_role t3 ON t3.`id`=t2.`role_id` " +
            "INNER JOIN sys_user_role t4 ON t4.`role_id`=t3.`id` " +
            "INNER JOIN sys_user t5 ON t5.`id`=t4.`user_id` " +
            "WHERE t5.`id`= #{id}")
    List<String> selectPermsByUserId(Long id);
}
