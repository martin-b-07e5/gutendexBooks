package com.example.gutendexBooks.main;

import com.example.gutendexBooks.service.ConsumoAPI;

import java.util.Scanner;

public class Main {

  // Method
  public void muestraElMenu() {

    Scanner scanner = new Scanner(System.in);
    ConsumoAPI consumoAPI = new ConsumoAPI();
//    String URL_BASE = "https://gutendex.com/books/";

    /*search
    Use this to search author names and book titles with given words.
     They must be separated by a space (i.e. %20 in URL-encoded format) and are case-insensitive.
      For example, /books?search=dickens%20great includes Great Expectations by Charles Dickens.*/
    String URL_BASE = "http://gutendex.com/books/?search=";

    // Implementación del menú de opciones
    System.out.println("Bienvenido a Gutendex Books!");
    System.out.println("1. Buscar libros por título");
//    System.out.println("2. Buscar libros por autor");
//    System.out.println("3. Salir");
//    System.out.print("Elija una opción: ");


    System.out.print("Ingrese el título del libro: ");
    String bookTitle = scanner.nextLine();
    bookTitle = bookTitle.replace(" ", "+");
    System.out.println("1. Título del libro: " + bookTitle);
//    quijote, The Great Gatsby, Great Expectations
    var json = consumoAPI.obtenerDatos(URL_BASE + bookTitle);
    System.out.println("JSON: " + json);


  }
}
