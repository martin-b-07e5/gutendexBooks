package com.example.gutendexBooks.util;

import com.example.gutendexBooks.model.Datos;
import com.example.gutendexBooks.model.DatosLibros;
import com.example.gutendexBooks.model.Person;
import com.example.gutendexBooks.service.ConsumoAPI;
import com.example.gutendexBooks.service.ConvierteDatos;

import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BuscarPorTitulo {

  public static void buscarPorTitulo(Scanner scanner, ConsumoAPI consumoAPI, String urlSearch, ConvierteDatos conversor) {

    System.out.print("Ingrese el título del libro: ");
    var bookTitle = scanner.nextLine();
    String bookTitleFormatted = bookTitle.replace(" ", "+");
    System.out.println("\n1. String ingresado: " + bookTitle);

    var json = consumoAPI.obtenerDatos(urlSearch + bookTitle);
    System.out.println("JSON: " + json);

    // *** Convertir el JSON a un objeto de la clase DatosLibros
    Datos datosBusqueda = conversor.obtenerDatosx(json, Datos.class);
    System.out.println("\ndatosBusqueda: " + datosBusqueda);

    // *** Importante ***
    Optional<DatosLibros> libroBuscado = datosBusqueda.results().stream()
        .filter(libro -> libro.title().toLowerCase().contains(bookTitleFormatted.toLowerCase()))
        .findFirst();

    if (libroBuscado.isPresent()) {

      System.out.println("------------------------------------------------");
      System.out.println("Libro encontrado");
      System.out.println(libroBuscado.get());  // trae todos los datos del container
      System.out.println("------------------------------------------------");
      System.out.println("Book title: " + libroBuscado.get().title());
      System.out.println("----------");
      System.out.println("Authors: " + libroBuscado.get().authors().stream()
          .map(autor -> autor.getName())
          .collect(Collectors.joining(", "))
      );

      try {
        //      System.out.println("Birth year: " + libroBuscado.get().authors().stream().map(autor -> autor.getBirth_year()).findFirst()); // lambda
        System.out.println("Birth year: " + libroBuscado.get().authors().stream()
            .map(Person::getBirth_year)
            .findFirst()
            .orElse(0) // use orElse() to provide a default value if the Optional is empty.
        ); // method reference
      } catch (NullPointerException e) {
        System.out.println("Birth year: No birth date found");
      }

      try {
        System.out.println("Death year: " + libroBuscado.get().authors().stream()
                .map(autor -> autor.getDeath_year())
                .findFirst()
                .orElse(0) // findFirst() devuelve un objeto Optional, por lo que necesitas desencapsular el valor
            // antes de imprimirlo.
        ); // lambda
      } catch (NullPointerException e) {
        System.out.println("Death year: No death date found");
      }

      System.out.println("----------");
      System.out.println("Languages: " + libroBuscado.get().languages().stream().collect(Collectors.joining(", ")));
      System.out.println("Downloads: " + libroBuscado.get().download_count());
//      System.out.println("------------------------------------------------");
    } else {
      System.out.println("No se encontró el libro con el título ingresado");
    }

    // Trabajando con estadísticas
    DoubleSummaryStatistics statsByTeacher = datosBusqueda.results().stream()
        .filter(d -> d.download_count() > 0)
        .collect(Collectors.summarizingDouble(DatosLibros::download_count));
    System.out.println("\nEstadísticas de descargas: ");
    System.out.println("Mínimo: " + statsByTeacher.getMin());
    System.out.println("Máximo: " + statsByTeacher.getMax());
    System.out.printf("Promedio: %.2f%n", statsByTeacher.getAverage());

    DoubleSummaryStatistics stats = datosBusqueda.results().stream()
        .mapToDouble(DatosLibros::download_count)
        .summaryStatistics();
    System.out.println("\nEstadísticas de descargas:");
    System.out.printf("Mínimo: %.0f%n", stats.getMin());
    System.out.printf("Máximo: %.0f%n", stats.getMax());
    System.out.printf("Promedio: %.0f%n", stats.getAverage());
    System.out.printf("Cantidad de registros evaluados para calcular las estadísticas: %d%n", stats.getCount());

  } // end buscarPorTitulo
}
