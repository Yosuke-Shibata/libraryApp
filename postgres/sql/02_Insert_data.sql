INSERT INTO library_app_schema.author
    (name)
VALUES
    ('作家い'),
    ('作家ろ'),
    ('作家は');

INSERT INTO library_app_schema.book
    (title)
VALUES
    ('本A'),
    ('本B'),
    ('本C');

INSERT INTO library_app_schema.work
    (book_id, author_id)
VALUES
    (1, 1),
    (2, 2),
    (2, 3),
    (3, 3);