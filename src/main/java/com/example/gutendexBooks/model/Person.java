package com.example.gutendexBooks.model;

public class Person {
  private String name;
  private Integer birth_year;
  private Integer death_year;

  // Constructors
  public Person() {
  }

  public Person(String name, Integer birth_year, Integer death_year) {
    this.name = name;
    this.birth_year = birth_year;
    this.death_year = death_year;
  }


  // Getters and setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getBirth_year() {
    return birth_year;
  }

  public void setBirth_year(Integer birth_year) {
    this.birth_year = birth_year;
  }

  public Integer getDeath_year() {
    return death_year;
  }

  public void setDeath_year(Integer death_year) {
    this.death_year = death_year;
  }


  // ToString
  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", birth_year=" + birth_year +
        ", death_year=" + death_year +
        '}';
  }


}
