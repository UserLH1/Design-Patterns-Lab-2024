import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button, Form, Modal, Table } from "react-bootstrap";

const BooksPage = () => {
  const [books, setBooks] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [editingBook, setEditingBook] = useState(null);
  const [formData, setFormData] = useState({ title: "", author: "" });
  const SERVER_API = "http://localhost:8080";
  // Fetch books on component mount
  useEffect(() => {
    fetchBooks();
  }, []);

  const fetchBooks = async () => {
    try {
      const response = await axios.get(SERVER_API + "/books");
      setBooks(response.data);
    } catch (error) {
      console.error("Error fetching books:", error);
    }
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`/books/${id}`);
      fetchBooks(); // Refresh the list
    } catch (error) {
      console.error("Error deleting book:", error);
    }
  };

  const handleSave = async () => {
    try {
      if (editingBook) {
        // Edit book
        await axios.put(`/books/${editingBook.id}`, formData);
      } else {
        // Add new book
        await axios.post("/books", formData);
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
        ? { title: book.title, author: book.author }
        : { title: "", author: "" }
    );
    setShowModal(true);
  };

  return (
    <div className="container mt-4">
      <h1>Books Management</h1>
      <Button className="mb-3" onClick={() => openModal()}>
        Add Book
      </Button>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {books.map((book) => (
            <tr key={book.id}>
              <td>{book.id}</td>
              <td>{book.title}</td>
              <td>{book.author}</td>
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
                >
                  Delete
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
            <Form.Group>
              <Form.Label>Author</Form.Label>
              <Form.Control
                type="text"
                value={formData.author}
                onChange={(e) =>
                  setFormData({ ...formData, author: e.target.value })
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
