# The Green Basket 🛒

The Green Basket is an organic grocery store product management system that handles product entry, stock management, user management, product search, and low-stock monitoring. Built using **Java Swing**, **MySQL**, and **MVC Architecture**, the system streamlines day-to-day store operations and improves inventory tracking.

## Objectives

- To create a system that allows sales assistants and store managers to manage products easily, reducing manual work and mistakes.
- To provide different access levels for sales assistants and store managers, so each user can only use the features allowed for their role.
- To develop the system using Object-Oriented Programming (OOP) concepts.
- To show low-stock alerts so managers know when products need to be refilled.

## Features

**Sales Assistant can:**
- Add new products
- View product details
- Search products

**Store Manager can:**
- Create, update, and delete user accounts
- Monitor product stock
- Generate restock alerts

## Tech Stack

- **Java (Swing)** – GUI
- **MySQL** – Database
- **JDBC** – Database connectivity
- **MVC Architecture**

## OOP Concepts Implemented

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction

## Installation and Setup

1. **Install Java** – Download and install the Java Development Kit (JDK) from the official Oracle website.
2. **Install MySQL** – Download and install MySQL Community Server from the official MySQL website.
3. **Create Database**
   ```sql
   CREATE DATABASE the_green_busket;
   ```
4. **Create Tables** – Run the required SQL scripts to create the necessary tables (e.g., `users`, `products`).
5. **Configure Database Connection** – Open `Database/DBConnection.java` and update the database URL, username, and password.
6. **Compile and Run** – Compile the Java code using your preferred IDE or the command line, then run the `logview` class to launch the login interface.

## How to Run

1. Set up the MySQL database named `the_green_busket` and create the necessary tables.
2. Update `DBConnection.java` with your MySQL username, password, and database URL.
3. Compile and run the application, launching the `logview` class.
4. Log in using the default credentials:
   - Sales Assistant → `sales / 1111`
   - Store Manager → `manager / 2222`
5. Explore features such as product management and user management.

## Project Interface

| Login Screen | Product Management | Stock / Dashboard View |
|---|---|---|
[Login Screen](<img width="340" height="272" alt="image" src="https://github.com/user-attachments/assets/40d23a04-477c-4408-9b6b-22a188e3ab4e" />
) [Product Management](<img width="526" height="428" alt="image" src="https://github.com/user-attachments/assets/4eb01124-ddd9-4c93-b45d-89e164752f3a" />
) (<img width="450" height="403" alt="image" src="https://github.com/user-attachments/assets/3004c359-738b-404e-a7cf-05d2e532c3a8" />
) 

## Database Design (ER Diagram)

- **Users Table:** `userID` (Primary Key), `username`, `password`, `role`
- **Products Table:** `productID` (Primary Key), `productName`, `category`, `price`, `quantity`
- **Relationship:** One-to-many — a manager manages multiple products.

## Conclusion

The Green Basket project successfully implements a product management system with role-based access control, improving store operations and inventory tracking. It showcases how Java and MySQL can be combined to build a scalable, efficient retail management solution.

**Future Enhancements:**
- Barcode scanning
- Sales reporting
- Mobile app support

## References

- [Oracle Java Documentation](https://docs.oracle.com/javase/8/docs/api/)
- [MySQL Connector/J Documentation](https://dev.mysql.com/doc/connector-j/8.0/en/)
- [Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)
