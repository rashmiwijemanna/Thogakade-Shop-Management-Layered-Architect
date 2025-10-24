package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OrderDetailManagementDetails;
import repository.OrderDetailRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailManagementServiceImpl implements OrderDetailManagementService {
    OrderDetailRepositoryImpl orderDetailRepository= new OrderDetailRepositoryImpl();
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
    public void deleteOrderDetails(String id)  {

        orderDetailRepository.deleteOrderDetails(id);

    }

    @Override
    public void updateOrderDetails(OrderDetailManagementDetails orderDetailManagementDetails) {
        orderDetailRepository.updateOrderDetails(orderDetailManagementDetails);


    }
}
