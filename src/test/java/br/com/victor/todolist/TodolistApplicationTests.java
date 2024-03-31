package br.com.victor.todolist;

import br.com.victor.todolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void test_create_todo_success() {
		var todo = new Todo("Todo test", "desc todo test", false, 1);


		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].name").isEqualTo("Todo test")
				.jsonPath("$[0].description").isEqualTo("desc todo test")
				.jsonPath("$[0].done").isEqualTo(false)
				.jsonPath("$[0].priority").isEqualTo(1);
	}

	@Test
	void test_create_todo_error() {
		var todo = new Todo("", "", false, 1);


		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isBadRequest()
		;
	}
}
