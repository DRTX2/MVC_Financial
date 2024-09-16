# Financial Application

This project is a Java-based financial application designed using Clean Architecture and the MVC pattern. It features a services layer and data access layer to manage income and expenses efficiently. This is my initial attempt at implementing these design principles and architectural patterns.

## Features

- **Income and Expense Management**: Track and manage your financial transactions.
- **Date Formatting**: Transactions are displayed with human-readable dates.
- **MVC Architecture**: The application follows the Model-View-Controller pattern for separation of concerns.
- **Singleton Pattern**: Used in key components for ensuring a single instance.
- **Clean Code Principles**: Applied throughout the codebase for better readability and maintainability.

## Architecture

- **Models**: Represents the data and business logic of the application.
- **Views**: Provides the user interface for interaction.
- **Controllers**: Handles user input and updates the model and view accordingly.
- **Services**: Contains the business logic and interacts with the data access layer.
- **Data Access Layer**: Manages data persistence and retrieval.

## Setup

To run this application locally, follow these steps:

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/DRTX2/MVC_Financial.git
    ```

2. **Navigate to the Project Directory**:
    ```bash
    cd MVC_Financial
    ```

3. **Compile the Project**:
    Ensure you have JDK installed. Compile the project using:
    ```bash
    javac -d bin src/**/*.java
    ```

4. **Run the Application**:
    ```bash
    java -cp bin Main.Main
    ```

## Usage

- **Add Transaction**: Enter transaction details (type, amount, date, description) and click "Add transaction" to include it in the list.
- **View Transactions**: Transactions are displayed in a table format with columns for Type, Amount, Date, and Description.
- **Current Balance**: The application shows the current balance based on the transactions.

## Screenshots

![Main Screen](docs/screenshot.png)

## Contributing

Contributions are welcome! To contribute:

1. **Fork the Repository**.
2. **Create a Branch**:
    ```bash
    git checkout -b feature/YourFeature
    ```
3. **Make Your Changes**.
4. **Commit Your Changes**:
    ```bash
    git commit -am 'Add new feature'
    ```
5. **Push to the Branch**:
    ```bash
    git push origin feature/YourFeature
    ```
6. **Create a Pull Request**.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Inspired by various sources on Clean Architecture and MVC design patterns.
- Special thanks to the Java community for their support and resources.

- Pendiente

Crear las vistas de login y registro.
Implementar los controladores para manejar la autenticación (login, logout).
Implementar la lógica de control de acceso en las vistas según los permisos.
Resolver errores en el modelamiento de usuario, sus servicios y su DAO.
