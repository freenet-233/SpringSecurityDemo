package com.wang.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Role {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String roleKey;
    private String status;
    private Integer delFlag;
    private Long createBy;
    private Date createTime;
    private Long updateBy;
    private Date updateTime;
    private String remark;
}
