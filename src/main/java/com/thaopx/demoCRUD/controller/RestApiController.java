package com.thaopx.demoCRUD.controller;

import com.thaopx.demoCRUD.models.Todo;
import com.thaopx.demoCRUD.models.TodoException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {
    private List<TodoException> todoList;
    @PostConstruct
    public void init() {
        todoList = IntStream.range(0, 10)
                .mapToObj(i -> new TodoException("title-" + i, "detail-" + i))
                .collect(Collectors.toList());
    }
    @GetMapping("/todo/{todoId}")
    public TodoException getTodo(@PathVariable(name = "todoId") Integer todoId) {
        return todoList.get(todoId);
    }
}
