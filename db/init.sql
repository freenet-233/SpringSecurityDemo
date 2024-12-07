CREATE TABLE `sys_user` (
                            `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `user_name` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '用户名',
                            `nick_name` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '昵称',
                            `password` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '密码',
                            `status` CHAR(1) DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
                            `email` VARCHAR(64) DEFAULT NULL COMMENT '邮箱',
                            `phone_number` VARCHAR(32) DEFAULT NULL COMMENT '手机号',
                            `sex` CHAR(1) DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
                            `avatar` VARCHAR(128) DEFAULT NULL COMMENT '头像',
                            `user_type` CHAR(1) NOT NULL DEFAULT '1' COMMENT '用户类型（0管理员，1普通用户）',
                            `create_by` BIGINT(20) DEFAULT NULL COMMENT '创建人的用户id',
                            `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                            `update_by` BIGINT(20) DEFAULT NULL COMMENT '更新人',
                            `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                            `deleted` INT(11) DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
                            PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


CREATE TABLE `sys_menu` (
                            `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                            `menu_name` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '菜单名',
                            `path` VARCHAR(200) DEFAULT NULL COMMENT '路由地址',
                            `component` VARCHAR(255) DEFAULT NULL COMMENT '组件路径',
                            `visible` CHAR(1) DEFAULT '0' COMMENT '菜单状态 (0显示 1隐藏)',
                            `status` CHAR(1) DEFAULT '0' COMMENT '菜单状态 (0正常 1停用)',
                            `perms` VARCHAR(100) DEFAULT NULL COMMENT '权限标识',
                            `icon` VARCHAR(100) DEFAULT '#' COMMENT '菜单图标',
                            `create_by` BIGINT(20) DEFAULT NULL,
                            `create_time` DATETIME DEFAULT NULL,
                            `update_by` BIGINT(20) DEFAULT NULL,
                            `update_time` DATETIME DEFAULT NULL,
                            `del_flag` INT(11) DEFAULT '0' COMMENT '是否删除 (0未删除 1已删除)',
                            `remark` VARCHAR(500) DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';


CREATE TABLE `sys_role` (
                            `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(128) DEFAULT NULL,
                            `role_key` VARCHAR(100) DEFAULT NULL COMMENT '角色权限字符串',
                            `status` CHAR(1) DEFAULT '0' COMMENT '角色状态 (0正常 1停用)',
                            `del_flag` INT(1) DEFAULT '0' COMMENT 'del_flag',
                            `create_by` BIGINT(200) DEFAULT NULL,
                            `create_time` DATETIME DEFAULT NULL,
                            `update_by` BIGINT(200) DEFAULT NULL,
                            `update_time` DATETIME DEFAULT NULL,
                            `remark` VARCHAR(500) DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';


CREATE TABLE `sys_role_menu` (
                                 `role_id` BIGINT(200) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                                 `menu_id` BIGINT(200) NOT NULL DEFAULT '0' COMMENT '菜单id',
                                 PRIMARY KEY (`role_id`, `menu_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关系表';

CREATE TABLE `sys_user_role` (
                                 `user_id` BIGINT(200) NOT NULL AUTO_INCREMENT COMMENT '用户id',
                                 `role_id` BIGINT(200) NOT NULL DEFAULT '0' COMMENT '角色id',
                                 PRIMARY KEY (`user_id`, `role_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关系表';
