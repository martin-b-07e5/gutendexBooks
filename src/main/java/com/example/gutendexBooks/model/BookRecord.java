package com.example.gutendexBooks.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookRecord(
    @JsonAlias("id") Integer id,
    @JsonAlias("title") String title,
    @JsonAlias("authors") List<Person> authors,
    @JsonAlias("translators") List<Person> translators,
    @JsonAlias("languages") List<String> languages,
    @JsonAlias("copyright") Boolean copyright,
    @JsonAlias("media_type") String media_type,
    @JsonAlias("download_count") int download_count
) {
}
