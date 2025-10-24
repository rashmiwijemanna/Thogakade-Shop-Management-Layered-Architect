package repository;

import db.DBConnection;
import model.OrderDetailManagementDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailRepositoryImpl implements OrderRepository {
    @Override
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

    @Override
    public void addOrderDetail(OrderDetailManagementDetails orderDetailManagementDetails){
        String SQL="INSERT INTO OrderDetail (OrderId, ItemCode, OrderQTY, Discount) VALUES(?,?,?,?)";
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
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
    public void deleteOrderDetails(String id){
        String SQL="DELETE FROM OrderDetail WHERE OrderId = ?";
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
    @Override
    public void updateOrderDetails(OrderDetailManagementDetails orderDetailManagementDetails){
        String SQL="UPDATE OrderDetail SET OrderQTY = ?, Discount = ? WHERE OrderId = ? AND ItemCode = ?";

        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
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
