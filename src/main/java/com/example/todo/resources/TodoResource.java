package com.example.todo.resources;

import com.example.todo.domain.Todo;
import com.example.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "todo")
public class TodoResource {
    @Autowired
    TodoService todoService;

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(todoService.findById(id));
    }

    @GetMapping("/open")
    public ResponseEntity<List<Todo>> findAllOpen() {
        return ResponseEntity.ok().body(todoService.findAllOpen());
    }

    @GetMapping("/closed")
    public ResponseEntity<List<Todo>> findAllClosed() {
        return ResponseEntity.ok().body(todoService.findAllClosed());
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok().body(todoService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok().body(todoService.saveTodo(todo));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(todoService.deleteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateById(@PathVariable Integer id, @RequestBody Todo updatedTodo) {
        Todo newTodo = todoService.updateById(id, updatedTodo);
        return ResponseEntity.ok(newTodo);
    }

}
