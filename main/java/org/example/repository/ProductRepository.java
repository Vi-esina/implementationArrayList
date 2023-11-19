package org.example.repository;

import org.example.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.util.DataBase.getConnection;

public class ProductRepository {
    public void saveProduct(Product product) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO order (name,totalAmount) VALUE (?,?)";

        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getTotalAmount());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Product findById(long id){
        String getOrderById = "SELECT * from product where id =?; ";
        try (Connection connection = getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(getOrderById);
            preparedStatement.setLong(1, id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Product(
                        (resultSet.getLong("id")),
                        (resultSet.getString("name")),
                        (resultSet.getDouble("totalAmount")),
                        (resultSet.getInt("customer_id"))
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;


    }

    public List<Product> findAllOrder() {
        List<Product> productList = new ArrayList<>();
        ResultSet resultSet;
        String getProduct="SELECT * from product;";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(getProduct);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productList.add(new Product(
                        (resultSet.getLong("id")),
                        (resultSet.getString("name")),
                        (resultSet.getDouble("totalAmount")),
                        (resultSet.getInt("customer_id"))
                ));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return productList;
    }

    public void updateProduct (int id, String newName) {
        String update = "UPDATE product SET id = ? WHERE id=?";

        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteProduct (int id) {
        String delete = "DELETE from product WHERE id = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
