CREATE TABLE public.inventory (
                                  sold integer NOT NULL,
                                  supplied integer NOT NULL,
                                  version integer NOT NULL,
                                  book_isbn varchar(255) NOT NULL
);

INSERT INTO public.inventory (sold, supplied, version, book_isbn) OVERRIDING SYSTEM VALUE
VALUES (10, 50, 1, '978-0134686097');