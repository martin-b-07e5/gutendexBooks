package com.example.gutendexBooks.main;

import com.example.gutendexBooks.service.ConsumoAPI;

import java.util.Scanner;

public class Main {

  // Method
  public void muestraElMenu() {

    Scanner scanner = new Scanner(System.in);
    ConsumoAPI consumoAPI = new ConsumoAPI();
    String URL_BASE = "https://gutendex.com/books/";

    // Implementación del menú de opciones
    System.out.println("Bienvenido a Gutendex Books!");
    System.out.println("1. Buscar libros por título");
//    System.out.println("2. Buscar libros por autor");
//    System.out.println("3. Salir");
//    System.out.print("Elija una opción: ");


    System.out.print("Ingrese el título del libro: ");
    String bookTitle = scanner.next();

    // Implementación de la búsqueda de libros por título
    System.out.println("1. Título del libro: " + bookTitle);
    var json = consumoAPI.obtenerDatos(URL_BASE + "2641/");
//    System.out.println("JSON: " + json);


  }
}
