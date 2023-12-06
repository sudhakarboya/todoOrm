/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TodoJpaService implements TodoRepository {
    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @Override
    public ArrayList<Todo> getTodos() {
        return (ArrayList<Todo>) todoJpaRepository.findAll();
    }

    @Override
    public Todo getTodoById(int id) {
        try {
            return todoJpaRepository.findById(id).get();

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Todo addTodo(Todo todo) {
        todoJpaRepository.save(todo);
        return todo;
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        try {
            Todo existTodo = todoJpaRepository.findById(id).get();
            if (todo.getTodo() != null) {
                existTodo.setTodo(todo.getTodo());
            }
            if (todo.getStatus() != null) {
                existTodo.setStatus(todo.getStatus());
            }
            if (todo.getPriority() != null) {
                existTodo.setPriority(todo.getPriority());
            }
            todoJpaRepository.save(existTodo);
            return existTodo;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id) {
        try {
            todoJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}