package com.example.gutendexBooks;

import com.example.gutendexBooks.main.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GutendexBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(GutendexBooksApplication.class, args);

		// Implementación del código para buscar libros por título (~ implements CommandLineRunner)
		Main app = new Main();
		app.muestraElMenu();
	}

}
