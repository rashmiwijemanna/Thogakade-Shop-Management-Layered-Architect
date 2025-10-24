package repository;

import model.OrderDetailManagementDetails;

import java.sql.ResultSet;

public interface OrderRepository {
    ResultSet getAllOrderDetails();
    void addOrderDetail(OrderDetailManagementDetails orderDetailManagementDetails);
    void deleteOrderDetails(String id);
    void updateOrderDetails(OrderDetailManagementDetails orderDetailManagementDetails);
}
