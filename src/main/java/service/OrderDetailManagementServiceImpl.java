package service;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OrderDetailManagementDetails;
import repository.OrderDetailRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailManagementServiceImpl implements OrderDetailManagementService {
    OrderDetailRepository  orderDetailRepository= new OrderDetailRepository();
    @Override
    public ObservableList<OrderDetailManagementDetails> getAllOrderDetails() {
        ObservableList<OrderDetailManagementDetails>orderDetailManagementDetails= FXCollections.observableArrayList();
        ResultSet allOrderDetails = orderDetailRepository.getAllOrderDetails();
        try {
            while (allOrderDetails.next()){
                orderDetailManagementDetails.add(new OrderDetailManagementDetails(
                        allOrderDetails.getString("OrderID"),
                        allOrderDetails.getString("ItemCode"),
                        allOrderDetails.getInt("OrderQTY"),
                        allOrderDetails.getInt("Discount")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailManagementDetails;
    }

    @Override
    public void addOrderDetail(OrderDetailManagementDetails orderDetailManagementDetails) {

        orderDetailRepository.addOrderDetail(orderDetailManagementDetails);
    }

    @Override
    public void deleteOrderDetails(String id) throws SQLException {

        orderDetailRepository.deleteOrderDetails(id);

    }

    @Override
    public void updateOrderDetails(OrderDetailManagementDetails orderDetailManagementDetails) {
        orderDetailRepository.updateOrderDetails(orderDetailManagementDetails);


    }
}
