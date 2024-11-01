package com.example.gutendexBooks.util;

import com.example.gutendexBooks.service.ConsumoAPI;

import java.util.Scanner;

public class BuscarPorTitulo {

  public static void buscarPorTitulo(Scanner scanner, ConsumoAPI consumoAPI, String urlBase) {
    System.out.print("Ingrese el título del libro: ");
    String bookTitle = scanner.nextLine();
    bookTitle = bookTitle.replace(" ", "+");
    System.out.println("1. Título del libro: " + bookTitle);
    var json = consumoAPI.obtenerDatos(urlBase + bookTitle);
    System.out.println("JSON: " + json);
  }

}
