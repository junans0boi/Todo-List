package com.hollywood.planary.controller;

import com.hollywood.planary.entity.Todo;
import com.hollywood.planary.entity.User;
import com.hollywood.planary.service.TodoService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService svc;

    public TodoController(TodoService svc) {
        this.svc = svc;
    }

    @GetMapping
    public List<Todo> list(@RequestParam Long userId,
            @RequestParam(required = false) String date) {
        if (date == null) {
            return svc.findByUser(userId);
        }
        LocalDate d = LocalDate.parse(date);
        LocalDateTime start = d.atStartOfDay();
        LocalDateTime end = d.atTime(LocalTime.MAX);
        return svc.findByUserAndDay(userId, start, end);
    }

    @PostMapping
    public Todo create(@RequestBody Todo td) {
        return svc.create(td);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id,
            @RequestBody Todo dto) {
        return ResponseEntity.ok(svc.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}