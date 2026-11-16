package com.programacion.distribuida.books.dtos;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for {@link com.programacion.distribuida.books.db.Book}
 */
@Getter
@Setter
@ToString
@Builder
public class BookDto implements Serializable {
    private String isbn;
    private String title;
    private BigDecimal price;

    //Version aplanada del inventario
    private Integer inventorySold;
    private Integer inventorySupplied;

    private List<AuthorDto> authors;
}