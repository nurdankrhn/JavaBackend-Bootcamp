# 📚 Library Book Tracking System

A simple Java console application for managing a library's book inventory.  
This project demonstrates basic file operations, exception handling, and object-oriented design.

---

## ✨ Features

- 📥 Add, remove, and update books in the inventory  
- 💾 All book data is stored in `books.txt`  
- 📝 Every action (including errors) is logged in `log.txt` with timestamps  
- ⚠️ Custom exception (`InvalidStockException`) handles negative stock values  
- 📃 Automatically loads existing books on startup or creates a new file if not present  
- 👀 Displays the current book list after every operation

---

## 📁 File Structure

LibraryBookTrackingSystem/
│
├── Book.java // Represents a book with title, author, stock<br>
├── FileHandler.java // Handles reading/writing to books.txt and log.txt<br>
├── InvalidStockException.java // Custom exception for invalid stock updates<br>
├── LibraryManager.java // Main class, includes the menu and program logic<br>
├── books.txt // Book data file (auto-created if missing)<br>
├── log.txt // Log file for actions and errors (auto-created)<br>
└── README.md // This documentation file<br>
