CREATE TABLE t_claim_case_info_0000 (
                                        id NUMERIC PRIMARY KEY,  -- 主键，数值型，不自增
                                        transaction_no VARCHAR(50) NOT NULL UNIQUE, -- 交易编码
                                        mobile_no VARCHAR(50), -- 手机号
                                        insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 插入时间
                                        update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,  -- 更新时间
                                        insert_id NUMERIC NOT NULL DEFAULT 0,  -- 插入人员ID
                                        update_id NUMERIC NULL DEFAULT 0  -- 更新人员ID
);

-- 创建唯一索引（可选，UNIQUE 约束已自动创建索引）
CREATE UNIQUE INDEX idx_t_claim_case_info_0000_transaction_no ON t_claim_case_info_0000 (transaction_no);

-- 添加表和字段的中文注释
COMMENT ON TABLE t_claim_case_info_0000 IS '理赔案件表';

COMMENT ON COLUMN t_claim_case_info_0000.id IS '主键ID';
COMMENT ON COLUMN t_claim_case_info_0000.transaction_no IS '交易编码';
COMMENT ON COLUMN t_claim_case_info_0000.mobile_no IS '手机号';
COMMENT ON COLUMN t_claim_case_info_0000.insert_time IS '插入时间';
COMMENT ON COLUMN t_claim_case_info_0000.update_time IS '更新时间';
COMMENT ON COLUMN t_claim_case_info_0000.insert_id IS '插入人员ID';
COMMENT ON COLUMN t_claim_case_info_0000.update_id IS '更新人员ID';



CREATE TABLE t_claim_case_info_0001 (
                                        id NUMERIC PRIMARY KEY,  -- 主键，数值型，不自增
                                        transaction_no VARCHAR(50) NOT NULL UNIQUE,  -- 交易编码
                                        mobile_no VARCHAR(50), -- 手机号
                                        insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 插入时间
                                        update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,  -- 更新时间
                                        insert_id NUMERIC NOT NULL DEFAULT 0,  -- 插入人员ID
                                        update_id NUMERIC NULL DEFAULT 0  -- 更新人员ID
);

-- 创建唯一索引（可选，UNIQUE 约束已自动创建索引）
CREATE UNIQUE INDEX idx_t_claim_case_info_0001_transaction_no ON t_claim_case_info_0001 (transaction_no);

-- 添加表和字段的中文注释
COMMENT ON TABLE t_claim_case_info_0001 IS '理赔案件表';

COMMENT ON COLUMN t_claim_case_info_0001.id IS '主键ID';
COMMENT ON COLUMN t_claim_case_info_0001.transaction_no IS '交易编码';
COMMENT ON COLUMN t_claim_case_info_0001.mobile_no IS '手机号';
COMMENT ON COLUMN t_claim_case_info_0001.insert_time IS '插入时间';
COMMENT ON COLUMN t_claim_case_info_0001.update_time IS '更新时间';
COMMENT ON COLUMN t_claim_case_info_0001.insert_id IS '插入人员ID';
COMMENT ON COLUMN t_claim_case_info_0001.update_id IS '更新人员ID';



CREATE TABLE t_claim_case_info_0002 (
                                        id NUMERIC PRIMARY KEY,  -- 主键，数值型，不自增
                                        transaction_no VARCHAR(50) NOT NULL UNIQUE,  -- 交易编码
                                        mobile_no VARCHAR(50), -- 手机号
                                        insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 插入时间
                                        update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,  -- 更新时间
                                        insert_id NUMERIC NOT NULL DEFAULT 0,  -- 插入人员ID
                                        update_id NUMERIC NULL DEFAULT 0  -- 更新人员ID
);

-- 创建唯一索引（可选，UNIQUE 约束已自动创建索引）
CREATE UNIQUE INDEX idx_t_claim_case_info_0002_transaction_no ON t_claim_case_info_0002 (transaction_no);

-- 添加表和字段的中文注释
COMMENT ON TABLE t_claim_case_info_0002 IS '理赔案件表';

