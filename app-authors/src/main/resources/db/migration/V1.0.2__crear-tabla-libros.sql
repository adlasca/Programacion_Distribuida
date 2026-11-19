CREATE TABLE public.books (
                              price numeric(8,2) NOT NULL,
                              version integer NOT NULL,
                              isbn varchar(255) NOT NULL,
                              title varchar(255)
);

INSERT INTO public.books (price, version, isbn, title) OVERRIDING SYSTEM VALUE
VALUES (40.00, 1, '978-0596009205', 'Head First Java');

INSERT INTO public.books (price, version, isbn, title) OVERRIDING SYSTEM VALUE
VALUES (55.00, 1, '978-0321349606', 'Java Concurrency in Practice');

INSERT INTO public.books (price, version, isbn, title) OVERRIDING SYSTEM VALUE
VALUES (50.00, 1, '978-0136083238', 'Clean Code: A Handbook of Agile Software Craftsmanship');

INSERT INTO public.books (price, version, isbn, title) OVERRIDING SYSTEM VALUE
VALUES (45.00, 1, '978-0134686097', 'Effective Java');

INSERT INTO public.books (price, version, isbn, title) OVERRIDING SYSTEM VALUE
VALUES (50.00, 1, '978-1260440232', 'Java: The Complete Reference');