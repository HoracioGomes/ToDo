package com.example.todo.services;

import com.example.todo.domain.Todo;
import com.example.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBServices {

    @Autowired
    TodoRepository todoRepository;

    public void intantiateWithExample() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Todo t1 = new Todo(null, "Reskilling", "Realizar 3 horas", sdf.parse("18/04/2023"), false);
        Todo t2 = new Todo(null, "Reskilling", "Realizar 1 horas", sdf.parse("19/04/2023"), false);
        Todo t3 = new Todo(null, "Reskilling", "Realizar 4 horas", sdf.parse("20/04/2023"), false);
        Todo t4 = new Todo(null, "Reskilling", "Realizar 3 horas", sdf.parse("21/04/2023"), true);
        Todo t5 = new Todo(null, "Reskilling", "Realizar 9 horas", sdf.parse("22/04/2023"), true);
        Todo t6 = new Todo(null, "Reskilling", "Realizar 8 horas", sdf.parse("23/04/2023"), true);
        todoRepository.saveAll(Arrays.asList(t1,t2, t3, t4, t5, t6));
    }

}
