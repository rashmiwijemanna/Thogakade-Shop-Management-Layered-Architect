package service;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OrderManagementDetails;
import repository.OrderManagementRepositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderManagementServiceImpl implements OrderManagementService {
    OrderManagementRepositoryImpl orderManagementRepository=new OrderManagementRepositoryImpl();
    @Override
    public ObservableList<OrderManagementDetails> getAllOrderDetails() {
        ObservableList<OrderManagementDetails> orderManagementDetails1= FXCollections.observableArrayList();
        ResultSet allOrderDetails = orderManagementRepository.getAllOrderDetails();
        try {

            while (allOrderDetails.next()){
                orderManagementDetails1.add(new OrderManagementDetails(
                        allOrderDetails.getString("OrderID"),
                        allOrderDetails.getDate("OrderDate").toLocalDate(),
                        allOrderDetails.getString("CustID")
                ));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderManagementDetails1;

    }

    @Override
    public void addOrderDetails(OrderManagementDetails orderManagementDetails) {
        orderManagementRepository.addOrderDetails(orderManagementDetails);
    }

    @Override
    public void deleteOrderDetails(String id) {
        orderManagementRepository.deleteOrderDetails(id);
    }

    @Override
    public void updateOrderDetails(OrderManagementDetails orderManagementDetails) {
        String SQL="UPDATE Orders2 SET OrderDate = ?, CustID = ? WHERE OrderID = ?";
        try {
            Connection connection=DBConnection.getInstance().getConnection();
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
