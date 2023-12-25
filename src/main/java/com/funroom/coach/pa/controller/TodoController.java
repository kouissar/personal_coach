package com.funroom.coach.pa.controller;



import com.funroom.coach.pa.model.Todo;
import com.funroom.coach.pa.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        return todo != null ? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.saveTodo(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Todo todo = todoService.getTodoById(id);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        todo.setTask(todoDetails.getTask());
        todo.setIsCompleted(todoDetails.getIsCompleted());
        final Todo updatedTodo = todoService.saveTodo(todo);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}

