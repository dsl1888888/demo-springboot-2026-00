package com.example.clickhouse.controller;

import com.example.clickhouse.UserLog;
import com.example.clickhouse.repository.UserLogRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserLogController {

    private final UserLogRepository repo;

    public UserLogController(UserLogRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/init")
    public String init() {
        List<UserLog> list = new ArrayList<>();
        long baseId = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            list.add(new UserLog(
                baseId + i,
                UUID.randomUUID().toString() + "_" + i,
                    i,
                    LocalDateTime.now().withNano(0)
            ));
        }

        repo.batchInsert(list);
        return "Inserted 100 records";
    }

    @PostMapping
    public String create(@RequestBody UserLog user) {
        List<UserLog> list = new ArrayList<>();
        long baseId = System.currentTimeMillis();

//        for (int i = 0; i < 100; i++) {
//            list.add(new UserLog(
//                    baseId + i,
//                    user.getUsername() + "_" + i,
//                    user.getAge(),
//                    LocalDateTime.now()
//            ));
//        }
        list.add(new UserLog(
                baseId+user.getId(),
                user.getUsername(),
                user.getAge(),
                LocalDateTime.now().withNano(0)
        ));
        repo.batchInsert(list);
        return "Inserted 100 records";
    }

    @GetMapping
    public List<UserLog> list() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestParam Integer age) {
        repo.updateAge(id, age);
        return "Update submitted";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Delete submitted";
    }
}
