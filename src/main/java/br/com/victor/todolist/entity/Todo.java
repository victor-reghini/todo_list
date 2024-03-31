package br.com.victor.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private boolean done;
    private int priority;

    public Todo(){}

    public Todo(String name, String description, boolean done, int priority){
        this.name = name;
        this.description = description;
        this.done = done;
        this.priority = priority;
    }
}
