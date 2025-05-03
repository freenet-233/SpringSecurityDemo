package com.wang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.domain.SysUser;
import org.springframework.stereotype.Repository;

/**
* @author Tech-Winning
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2024-11-24 00:10:30
* @Entity generator.domain.SysUser
*/
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

}
