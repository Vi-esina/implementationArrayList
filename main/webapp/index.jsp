
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            border-collapse: collapse;
            width: 30%;
        }
        th, td {
            border: 1px solid black;
            padding: 5px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>



<h2>Customer Table</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Last Name</th>
        <th>First Name</th>
        <th>Age</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <%
        try {
            // Установка соединения с базой данных
            String url = "jdbc:mysql://localhost:3306/service?useUnicode=true&characterEncoding=UTF-8";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);

            // Выполнение SQL-запроса
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Customer";
            ResultSet resultSet = statement.executeQuery(query);

            // Обработка результатов запроса
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String lastName = resultSet.getString("lastname");
                String firstName = resultSet.getString("firstname");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
    %>
    <tr>
        <td><%= id %></td>
        <td><%= lastName %></td>
        <td><%= firstName %></td>
        <td><%= age %></td>
        <td><%= address %></td>
    </tr>
    <%
            }

            // Закрытие ресурсов
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error occurred while retrieving data from the database.");
        }
    %>
    </tbody>
</table>
</body>
</html>