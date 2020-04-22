SELECT title FROM book WHERE NOT EXISTS (SELECT book_id FROM checkout_item WHERE checkout_item.book_id = book.id) UNION SELECT title FROM movie WHERE NOT EXISTS (SELECT movie_id FROM checkout_item WHERE checkout_item.movie_id = movie.id);