package com.example.gutendexBooks.main;

import com.example.gutendexBooks.model.Datos;
import com.example.gutendexBooks.service.ConsumoAPI;
import com.example.gutendexBooks.service.ConvierteDatos;
import com.example.gutendexBooks.util.BuscarPorTitulo;
import com.example.gutendexBooks.util.TopTenDownloads;

import java.util.Scanner;

public class Main {

  Scanner scanner = new Scanner(System.in);
  String URL_BASE = "https://gutendex.com/books/";
  String URL_SEARCH = "http://gutendex.com/books/?search=";

  ConsumoAPI consumoAPI = new ConsumoAPI();
  ConvierteDatos conversor = new ConvierteDatos();
  Datos datos;

  // Method
  public void muestraElMenu() {

    int option = 0;
    while (option != 3) {
      System.out.println("\nBienvenido a Gutendex Books!");
      System.out.println("1. Buscar libros por título");
      System.out.println("2. Top 10 libros más descargados");
      System.out.println("3. Salir");
      System.out.print("Elija una opción: ");

      try {
        option = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("---Opción inválida. Elija una opción válida.---\n");
        continue;
      }

      switch (option) {
        case 1:
          // 1. Buscar libros por título
          BuscarPorTitulo.buscarPorTitulo(scanner, consumoAPI, URL_SEARCH, conversor);
          break;
        case 2:
//          2. Top 10 libros más descargados
          System.out.println("------------------------------");
          var json = consumoAPI.obtenerDatos(URL_BASE);
          System.out.println("json = " + json);

          datos = conversor.obtenerDatosx(json, Datos.class);
          System.out.println("\ndatos = " + datos);
          System.out.println("------------------------------");
          TopTenDownloads.mostrarTop10LibrosMasDescargados(datos.results());
          break;
        case 3:
          System.out.println("Gracias por usar Gutendex Books!");
          break;
        default:
          System.out.println("***OPCIÓN INVÁLIDA. Por favor, elija una opción válida.***");
      }

    } // end while

    scanner.close(); // Close the scanner object

  } // end muestraElMenu

}



