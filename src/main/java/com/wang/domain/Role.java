package com.wang.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
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
