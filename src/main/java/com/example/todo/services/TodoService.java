package com.example.todo.services;

import com.example.todo.domain.Todo;
import com.example.todo.repositories.TodoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public Todo findById(Integer id) {
        Optional<Todo> obj = todoRepository.findById(id);
        return obj.orElse(null);
    }

    public List<Todo> findAllOpen() {
        List<Todo> list = todoRepository.findAllOpen();
        return list;
    }

    public List<Todo> findAllClosed() {
        List<Todo> list = todoRepository.findAllClosed();
        return list;
    }

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    public Todo saveTodo(Todo todo){
        todo.setId(null);
        return todoRepository.save(todo);
    }

    public Boolean deleteById(Integer id){
        todoRepository.deleteById(id);
        return true;
    }
}
