package com.example.demo;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> routes(PostHandler postController) {
		return RouterFunctions.route(GET("/posts"), postController::all)
				.andRoute(POST("/posts"), postController::create)
				.andRoute(GET("/posts/{id}"), postController::get)
				.andRoute(PUT("/posts/{id}"), postController::update)
				.andRoute(DELETE("/posts/{id}"), postController::delete);
	}
}

@Configuration
@EnableR2dbcRepositories
class ApplicationConfig extends AbstractR2dbcConfiguration {

	@Bean
	public ConnectionFactory connectionFactory() {
		return ConnectionFactories.get("r2dbc:h2:mem:///test?options=DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
	}
}

@Component
@Slf4j
class DataInitializer implements CommandLineRunner {

	@Autowired
	private PostRepository posts;

	@Override
	public void run(String[] args) {
		log.info("start data initialization  ...");
		this.posts
				.deleteAll()
				.thenMany(
						Flux.just("Post one", "Post two")
								.flatMap(
										title -> this.posts.save(Post.builder().title(title).content("content of " + title).build())
								)
				)
				.log()
				.subscribe(
						null,
						null,
						() -> log.info("done initialization...")
				);

	}
}

@Repository
interface PostRepository extends ReactiveCrudRepository<Post, Integer> {
}
