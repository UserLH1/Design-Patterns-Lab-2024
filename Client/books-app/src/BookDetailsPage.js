import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button, Card, Container } from "react-bootstrap";
import { useParams } from "react-router-dom";

const BookDetailsPage = () => {
  const { id } = useParams(); // Obține ID-ul cărții din URL
  const [book, setBook] = useState(null);
  const SERVER_API = "http://localhost:8080";

  useEffect(() => {
    fetchBookDetails();
  }, []);

  const fetchBookDetails = async () => {
    try {
      const response = await axios.get(`${SERVER_API}/books/${id}`);
      setBook(response.data);
    } catch (error) {
      console.error("Error fetching book details:", error);
    }
  };

  if (!book) {
    return <p>Loading book details...</p>;
  }

  return (
    <Container className="mt-4">
      <h1 className="text-center">{book.title}</h1>
      <p className="text-center">
        <strong>Authors:</strong>{" "}
        {book.authors?.map((author) => author.name).join(", ") || "N/A"}
      </p>
      <p className="text-center">
        <strong>Table of Contents:</strong>{" "}
        {book.tableOfContents?.content || "N/A"}
      </p>

      <h3 className="mt-5">Elements</h3>
      {book.elements?.length > 0 ? (
        book.elements.map((element, index) => (
          <Card className="my-3" key={index}>
            <Card.Body>
              {element.type === "Paragraph" && (
                <div>
                  <Card.Title>Paragraph</Card.Title>
                  <Card.Text>{element.text}</Card.Text>
                </div>
              )}
              {element.type === "Image" && (
                <div>
                  <Card.Title>Image</Card.Title>
                  <div style={{ display: "flex", justifyContent: "center" }}>
                    <Card.Img
                      src={element.url}
                      alt="Book element"
                      style={{
                        maxWidth: "300px",
                        maxHeight: "200px",
                        objectFit: "contain",
                        border: "1px solid #ddd",
                        borderRadius: "5px",
                        padding: "5px",
                      }}
                    />
                  </div>
                </div>
              )}
              {element.type === "Table" && (
                <div>
                  <Card.Title>Table</Card.Title>
                  <pre>{element.content}</pre>
                </div>
              )}
            </Card.Body>
          </Card>
        ))
      ) : (
        <p>No elements available.</p>
      )}

      <Button
        variant="secondary"
        onClick={() => window.history.back()}
        className="mt-3"
      >
        Back to Books
      </Button>
    </Container>
  );
};

export default BookDetailsPage;
