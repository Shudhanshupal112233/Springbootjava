package com.acciojob.librarymanagementsystemApril.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "author_info")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    private String authorName;

    private Integer age;

    private Integer noOfBooks;

    private Double ratings;

    private String emailId;

    @OneToMany(mappedBy = "author" ,cascade = CascadeType.ALL)
    private List<Book> listofbooks;


}