COMMENT ON COLUMN t_claim_case_info_0002.id IS '主键ID';
COMMENT ON COLUMN t_claim_case_info_0002.transaction_no IS '交易编码';
COMMENT ON COLUMN t_claim_case_info_0002.mobile_no IS '手机号';
COMMENT ON COLUMN t_claim_case_info_0002.insert_time IS '插入时间';
COMMENT ON COLUMN t_claim_case_info_0002.update_time IS '更新时间';
COMMENT ON COLUMN t_claim_case_info_0002.insert_id IS '插入人员ID';
COMMENT ON COLUMN t_claim_case_info_0002.update_id IS '更新人员ID';



CREATE TABLE t_claim_case_info_0003 (
                                        id NUMERIC PRIMARY KEY,  -- 主键，数值型，不自增
                                        transaction_no VARCHAR(50) NOT NULL UNIQUE,  -- 交易编码
                                        mobile_no VARCHAR(50), -- 手机号
                                        insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 插入时间
                                        update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,  -- 更新时间
                                        insert_id NUMERIC NOT NULL DEFAULT 0,  -- 插入人员ID
                                        update_id NUMERIC NULL DEFAULT 0  -- 更新人员ID
);

-- 创建唯一索引（可选，UNIQUE 约束已自动创建索引）
CREATE UNIQUE INDEX idx_t_claim_case_info_0003_transaction_no ON t_claim_case_info_0003 (transaction_no);

-- 添加表和字段的中文注释
COMMENT ON TABLE t_claim_case_info_0003 IS '理赔案件表';

COMMENT ON COLUMN t_claim_case_info_0003.id IS '主键ID';
COMMENT ON COLUMN t_claim_case_info_0003.transaction_no IS '交易编码';
COMMENT ON COLUMN t_claim_case_info_0003.mobile_no IS '手机号';
COMMENT ON COLUMN t_claim_case_info_0003.insert_time IS '插入时间';
COMMENT ON COLUMN t_claim_case_info_0003.update_time IS '更新时间';
COMMENT ON COLUMN t_claim_case_info_0003.insert_id IS '插入人员ID';
COMMENT ON COLUMN t_claim_case_info_0003.update_id IS '更新人员ID';






CREATE TABLE t_individual_authorization_management_0000 (
                                                            id NUMERIC PRIMARY KEY,  -- 主键，数值型，不自增
                                                            auth_code VARCHAR(50) NOT NULL UNIQUE,  -- 授权码
                                                            insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 插入时间
                                                            update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,  -- 更新时间
                                                            insert_id NUMERIC NOT NULL DEFAULT 0,  -- 插入人员ID
                                                            update_id NUMERIC NULL DEFAULT 0  -- 更新人员ID
);

-- 创建唯一索引（可选，UNIQUE 约束已自动创建索引）
CREATE UNIQUE INDEX idx_t_individual_authorization_management_0000_auth_code ON t_individual_authorization_management_0000 (auth_code);

-- 添加表和字段的中文注释
COMMENT ON TABLE t_individual_authorization_management_0000 IS '理赔案件表';

COMMENT ON COLUMN t_individual_authorization_management_0000.id IS '主键ID';
COMMENT ON COLUMN t_individual_authorization_management_0000.auth_code IS '授权码';
COMMENT ON COLUMN t_individual_authorization_management_0000.insert_time IS '插入时间';
COMMENT ON COLUMN t_individual_authorization_management_0000.update_time IS '更新时间';
COMMENT ON COLUMN t_individual_authorization_management_0000.insert_id IS '插入人员ID';
COMMENT ON COLUMN t_individual_authorization_management_0000.update_id IS '更新人员ID';



CREATE TABLE t_individual_authorization_management_0001 (
                                                            id NUMERIC PRIMARY KEY,  -- 主键，数值型，不自增
                                                            auth_code VARCHAR(50) NOT NULL UNIQUE,  -- 授权码
                                                            insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 插入时间
                                                            update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,  -- 更新时间
                                                            insert_id NUMERIC NOT NULL DEFAULT 0,  -- 插入人员ID
                                                            update_id NUMERIC NULL DEFAULT 0  -- 更新人员ID
);

