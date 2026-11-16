package com.programacion.distribuida.books.services.interfaces;

import com.programacion.distribuida.books.dtos.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<BookDto> findAll();

    public Optional<BookDto> findByIdOptional(String isbn);
}
