package org.example.repository;

import org.example.entity.Passport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.util.DataBase.getConnection;

public class PassportRepository {
    public void savePassport(Passport passport) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO person (serialNumber, identification) VALUE (?,?)";

        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, passport.getSerialNumber());
            preparedStatement.setString(2, passport.getIdentification());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public Passport findById(long id){
        String getPassportById = "SELECT * from passport where id =?; ";
        try (Connection connection = getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(getPassportById);
            preparedStatement.setLong(1, id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Passport(
                        (resultSet.getLong("id")),
                        (resultSet.getString("serial_number")),
                        (resultSet.getString("identification"))

                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Passport> findAll() {
        List<Passport> passportList = new ArrayList<>();
        ResultSet resultSet;
        String getPassports="SELECT * from passport;";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(getPassports);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                passportList.add(new Passport(
                        resultSet.getInt("id"),
                        resultSet.getString("serial_number"),
                        resultSet.getString("identification")
                ));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return passportList;
    }

    public void updatePassport (int id, String newName) {
        String update = "UPDATE passport SET serial_number = ? WHERE id=?";

        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletePassport (int id) {
        String delete = "DELETE from passport WHERE id = ?";

        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
