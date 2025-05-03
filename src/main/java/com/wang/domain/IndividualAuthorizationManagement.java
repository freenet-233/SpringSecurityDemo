package com.wang.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 理赔案件表
 * @TableName t_individual_authorization_management
 */
@TableName(value ="t_individual_authorization_management")
@Data
public class IndividualAuthorizationManagement implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    private Integer id;

    /**
     * 授权码
     */
    private String authCode;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 插入人员ID
     */
    private Integer insertId;

    /**
     * 更新人员ID
     */
    private Integer updateId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}