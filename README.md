
<h1 align="center">🎮 QuizGame</h1>
<p align="center">
  <i>Built by Ahmed — a modular, database-powered quiz engine in Java</i><br>
  <b>Scalable. Secure. Real-world ready.</b>
</p>

---

## ✨ Overview

QuizGame is a console-based multiple-choice quiz system built with Java, PostgreSQL, and JDBC. It features clean architecture, secure config management, and flexible question handling using PostgreSQL arrays. Designed for both players and game makers, it’s a perfect showcase of backend engineering principles.

---

## 🚀 Features

- 🧠 Add, view, and delete questions with variable-length options
- 🗃️ Persistent storage using PostgreSQL and JDBC
- 🔐 Secure configuration via `config.properties`
- 🧱 Clean separation of concerns (Service, Repository, DB Manager)
- 👥 Dual roles: Player and Game Maker
- 🛠️ Maven-powered build system

---

## 🧰 Tech Stack

| Tool           | Purpose                     |
|----------------|-----------------------------|
| Java 23        | Core language               |
| PostgreSQL     | Relational database         |
| JDBC           | Database connectivity       |
| Maven          | Dependency management       |
| IntelliJ IDEA  | Development environment     |

---

## 📁 Project Structure

📦 QuizGame/
├── 📄 pom.xml                  → Maven build configuration
├── 📄 config.properties        → Secure DB credentials (excluded from Git)
├── 📄 .gitignore               → Ignored files and folders
├── 🗂️ src/
│   └── 📦 com.felfel/
│       ├── 🚀 Main.java              → Entry point to launch Player or GameMaker
│       ├── 👤 Player.java            → Quiz logic for players
│       ├── 🛠️ GameMaker.java         → Admin interface to manage questions
│       ├── ❓ Question.java           → Data model (Java record)
│       ├── 🧠 QuestionService.java    → Business logic layer
│       ├── 🔐 config/
│       │   └── 🧾 ConfigManager.java  → Loads DB config securely
│       ├── 🗃️ db/
│       │   └── 🔌 DatabaseManager.java → Manages PostgreSQL connections
│       └── 📂 repository/
│           └── 📥 QuestionRepository.java → Handles DB operations (CRUD)
---

## 🛠️ Setup Instructions

### 1. Clone the repo
```bash
git clone https://github.com/your-username/QuizGame.git


2. Create the PostgreSQL database
CREATE DATABASE quizgame;


3. Create the questions table
CREATE TABLE questions (
    id SERIAL PRIMARY KEY,
    question TEXT NOT NULL,
    options TEXT[] NOT NULL,
    answer_index SMALLINT NOT NULL
);


4. Add your credentials to config.properties
db.url=jdbc:postgresql://localhost:5432/quizgame
db.user=your_username
db.password=your_password


5. Run the app
From IntelliJ or using Maven:
mvn compile
mvn exec:java -Dexec.mainClass="com.felfel.Main"



👤 Roles
🎮 Player
- Takes the quiz
- Gets scored based on correct answers
- Can retake the quiz
🛠️ Game Maker
- Adds new questions
- Views all questions
- Deletes questions by ID

🧠 Design Principles
- Encapsulation: Clean data models using Java records
- Modularity: Separation of UI, logic, and data layers
- Security: Credentials stored outside codebase
- Scalability: PostgreSQL arrays allow flexible option counts
- Maintainability: Easy to extend with categories, scores, or difficulty levels

📜 License
This project is open-source and free to use under the MIT License.

🙋‍♂️ Author
Ahmed
Backend Developer | Java Enthusiast | Database Explorer
📍 Hurghada, Egypt

---

Let me know if you want to add badges, screenshots, or a demo video link later. We can make this repo portfolio-ready in no time.


