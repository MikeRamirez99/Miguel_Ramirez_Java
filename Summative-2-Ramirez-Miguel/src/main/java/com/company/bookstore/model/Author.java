package com.company.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="author")
public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer author_id;

    @NotNull
    private String first_name;

    @NotNull
    private String last_name;

    @NotNull
    private String street;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private String postal_code;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Set<Book> books;

    public Author() {
    }

    public Author(Integer author_id, String first_name, String last_name, String street, String city, String state, String postal_code, String phone, String email) {
        this.author_id = author_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return author_id;
    }

    public void setId(Integer author_id) {
        this.author_id = author_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(getId(), author.getId()) && Objects.equals(getFirst_name(), author.getFirst_name()) && Objects.equals(getLast_name(), author.getLast_name()) && Objects.equals(getStreet(), author.getStreet()) && Objects.equals(getCity(), author.getCity()) && Objects.equals(getState(), author.getState()) && Objects.equals(getPostal_code(), author.getPostal_code()) && Objects.equals(getPhone(), author.getPhone()) && Objects.equals(getEmail(), author.getEmail()) && Objects.equals(getBooks(), author.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirst_name(), getLast_name(), getStreet(), getCity(), getState(), getPostal_code(), getPhone(), getEmail(), getBooks());
    }
}

//    create table if not exists author (
//        author_id int not null auto_increment primary key,
//        first_name varchar(50) not null,
//        last_name varchar(50) not null,
//        street varchar(50) not null,
//        city varchar(50) not null,
//        state char(2) not null,
//        postal_code varchar(25) not null,
//        phone varchar(15) not null,
//        email varchar(60) not null
//        );