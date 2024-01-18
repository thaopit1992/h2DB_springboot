package com.thaopx.demoCRUD.controller;

import com.thaopx.demoCRUD.models.Todo;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
* Tạo Restful API bằng Spring Boot
*/
@RestController
@RequestMapping("/api/v1")
public class TodoController {
//-------------------------------------------------------------------------------
    // Tạo DB list Job
//    private List<Todo> todoList todoList= new CopyOnWriteArrayList<>();
//    @PostConstruct
//    public void init(){
//        todoList.add(null);
//    }
//-------------------------------------------------------------------------------
    // Thêm 1 job mới
//    @PostMapping("/todo")
//    public ResponseEntity addTodo(@RequestBody Todo todo) {
//        todoList.add(todo);
//        return ResponseEntity.ok().body(todo);
//    }
//-------------------------------------------------------------------------------
    // Lấy tất cả các job
//    @GetMapping("/todo")
//    public List<Todo> getTodoList() {
//        return todoList;
//    }
//-------------------------------------------------------------------------------
    // Lấy job theo ID
//    @GetMapping("/todo/{todoId}")
//    public Todo getTodo(@PathVariable(name = "todoId") Integer todoId){
//        return todoList.get(todoId);
//    }
//-------------------------------------------------------------------------------
    // Sửa job theo id
//    @PutMapping("/todo/{todoId}")
//    public Todo editTodo(@PathVariable(name = "todoId") Integer todoId, @RequestBody Todo todo){
//        todoList.set(todoId, todo);
//        return todo;
//    }
//-------------------------------------------------------------------------------
        // Xóa job theo ID
//    @DeleteMapping("/todo/{todoId}")
//    public ResponseEntity deleteTodo(@PathVariable(name = "todoId") Integer todoId){
//        todoList.remove(todoId.intValue());
//        return ResponseEntity.ok().build();
//    }


}
