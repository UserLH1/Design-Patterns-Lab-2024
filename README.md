
📚 Design Patterns Lab 2024
=================================

Welcome to **Design Patterns Lab 2024**, a Spring Boot-based application built to demonstrate the implementation of various software design patterns and architectural principles. This project is not just about coding but about understanding the concepts behind reusable, efficient, and scalable software design.

🚀 About the Project
---------------------------------
This application models a **Book Management System** where you can:
- **Manage Books**: Add, edit, delete, and view books.
- **Explore Elements**: Books are composed of multiple elements such as paragraphs, images, sections, and tables.
- **Real-Time Updates**: Experience real-time updates using **Server-Sent Events (SSE)**.
- **Logging**: Track request/response details with a custom logging filter.

Implemented Design Patterns:
- **Composite Pattern**: To manage complex structures like sections and sub-sections of a book.
- **Observer Pattern**: Real-time notifications for changes using SSE.
- **Strategy Pattern**: Custom alignment strategies for paragraph content.
- **Singleton Pattern**: Ensures a single instance of certain critical components like the book subject.

🛠 Technologies Used
---------------------------------
- **Backend**: 
  - [Spring Boot](https://spring.io/projects/spring-boot) for a modular and scalable architecture.
  - **Hibernate** for ORM and database interactions.
- **Frontend**:
  - [React](https://reactjs.org/) for building an interactive UI.
  - **Bootstrap** for styling and responsive design.
- **Database**: 
  - [H2 Database](https://www.h2database.com/) for in-memory testing.
  - Compatible with PostgreSQL for production environments.
- **Tools**:
  - **Postman** for testing APIs.
  - **GitHub** for version control.
  - **Lombok** for reducing boilerplate code.

📂 Folder Structure
---------------------------------
src/
├── main/
│   ├── java/ro/uvt/info/designpatternslab2024/
│   │   ├── controllers/         # REST Controllers
│   │   ├── filters/             # Request filters
│   │   ├── models/              # Entities and domain models
│   │   ├── observer/            # Observer pattern implementation
│   │   ├── services/            # Business logic services
│   │   └── persistence/         # Repositories for database interaction
│   └── resources/
│       ├── application.properties # App configuration
│       └── data.sql              # Initial database seed data

⚙️ Setup and Installation
---------------------------------
Follow these steps to get started with the project:

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/design-patterns-lab-2024.git
cd design-patterns-lab-2024
```

### 2. Configure the Application
Edit the `application.properties` file if you want to use a different database:
```bash
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and Run the Application
Use Gradle to build and run the application:
```bash
```
### 4. Open the Application
API Documentation: Access Swagger at http://localhost:8080/swagger-ui.html
H2 Console: Visit http://localhost:8080/h2-console for in-memory database management.
✨ Enjoy exploring design patterns with this project!

👨‍💻 Contributing Contributions are welcome! Feel free to fork this repository and submit pull requests.

📄 License This project is licensed under the MIT License. See the LICENSE file for details.