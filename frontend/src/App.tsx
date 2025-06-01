import { useEffect, useState } from 'react';
import './App.css';

type BookType = {
    title: string;
    author: string;
}

export function App() {
  const [message, setMessage] = useState<string | null>(null)
  const [books, setBooks] = useState<BookType[] | null>(null)

  useEffect(() => {
    fetch('/books')
      .then(result => result.json())
        .then(data => setBooks(data))
        .catch(error => console.error('Error fetching books:', error));

    fetch('/books/hello')
        .then(result => result.text())
            .then(data => setMessage(data))
            .catch(error => console.error('Error fetching message:', error));
  }, []);

  return (
    <>
      <h1>Super Simple App</h1>
      <h4>{message}</h4>
      <h2>Our Books</h2>
        <ul>
        {
            books ? books.map((book) => (
                <li key={book.title}>
                <strong>{book.title}</strong> by {book.author}
                </li>
            )) : <li>Loading books...</li>
        }
        </ul>
    </>
  );
}

