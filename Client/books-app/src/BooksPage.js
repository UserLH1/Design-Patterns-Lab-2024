import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button, Form, Modal, Table } from "react-bootstrap";

const BooksPage = () => {
  const [books, setBooks] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [editingBook, setEditingBook] = useState(null);
  const [formData, setFormData] = useState({ title: "", authors: [] });
  const SERVER_API = "http://localhost:8080";

  // Fetch books on component mount
  useEffect(() => {
    fetchBooks();
  }, []);

  const fetchBooks = async () => {
    try {
      const response = await axios.get(SERVER_API + "/books");
      console.log("Fetched books:", response.data);
      setBooks(response.data);
    } catch (error) {
      console.error("Error fetching books:", error);
    }
  };

  const handleFetchBookSSE = () => {
    const eventSource = new EventSource(SERVER_API + "/books-sse");
    console.log("Listening for book events...");
    eventSource.onmessage = (event) => {
      const newBook = JSON.parse(event.data);

      // Verifică dacă cartea deja există în listă
      setBooks((prevBooks) => {
        const bookExists = prevBooks.some((book) => book.id === newBook.id);
        if (!bookExists) {
          return [...prevBooks, newBook];
        }
        return prevBooks;
      });
    };
    eventSource.onerror = () => {
      console.error("Error with SSE connection");
      eventSource.close();
    };
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(SERVER_API + `/books/${id}`);
      fetchBooks(); // Refresh the list
    } catch (error) {
      console.error("Error deleting book:", error);
    }
  };

  const handleSave = async () => {
    try {
      const formattedData = {
        ...formData,
        authors: formData.authors.map((name) => ({ name })), // Transformă array-ul de stringuri în obiecte
      };

      if (editingBook) {
        // Edit book
        await axios.put(SERVER_API + `/books/${editingBook.id}`, formattedData);
      } else {
        // Add new book
        await axios.post(SERVER_API + "/books", formattedData);
      }
      setShowModal(false);
      fetchBooks();
    } catch (error) {
      console.error("Error saving book:", error);
    }
  };

  const openModal = (book = null) => {
    setEditingBook(book);
    setFormData(
      book
        ? {
            title: book.title,
            authors: book.authors.map((author) => author.name), // Extrage doar numele autorilor
          }
        : { title: "", authors: [] }
    );
    setShowModal(true);
  };

  return (
    <div className="container mt-4">
      <h1>Books Management</h1>
      <Button
        style={{ marginRight: "10px" }}
        className="mb-3"
        onClick={() => openModal()}
      >
        Add Book
      </Button>
      <Button className="mb-3" onClick={fetchBooks}>
        Refresh Books
      </Button>
      <Button className="mb-3 ms-2" onClick={handleFetchBookSSE}>
        Start Listening (SSE)
      </Button>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Authors</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {books.map((book) => (
            <tr key={book.id}>
              <td>{book.id}</td>
              <td>{book.title}</td>
              <td>{book.authors.map((author) => author.name).join(", ")}</td>
              <td>
                <Button
                  variant="info"
                  size="sm"
                  onClick={() => openModal(book)}
                >
                  Edit
                </Button>{" "}
                <Button
                  variant="danger"
                  size="sm"
                  onClick={() => handleDelete(book.id)}
                  style={{ marginLeft: "10px" }}
                >
                  Delete
                </Button>
                <Button
                  variant="primary"
                  size="sm"
                  onClick={() => (window.location.href = `/book/${book.id}`)}
                  style={{ marginLeft: "10px" }}
                >
                  View Book
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      {/* Modal for Add/Edit */}
      <Modal show={showModal} onHide={() => setShowModal(false)}>
        <Modal.Header closeButton>
          <Modal.Title>{editingBook ? "Edit Book" : "Add Book"}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group>
              <Form.Label>Title</Form.Label>
              <Form.Control
                type="text"
                value={formData.title}
                onChange={(e) =>
                  setFormData({ ...formData, title: e.target.value })
                }
              />
            </Form.Group>
            <Form.Group className="mt-3">
              <Form.Label>Authors (comma separated)</Form.Label>
              <Form.Control
                type="text"
                value={formData.authors.join(", ")}
                onChange={(e) =>
                  setFormData({
                    ...formData,
                    authors: e.target.value
                      .split(",")
                      .map((name) => name.trim()),
                  })
                }
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowModal(false)}>
            Close
          </Button>
          <Button variant="primary" onClick={handleSave}>
            {editingBook ? "Save Changes" : "Add Book"}
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default BooksPage;
