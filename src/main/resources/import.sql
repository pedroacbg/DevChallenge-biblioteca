INSERT INTO tb_author (name) VALUES ('JK Rowling');
INSERT INTO tb_author (name) VALUES ('J. R. R. Tolkien');

INSERT INTO tb_library (title, publisher, img_Url) VALUES ('Harry Potter', 'Rocco', 'https://i.imgur.com/UH3IPXw.jpg');
INSERT INTO tb_library (title, publisher, img_Url) VALUES ('Senhor dos Aneis', 'Allen & Unwin', 'https://images-na.ssl-images-amazon.com/images/I/71ZLavBjpRL.jpg');

INSERT INTO tb_library_authors (library_id, authors_id) VALUES (1, 1);
INSERT INTO tb_library_authors (library_id, authors_id) VALUES (2, 2);
