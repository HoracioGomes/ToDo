package com.example.todo.services;

import com.example.todo.domain.Todo;
import com.example.todo.repositories.TodoRepository;
import com.example.todo.services.exceptions.ObjectNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public Todo findById(Integer id) {
        Optional<Todo> obj = todoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<Todo> findAllOpen() {
        List<Todo> list = todoRepository.findAllOpen();
        return list;
    }

    public List<Todo> findAllClosed() {
        List<Todo> list = todoRepository.findAllClosed();
        return list;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo saveTodo(Todo todo) {
        todo.setId(null);
        return todoRepository.save(todo);
    }

    public Boolean deleteById(Integer id) {
        todoRepository.deleteById(id);
        return true;
    }

    @PutMapping("/{id}")
    public Todo updateById(Integer id, Todo updatedTodo) {
        Todo oldTodo = findById(id);
        oldTodo.setTitulo(updatedTodo.getTitulo());
        oldTodo.setDescricao(updatedTodo.getDescricao());
        oldTodo.setDataParaFinalizar(updatedTodo.getDataParaFinalizar());
        oldTodo.setFinalizado(updatedTodo.getFinalizado());
        return todoRepository.save(oldTodo);
    }
}
