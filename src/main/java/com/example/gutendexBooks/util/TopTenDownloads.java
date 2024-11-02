package com.example.gutendexBooks.util;

import com.example.gutendexBooks.model.DatosLibros;

import java.util.Comparator;
import java.util.List;

public class TopTenDownloads {

  public static void mostrarTop10LibrosMasDescargados(List<DatosLibros> libros) {

    // Top 10 libros más descargados
    System.out.println("Top 10 libros más descargados");
//    datos.results().stream()
    libros.stream()
        .sorted(Comparator
            .comparing(DatosLibros::download_count)
            .reversed())
        .limit(10)
//        .peek(System.out::println)  // imprime la primer parte unformatted
        .map(datosLibros -> String.format("Title: %s, Author: %s, Birth_year; %d, Language: %s, Downloads: %f",
                datosLibros.title(),
                datosLibros.authors().getFirst().getName(),
                datosLibros.authors().getFirst().getBirth_year(),
                datosLibros.languages().getFirst().toUpperCase(),
                datosLibros.download_count()
            )
        )

        .forEach(System.out::println);

  }
}
