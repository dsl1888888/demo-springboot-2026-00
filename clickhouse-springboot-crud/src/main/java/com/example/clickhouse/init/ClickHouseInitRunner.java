package com.example.clickhouse.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClickHouseInitRunner implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public ClickHouseInitRunner(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {

//        jdbcTemplate.execute("CREATE DATABASE IF NOT EXISTS demo");
//  should execute it on clickhouse web manage dashboard
        jdbcTemplate.execute(
                "CREATE TABLE IF NOT EXISTS demo.user_log (" +
                        "id UInt64, " +
                        "username String, " +
                        "age UInt8, " +
                        "created_at DateTime" +
                        ") ENGINE = MergeTree ORDER BY id"
        );
    }
}
