package com.example.todo.services;

import com.example.todo.domain.Todo;
import com.example.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBServices {

    @Autowired
    TodoRepository todoRepository;

    public void intantiateWithExample() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Todo t1 = new Todo(null, "Reskilling", "Realizar 3 horas", LocalDateTime.parse("18/04/2023 07:00", dtf), false);
        Todo t2 = new Todo(null, "Reskilling", "Realizar 1 horas", LocalDateTime.parse("19/04/2023 07:00", dtf), false);
        Todo t3 = new Todo(null, "Reskilling", "Realizar 4 horas", LocalDateTime.parse("20/04/2023 07:00", dtf), false);
        Todo t4 = new Todo(null, "Reskilling", "Realizar 3 horas", LocalDateTime.parse("21/04/2023 07:00", dtf), true);
        Todo t5 = new Todo(null, "Reskilling", "Realizar 9 horas", LocalDateTime.parse("22/04/2023 07:00", dtf), true);
        Todo t6 = new Todo(null, "Reskilling", "Realizar 8 horas", LocalDateTime.parse("23/04/2023 07:00", dtf), true);
        todoRepository.saveAll(Arrays.asList(t1,t2, t3, t4, t5, t6));
    }

}
