package com.funroom.coach.pa.service;



import com.funroom.coach.pa.model.Todo;
import java.util.List;

public interface TodoService {
    Todo saveTodo(Todo todo);
    Todo getTodoById(Long id);
    List<Todo> getAllTodos();
    void deleteTodo(Long id);
}
