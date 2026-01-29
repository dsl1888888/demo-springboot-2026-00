
package com.example.clickhouse.controller;

import com.example.clickhouse.UserLog;
import com.example.clickhouse.mapper.UserLogMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserLogController {

    private final UserLogMapper mapper;

    public UserLogController(UserLogMapper mapper) {
        this.mapper = mapper;
    }


    @PostMapping("/init")
    public String init() {

        List<UserLog> list = new ArrayList<>();
        long baseId = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            list.add(new UserLog(
                    baseId + i,
                    UUID.randomUUID().toString() + "_" + i,
                    i,
                    LocalDateTime.now().withNano(0)
            ));
        }

        mapper.batchInsert(list);
        return "Inserted 100 records";
    }

    @PostMapping
    public String create(@RequestBody UserLog user) {
        List<UserLog> list = new ArrayList<>();
        long baseId = System.currentTimeMillis();

//        for (int i = 0; i < 100; i++) {
//            list.add(new UserLog(
//                baseId + i,
//                user.getUsername() + "_" + i,
//                user.getAge(),
//                LocalDateTime.now()
//            ));
//        }

        list.add(new UserLog(
                baseId + user.getId(),
                user.getUsername() + "_" + user.getId(),
                user.getAge(),
                LocalDateTime.now().withNano(0)
        ));

        mapper.batchInsert(list);
        return "Inserted 100 records";
    }

    @GetMapping
    public List<UserLog> list() {
        return mapper.findAll();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestParam Integer age) {
        mapper.updateAge(id, age);
        return "Update submitted";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        mapper.deleteById(id);
        return "Delete submitted";
    }
}
