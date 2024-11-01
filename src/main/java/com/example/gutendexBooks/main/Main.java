package com.example.gutendexBooks.main;

import com.example.gutendexBooks.service.ConsumoAPI;
import com.example.gutendexBooks.util.BuscarPorTitulo;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {

  // Method
  public void muestraElMenu() {

    Scanner scanner = new Scanner(System.in);
    ConsumoAPI consumoAPI = new ConsumoAPI();
//    String URL_BASE = "https://gutendex.com/books/";
    String URL_SEARCH = "http://gutendex.com/books/?search=";
    /*search
    Use this to search author names and book titles with given words.
     They must be separated by a space (i.e. %20 in URL-encoded format) and are case-insensitive.
      For example, /books?search=dickens%20great includes Great Expectations by Charles Dickens.*/

    int option = 0;
    while (option != 3) {
      System.out.println("Bienvenido a Gutendex Books!");
      System.out.println("1. Buscar libros por título");
      System.out.println("2. top 10 libros más descargados");
      System.out.println("3. Salir");
      System.out.print("Elija una opción: ");

      try {
        option = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Opción inválida. Elija una opción válida.\n");
        continue;
      }

      switch (option) {
        case 1:
          BuscarPorTitulo.buscarPorTitulo(scanner, consumoAPI, URL_SEARCH);
          break;
        case 2:
//          2. top 10 libros más descargados
          break;
        case 3:
          System.out.println("Gracias por usar Gutendex Books!");
          break;
        default:
          System.out.println("Opción inválida. Por favor, elija una opción válida.");
      }


    }
  }


}
