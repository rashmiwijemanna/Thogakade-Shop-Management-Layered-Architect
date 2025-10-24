package repository;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.OrderManagementDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderManagementRepositoryImpl {
    public ResultSet getAllOrderDetails(){
        String SQL="SELECT * FROM Orders2";
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            return  resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void addOrderDetails(OrderManagementDetails orderManagementDetails){
        String SQL="INSERT INTO Orders2(OrderID, OrderDate, CustID)VALUES(?,?,?);";
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,orderManagementDetails.getId());
            preparedStatement.setObject(2,orderManagementDetails.getDate());
            preparedStatement.setObject(3,orderManagementDetails.getCustId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void deleteOrderDetails(String id){
        String SQL="DELETE FROM Orders2 WHERE OrderId = ?";
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void updateOrderDetails(OrderManagementDetails orderManagementDetails){
        String SQL="UPDATE Orders2 SET OrderDate = ?, CustID = ? WHERE OrderID = ?";
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1,orderManagementDetails.getDate());
            preparedStatement.setObject(2,orderManagementDetails.getCustId());
            preparedStatement.setObject(3,orderManagementDetails.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
