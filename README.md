# Task API

This repository contains a Task API implemented in Java using the Spring framework. The API allows for the management of tasks, including creating, updating, deleting, and listing tasks, as well as retrieving details of specific tasks.

## Technology Stack

- Java
- Spring Boot
- Spring Data JPA
- Database: [MongoDB](https://www.mongodb.com)

## Setup

Before running the API, make sure you have Java and MongoDB installed on your machine.

1. Clone this repository to your local machine:

```shell
git clone https://github.com/rfsants001/task-api.git
```

2. Navigate to the project directory:

```shell
cd task-api
```

3. Configure the MongoDB database:

   - Ensure that MongoDB is installed and running on your local machine.
   - Open the `src/main/resources/application.properties` file and adjust the MongoDB connection settings if needed.

4. Run the API:

```shell
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

## Usage

You can use an HTTP client (e.g., [cURL](https://curl.se)) or a tool like [Postman](https://www.postman.com) to interact with the API.

Here are some example requests:

- **Create a new task:**

  ```
  POST /tasks
  Content-Type: application/json

  {
    "title": "My first task",
    "description": "Perform an important task"
  }
  ```

- **List all tasks:**

  ```
  GET /tasks
  ```

- **Retrieve details of a specific task:**

  ```
  GET /tasks/{taskId}
  ```

- **Update an existing task:**

  ```
  PUT /tasks/{taskId}
  Content-Type: application/json

  {
    "title": "Updated task",
    "description": "Task updated successfully"
  }
  ```

- **Delete a task:**

  ```
  DELETE /tasks/{taskId}
  ```

## Contribution

Contributions are welcome! If you encounter any issues or have suggestions for improvements, feel free to open a new issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

I hope this helps! If you have any further questions, feel free to ask.
