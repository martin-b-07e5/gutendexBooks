package com.example.gutendexBooks.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
    @JsonAlias("title") String title,
    @JsonAlias("authors") List<Person> authors,
    @JsonAlias("languages") List<String> languages,
    @JsonAlias("download_count") int download_count
) {
}
