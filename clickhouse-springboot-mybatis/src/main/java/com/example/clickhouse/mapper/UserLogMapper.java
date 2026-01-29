
package com.example.clickhouse.mapper;

import com.example.clickhouse.UserLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserLogMapper {

    void batchInsert(@Param("list") List<UserLog> list);

    List<UserLog> findAll();

    void updateAge(@Param("id") Long id, @Param("age") Integer age);

    void deleteById(@Param("id") Long id);
}
