/*
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here
package com.example.todo.model;

import javax.persistence.*;

@Entity
@Table(name = "todolist")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "todo")
    private String todo;

    @Column(name = "status")
    private String status;

    @Column(name = "priority")
    private String priority;

    public Todo() {
    }

    public Todo(int id, String todo, String status, String priority) {
        this.id = id;
        this.todo = todo;
        this.status = status;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}