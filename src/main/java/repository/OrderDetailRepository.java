package repository;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailRepository {
    public ResultSet getAllOrderDetails(){
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM OrderDetail;");
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
