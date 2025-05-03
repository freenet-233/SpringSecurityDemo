package com.wang.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 理赔案件表
 * @TableName t_claim_case_info
 */
@Data
@TableName(value = "t_claim_case_info")
public class ClaimCaseInfo implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    private Integer id;

    /**
     * 交易编码
     */
    private String transactionNo;

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

    private static final long serialVersionUID = 1L;
}