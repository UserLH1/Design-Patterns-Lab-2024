import React from "react";
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import BookDetailsPage from "./BookDetailsPage";
import BooksPage from "./BooksPage";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<BooksPage />} />
        <Route path="/book/:id" element={<BookDetailsPage />} />
      </Routes>
    </Router>
  );
};

export default App;
