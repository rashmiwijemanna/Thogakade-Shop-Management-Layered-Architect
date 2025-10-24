package service;

import javafx.collections.ObservableList;
import model.OrderDetailManagementDetails;

import java.sql.SQLException;

public interface OrderDetailManagementService {
    ObservableList<OrderDetailManagementDetails>getAllOrderDetails();
    void addOrderDetail(OrderDetailManagementDetails orderDetailManagementDetails);
    void deleteOrderDetails(String id) throws SQLException;
    void updateOrderDetails(OrderDetailManagementDetails orderDetailManagementDetails);
}
