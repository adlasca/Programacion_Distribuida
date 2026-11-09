package com.programacion.distribuida.web;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {
    private String title;
    private  String isbn;
}
