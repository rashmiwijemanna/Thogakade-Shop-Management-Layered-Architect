package service;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OrderDetailManagementDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailManagementControllerImpl implements OrderDetailManagementService {
    @Override
    public ObservableList<OrderDetailManagementDetails> getAllOrderDetails() {
        ObservableList<OrderDetailManagementDetails>orderDetailManagementDetails= FXCollections.observableArrayList();
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM OrderDetail;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                orderDetailManagementDetails.add(new OrderDetailManagementDetails(
                        resultSet.getString("OrderID"),
                        resultSet.getString("ItemCode"),
                        resultSet.getInt("OrderQTY"),
                        resultSet.getInt("Discount")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailManagementDetails;
    }

    @Override
    public void addOrderDetail(OrderDetailManagementDetails orderDetailManagementDetails) {
        String SQL="INSERT INTO OrderDetail (OrderId, ItemCode, OrderQTY, Discount) VALUES(?,?,?,?)";
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,orderDetailManagementDetails.getId());
            preparedStatement.setObject(2,orderDetailManagementDetails.getItemCode());
            preparedStatement.setObject(3,orderDetailManagementDetails.getQty());
            preparedStatement.setObject(4,orderDetailManagementDetails.getDiscount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrderDetails(String id) {
        String SQL="DELETE FROM OrderDetail WHERE OrderId = ?";
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateOrderDetails(OrderDetailManagementDetails orderDetailManagementDetails) {
        String SQL="UPDATE OrderDetail SET OrderQTY = ?, Discount = ? WHERE OrderId = ? AND ItemCode = ?";
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);


            preparedStatement.setObject(1,orderDetailManagementDetails.getQty());
            preparedStatement.setObject(2,orderDetailManagementDetails.getDiscount());
            preparedStatement.setObject(3,orderDetailManagementDetails.getId());
            preparedStatement.setObject(4,orderDetailManagementDetails.getItemCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
