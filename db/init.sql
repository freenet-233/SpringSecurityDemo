-- 用户表 sys_user
CREATE TABLE sys_user (
                          id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                          user_name VARCHAR(64) NOT NULL DEFAULT 'NULL'::VARCHAR,
                          nick_name VARCHAR(64) NOT NULL DEFAULT 'NULL'::VARCHAR,
                          password VARCHAR(64) NOT NULL DEFAULT 'NULL'::VARCHAR,
                          status CHAR(1) DEFAULT '0',
                          email VARCHAR(64),
                          phone_number VARCHAR(32),
                          sex CHAR(1),
                          avatar VARCHAR(128),
                          user_type CHAR(1) NOT NULL DEFAULT '1',
                          create_by BIGINT,
                          create_time TIMESTAMP WITHOUT TIME ZONE,
                          update_by BIGINT,
                          update_time TIMESTAMP WITHOUT TIME ZONE,
                          deleted INTEGER DEFAULT 0
);

COMMENT ON TABLE sys_user IS '用户表';
COMMENT ON COLUMN sys_user.id IS '主键';
COMMENT ON COLUMN sys_user.user_name IS '用户名';
COMMENT ON COLUMN sys_user.nick_name IS '昵称';
COMMENT ON COLUMN sys_user.password IS '密码';
COMMENT ON COLUMN sys_user.status IS '账号状态（0正常 1停用）';
COMMENT ON COLUMN sys_user.email IS '邮箱';
COMMENT ON COLUMN sys_user.phone_number IS '手机号';
COMMENT ON COLUMN sys_user.sex IS '用户性别（0男，1女，2未知）';
COMMENT ON COLUMN sys_user.avatar IS '头像';
COMMENT ON COLUMN sys_user.user_type IS '用户类型（0管理员，1普通用户）';
COMMENT ON COLUMN sys_user.create_by IS '创建人的用户id';
COMMENT ON COLUMN sys_user.create_time IS '创建时间';
COMMENT ON COLUMN sys_user.update_by IS '更新人';
COMMENT ON COLUMN sys_user.update_time IS '更新时间';
COMMENT ON COLUMN sys_user.deleted IS '删除标志（0代表未删除，1代表已删除）';


-- 菜单表 sys_menu
CREATE TABLE sys_menu (
                          id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                          menu_name VARCHAR(64) NOT NULL DEFAULT 'NULL'::VARCHAR,
                          path VARCHAR(200),
                          component VARCHAR(255),
                          visible CHAR(1) DEFAULT '0',
                          status CHAR(1) DEFAULT '0',
                          perms VARCHAR(100),
                          icon VARCHAR(100) DEFAULT '#'::VARCHAR,
                          create_by BIGINT,
                          create_time TIMESTAMP WITHOUT TIME ZONE,
                          update_by BIGINT,
                          update_time TIMESTAMP WITHOUT TIME ZONE,
                          del_flag INTEGER DEFAULT 0,
                          remark VARCHAR(500)
);

COMMENT ON TABLE sys_menu IS '菜单表';
COMMENT ON COLUMN sys_menu.menu_name IS '菜单名';
COMMENT ON COLUMN sys_menu.path IS '路由地址';
COMMENT ON COLUMN sys_menu.component IS '组件路径';
COMMENT ON COLUMN sys_menu.visible IS '菜单状态 (0显示 1隐藏)';
COMMENT ON COLUMN sys_menu.status IS '菜单状态 (0正常 1停用)';
COMMENT ON COLUMN sys_menu.perms IS '权限标识';
COMMENT ON COLUMN sys_menu.icon IS '菜单图标';
COMMENT ON COLUMN sys_menu.create_by IS '创建人';
COMMENT ON COLUMN sys_menu.create_time IS '创建时间';
COMMENT ON COLUMN sys_menu.update_by IS '更新人';
COMMENT ON COLUMN sys_menu.update_time IS '更新时间';
COMMENT ON COLUMN sys_menu.del_flag IS '是否删除 (0未删除 1已删除)';
COMMENT ON COLUMN sys_menu.remark IS '备注';


-- 角色表 sys_role
CREATE TABLE sys_role (
                          id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                          name VARCHAR(128),
                          role_key VARCHAR(100),
                          status CHAR(1) DEFAULT '0',
                          del_flag INTEGER DEFAULT 0,
                          create_by BIGINT,
                          create_time TIMESTAMP WITHOUT TIME ZONE,
                          update_by BIGINT,
                          update_time TIMESTAMP WITHOUT TIME ZONE,
                          remark VARCHAR(500)
);

COMMENT ON TABLE sys_role IS '角色表';
COMMENT ON COLUMN sys_role.name IS '角色名称';
COMMENT ON COLUMN sys_role.role_key IS '角色权限字符串';
COMMENT ON COLUMN sys_role.status IS '角色状态 (0正常 1停用)';
COMMENT ON COLUMN sys_role.del_flag IS '是否删除 (0未删除 1已删除)';
COMMENT ON COLUMN sys_role.create_by IS '创建人';
COMMENT ON COLUMN sys_role.create_time IS '创建时间';
COMMENT ON COLUMN sys_role.update_by IS '更新人';
COMMENT ON COLUMN sys_role.update_time IS '更新时间';
COMMENT ON COLUMN sys_role.remark IS '备注';


-- 角色菜单关系表 sys_role_menu
CREATE TABLE sys_role_menu (
                               role_id BIGINT NOT NULL,
                               menu_id BIGINT NOT NULL,
                               PRIMARY KEY (role_id, menu_id)
);

COMMENT ON TABLE sys_role_menu IS '角色菜单关系表';
COMMENT ON COLUMN sys_role_menu.role_id IS '角色ID';
COMMENT ON COLUMN sys_role_menu.menu_id IS '菜单id';


-- 用户角色关系表 sys_user_role
CREATE TABLE sys_user_role (
                               user_id BIGINT NOT NULL,
                               role_id BIGINT NOT NULL,
                               PRIMARY KEY (user_id, role_id)
);

COMMENT ON TABLE sys_user_role IS '用户角色关系表';
COMMENT ON COLUMN sys_user_role.user_id IS '用户ID';
COMMENT ON COLUMN sys_user_role.role_id IS '角色ID';