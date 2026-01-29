show databases ;

use demo;
show tables ;


select  * from user;
select  * from userlog;


TRUNCATE TABLE user;
TRUNCATE TABLE userlog;

-- 删除当前数据库中的表
DROP TABLE user;
DROP TABLE userlog;
-- 安全删除（如果表不存在也不会报错）
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS userlog;

CREATE DATABASE IF NOT EXISTS demo;

-- user 表
CREATE TABLE user (
                      id UInt64,
                      name String,
    -- 其他字段...
                      INDEX id_idx (id) TYPE minmax GRANULARITY 1
) ENGINE = MergeTree()
      ORDER BY id;

-- userlog 表（建议按时间分区）
CREATE TABLE userlog (
                         user_id UInt64,
                         login_time DateTime,
    -- 其他日志字段...
                         INDEX user_id_idx (user_id) TYPE bloom_filter GRANULARITY 1
) ENGINE = MergeTree()
      PARTITION BY toYYYYMM(login_time)
      ORDER BY (login_time, user_id);

-- 插入用户数据
INSERT INTO user (id, name) VALUES
                                (1, '张三'),
                                (2, '李四'),
                                (3, '王五'),
                                (4, '赵六'),
                                (5, '钱七'),
                                (6, '孙八'),
                                (7, '周九'),
                                (8, '吴十'),
                                (9, '郑十一'),
                                (10, '王十二');


-- 插入用户登录日志（多天数据）
INSERT INTO userlog (user_id, login_time) VALUES
                                              (1, '2024-01-15 09:15:30'),
                                              (1, '2024-01-16 08:45:20'),
                                              (1, '2024-01-17 10:30:45'),
                                              (1, '2024-01-18 14:20:10'),
                                              (1, '2024-01-19 09:05:55'),
                                              (2, '2024-01-15 10:20:15'),
                                              (2, '2024-01-16 11:35:40'),
                                              (2, '2024-01-18 16:45:30'),
                                              (2, '2024-01-20 08:30:25'),
                                              (3, '2024-01-16 13:40:50'),
                                              (3, '2024-01-17 15:25:35'),
                                              (3, '2024-01-19 10:10:10'),
                                              (4, '2024-01-15 17:30:45'),
                                              (4, '2024-01-18 09:45:20'),
                                              (5, '2024-01-16 12:15:30'),
                                              (6, '2024-01-15 08:20:15'),
                                              (6, '2024-01-17 09:30:45'),
                                              (6, '2024-01-19 14:40:25'),
                                              (6, '2024-01-20 16:50:35'),
                                              (7, '2024-01-16 10:45:20'),
                                              (7, '2024-01-18 13:30:15'),
                                              (7, '2024-01-20 11:25:40');

-- 用户8-10没有登录记录
-- 用于测试LEFT JOIN的场景




-- 测试关联查询
SELECT
    u.id,
    u.name,
    ul.login_time
FROM user u
         JOIN userlog ul ON u.id = ul.user_id
ORDER BY ul.login_time DESC
LIMIT 10;

-- 统计每个用户的登录次数
SELECT
    u.id,
    u.name,
    COUNT(ul.user_id) as login_count
FROM user u
         LEFT JOIN userlog ul ON u.id = ul.user_id
GROUP BY u.id, u.name
ORDER BY login_count DESC;

