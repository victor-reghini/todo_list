package br.com.victor.todolist.repository;

import br.com.victor.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
