package com.example.clickhouse.repository;

import com.example.clickhouse.UserLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserLogRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserLogRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<UserLog> users) {
        jdbcTemplate.batchUpdate(
            "INSERT INTO user_log (id, username, age, created_at) VALUES (?, ?, ?, ?)",
            users,
            100,
            (ps, u) -> {
                ps.setLong(1, u.getId());
                ps.setString(2, u.getUsername());
                ps.setInt(3, u.getAge());
                ps.setTimestamp(4, Timestamp.valueOf(u.getCreatedAt()));
            }
        );
    }

    public List<UserLog> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM user_log",
            (rs, i) -> new UserLog(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getInt("age"),
                rs.getTimestamp("created_at").toLocalDateTime()
            )
        );
    }

    public void updateAge(Long id, Integer age) {
        jdbcTemplate.execute(
            "ALTER TABLE user_log UPDATE age = " + age + " WHERE id = " + id
        );
    }

    public void deleteById(Long id) {
        jdbcTemplate.execute(
            "ALTER TABLE user_log DELETE WHERE id = " + id
        );
    }
}
