package br.com.victor.todolist.service;

import br.com.victor.todolist.entity.Todo;
import br.com.victor.todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    public List<Todo> create(Todo todo) {
        todoRepository.save(null);
        return list();
    }
    public List<Todo> list() {
        Sort.by("priority").descending().and(
                Sort.by("name").ascending()
        );
        return todoRepository.findAll();
    }
    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}
