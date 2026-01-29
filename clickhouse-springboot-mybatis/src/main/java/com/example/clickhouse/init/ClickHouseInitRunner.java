
package com.example.clickhouse.init;

import org.springframework.boot.CommandLineRunner;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

@Component
public class ClickHouseInitRunner implements CommandLineRunner {

    private final SqlSessionFactory factory;

    public ClickHouseInitRunner(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run(String... args) throws Exception {
        factory.openSession().update("init.createTable");
    }
}