-- 创建唯一索引（可选，UNIQUE 约束已自动创建索引）
CREATE UNIQUE INDEX idx_t_individual_authorization_management_0001_auth_code ON t_individual_authorization_management_0001 (auth_code);

-- 添加表和字段的中文注释
COMMENT ON TABLE t_individual_authorization_management_0001 IS '理赔案件表';

COMMENT ON COLUMN t_individual_authorization_management_0001.id IS '主键ID';
COMMENT ON COLUMN t_individual_authorization_management_0001.auth_code IS '授权码';
COMMENT ON COLUMN t_individual_authorization_management_0001.insert_time IS '插入时间';
COMMENT ON COLUMN t_individual_authorization_management_0001.update_time IS '更新时间';
COMMENT ON COLUMN t_individual_authorization_management_0001.insert_id IS '插入人员ID';
COMMENT ON COLUMN t_individual_authorization_management_0001.update_id IS '更新人员ID';



CREATE TABLE t_individual_authorization_management_0002 (
                                                            id NUMERIC PRIMARY KEY,  -- 主键，数值型，不自增
                                                            auth_code VARCHAR(50) NOT NULL UNIQUE,  -- 授权码
                                                            insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 插入时间
                                                            update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,  -- 更新时间
                                                            insert_id NUMERIC NOT NULL DEFAULT 0,  -- 插入人员ID
                                                            update_id NUMERIC NULL DEFAULT 0  -- 更新人员ID
);

-- 创建唯一索引（可选，UNIQUE 约束已自动创建索引）
CREATE UNIQUE INDEX idx_t_individual_authorization_management_0002_auth_code ON t_individual_authorization_management_0002 (auth_code);

-- 添加表和字段的中文注释
COMMENT ON TABLE t_individual_authorization_management_0002 IS '理赔案件表';

COMMENT ON COLUMN t_individual_authorization_management_0002.id IS '主键ID';
COMMENT ON COLUMN t_individual_authorization_management_0002.auth_code IS '授权码';
COMMENT ON COLUMN t_individual_authorization_management_0002.insert_time IS '插入时间';
COMMENT ON COLUMN t_individual_authorization_management_0002.update_time IS '更新时间';
COMMENT ON COLUMN t_individual_authorization_management_0002.insert_id IS '插入人员ID';
COMMENT ON COLUMN t_individual_authorization_management_0002.update_id IS '更新人员ID';



CREATE TABLE t_individual_authorization_management_0003 (
                                                            id NUMERIC PRIMARY KEY,  -- 主键，数值型，不自增
                                                            auth_code VARCHAR(50) NOT NULL UNIQUE,  -- 授权码
                                                            insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 插入时间
                                                            update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,  -- 更新时间
                                                            insert_id NUMERIC NOT NULL DEFAULT 0,  -- 插入人员ID
                                                            update_id NUMERIC NULL DEFAULT 0  -- 更新人员ID
);

-- 创建唯一索引（可选，UNIQUE 约束已自动创建索引）
CREATE UNIQUE INDEX idx_t_individual_authorization_management_0003_auth_code ON t_individual_authorization_management_0003 (auth_code);

-- 添加表和字段的中文注释
COMMENT ON TABLE t_individual_authorization_management_0003 IS '理赔案件表';

COMMENT ON COLUMN t_individual_authorization_management_0003.id IS '主键ID';
COMMENT ON COLUMN t_individual_authorization_management_0003.auth_code IS '授权码';
COMMENT ON COLUMN t_individual_authorization_management_0003.insert_time IS '插入时间';
COMMENT ON COLUMN t_individual_authorization_management_0003.update_time IS '更新时间';
COMMENT ON COLUMN t_individual_authorization_management_0003.insert_id IS '插入人员ID';
COMMENT ON COLUMN t_individual_authorization_management_0003.update_id IS '更新人员ID';



