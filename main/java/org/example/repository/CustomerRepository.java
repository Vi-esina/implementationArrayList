package org.example.repository;

import org.example.entity.Customer;



import org.example.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.util.DataBase.getConnection;


public class CustomerRepository {

    private List<Customer> customerList;


    public List<Customer> getAllCustomer() {
        return customerList;
    }

    public void saveCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO customer (firstname, lastname, age, address) VALUE (?,?,?,?)";

        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, customer.getFistName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setInt(3, customer.getAge());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Customer findById(int phone){
        String getPersonById = "SELECT * from customers where phone =" + phone + ";";
        try (Connection connection = getConnection();) {
            ResultSet resultSet = connection.prepareStatement(getPersonById).executeQuery();
            while (resultSet.next()) {
                return new Customer(
                        (resultSet.getInt("id")),
                        (resultSet.getString("firstname")),
                        (resultSet.getString("lastname")),
                        (resultSet.getInt("age")),
                        (resultSet.getString("address")),
                        (resultSet.getLong("passport_id"))
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;


    }

    public static List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        ResultSet resultSet;
        String getCustomers="SELECT * from customer;";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(getCustomers);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customerList.add(new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("address"),
                        resultSet.getLong("passport_id")
                ));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return customerList;
    }

    public void updateCustomer (int id, String newName) {
        String update = "UPDATE customer SET lastname = ? WHERE id=?";

        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCustomer (int id) {
        String delete = "DELETE from customer WHERE id = ?";

        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
