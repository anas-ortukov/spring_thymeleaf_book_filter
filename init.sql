CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS author (
                                      id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                                      full_name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS genres (
                                      id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                                      name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS book (
                                    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                                    title VARCHAR,
                                    description VARCHAR,
                                    author_id UUID REFERENCES author(id),
                                    genre_id UUID REFERENCES genres(id)
);

INSERT INTO genres (name) VALUES
                              ('Fantasy'),
                              ('Science Fiction'),
                              ('Mystery'),
                              ('Romance');

-- Add authors
INSERT INTO author (full_name) VALUES
                                   ('J.K. Rowling'),
                                   ('George Orwell'),
                                   ('Agatha Christie'),
                                   ('Jane Austen'),
                                   ('Stephen King'),
                                   ('Ernest Hemingway'),
                                   ('Tolkien'),
                                   ('Fyodor Dostoevsky');

-- Add books
INSERT INTO book (title, description, author_id, genre_id) VALUES
    ('Harry Potter and the Philosopher''s Stone', 'First book in the Harry Potter series', (SELECT id FROM author WHERE full_name = 'J.K. Rowling'), (SELECT id FROM genres WHERE name = 'Fantasy')),
    ('1984', 'A dystopian novel', (SELECT id FROM author WHERE full_name = 'George Orwell'), (SELECT id FROM genres WHERE name = 'Science Fiction')),
    ('Murder on the Orient Express', 'A murder mystery novel', (SELECT id FROM author WHERE full_name = 'Agatha Christie'), (SELECT id FROM genres WHERE name = 'Mystery')),
    ('Pride and Prejudice', 'A romantic novel', (SELECT id FROM author WHERE full_name = 'Jane Austen'), (SELECT id FROM genres WHERE name = 'Romance')),
    ('The Shining', 'A horror novel', (SELECT id FROM author WHERE full_name = 'Stephen King'), (SELECT id FROM genres WHERE name = 'Fantasy')),
    ('The Old Man and the Sea', 'A novella by Ernest Hemingway', (SELECT id FROM author WHERE full_name = 'Ernest Hemingway'), (SELECT id FROM genres WHERE name = 'Adventure')),
    ('The Lord of the Rings', 'Epic high fantasy novel', (SELECT id FROM author WHERE full_name = 'Tolkien'), (SELECT id FROM genres WHERE name = 'Fantasy')),
    ('Crime and Punishment', 'A novel by Fyodor Dostoevsky', (SELECT id FROM author WHERE full_name = 'Fyodor Dostoevsky'), (SELECT id FROM genres WHERE name = 'Mystery'));