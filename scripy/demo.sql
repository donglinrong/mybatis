CREATE TABLE sys_user
(
  id             bigint not null auto_increment comment '用户ID',
  user_name      VARCHAR(50) COMMENT '用户名',
  user_password  VARCHAR(50) COMMENT '用户密码',
  user_email     VARCHAR(50) COMMENT '邮箱',
  user_info      TEXT COMMENT '简介',
  head_img       BLOB COMMENT '头像',
  create_time    DATETIME COMMENT '创建时间',
  PRIMARY KEY (id)
);

CREATE TABLE sys_role
(
  id            BIGINT not null AUTO_INCREMENT COMMENT '角色ID',
  role_name     VARCHAR(50) COMMENT '角色',
  enabled       int COMMENT '有效标志',
  create_by     BIGINT COMMENT '创建人',
  create_time   DATETIME COMMENT '创建时间',
  PRIMARY KEY (id)
);

CREATE TABLE sys_privilege
(
  id                BIGINT NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  privilege_name    VARCHAR(50) COMMENT '权限名称',
  privilege_url     VARCHAR(200) COMMENT '权限URL',
  PRIMARY KEY (id)
);

CREATE TABLE sys_user_role
(
  user_id           BIGINT COMMENT '用户ID',
  role_id           BIGINT COMMENT '角色ID'
);

CREATE TABLE sys_role_privilege
(
  role_id           BIGINT COMMENT '角色ID',
  privilege         BIGINT COMMENT '权限ID'
);
