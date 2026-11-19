CREATE TABLE public.authors (
                                version integer NOT NULL,
                                id bigint NOT NULL,
                                name varchar(255)
);

CREATE TABLE public.books_authors (
                                      authors_id bigint NOT NULL,
                                      books_isbn varchar(255) NOT NULL
);

INSERT INTO public.authors (version, id, name) OVERRIDING SYSTEM VALUE

VALUES (1, 2, 'Herbert Schildt');

INSERT INTO public.authors (version, id, name) OVERRIDING SYSTEM VALUE

VALUES (1, 3, 'Kathy Sierra');

INSERT INTO public.authors (version, id, name) OVERRIDING SYSTEM VALUE

VALUES (1, 4, 'Brian Goetz');

INSERT INTO public.authors (version, id, name) OVERRIDING SYSTEM VALUE

VALUES (1, 5, 'Robert C. Martin');

INSERT INTO public.authors (version, id, name) OVERRIDING SYSTEM VALUE

VALUES (3, 1, 'Joshua Bloch');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE

VALUES (1, '978-0134686097');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE

VALUES (2, '978-1260440232');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE

VALUES (3, '978-0596009205');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE

VALUES (4, '978-0321349606');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE

VALUES (5, '978-0136083238');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE

VALUES (5, '978-0134686097');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE

VALUES (1, '978-1260440232');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE

VALUES (2, '978-0596009205');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE

VALUES (3, '978-0321349606');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE

VALUES (4, '978-0136083238');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE

VALUES (1, '978-0136083238');

INSERT INTO public.books_authors (authors_id, books_isbn) OVERRIDING SYSTEM VALUE

VALUES (2, '978-0136083238');

