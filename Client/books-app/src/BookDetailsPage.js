import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
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
    <div className="container mt-4">
      <h1>{book.title}</h1>
      <p>
        <strong>Authors:</strong>{" "}
        {book.authors?.map((author) => author.name).join(", ") || "N/A"}
      </p>
      <p>
        <strong>Table of Contents:</strong>{" "}
        {book.tableOfContents?.content || "N/A"}
      </p>

      <h3>Sections</h3>
      {book.sections?.length > 0 ? (
        book.sections.map((section, index) => (
          <div key={index}>
            <h4>{section.title}</h4>
            <ul>
              {section.elements?.map((element, idx) => (
                <li key={idx}>
                  {element.type === "Paragraph" && <p>{element.text}</p>}
                  {element.type === "Image" && (
                    <img src={element.url} alt="Image" />
                  )}
                  {element.type === "Table" && <p>{element.content}</p>}
                </li>
              ))}
            </ul>
            {section.subSections?.length > 0 && (
              <div style={{ marginLeft: "20px" }}>
                <h5>Subsections:</h5>
                {section.subSections.map((subSection, idx) => (
                  <div key={idx}>
                    <h6>{subSection.title}</h6>
                    <ul>
                      {subSection.elements?.map((subElement, subIdx) => (
                        <li key={subIdx}>
                          {subElement.type === "Paragraph" && (
                            <p>{subElement.text}</p>
                          )}
                          {subElement.type === "Image" && (
                            <img src={subElement.url} alt="Image" />
                          )}
                          {subElement.type === "Table" && (
                            <p>{subElement.content}</p>
                          )}
                        </li>
                      ))}
                    </ul>
                  </div>
                ))}
              </div>
            )}
          </div>
        ))
      ) : (
        <p>No sections available.</p>
      )}

      <Button variant="secondary" onClick={() => window.history.back()}>
        Back to Books
      </Button>
    </div>
  );
};

export default BookDetailsPage;
