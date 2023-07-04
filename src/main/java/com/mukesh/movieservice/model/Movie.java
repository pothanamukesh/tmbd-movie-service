package com.mukesh.movieservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String director;
    @ElementCollection
    private List<String> actors = new ArrayList<>();
}
