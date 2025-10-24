package repository;

import model.OrderManagementDetails;

import java.sql.ResultSet;

public interface OrderManagementRepository {
    ResultSet getAllOrderDetails();
    void addOrderDetails(OrderManagementDetails orderManagementDetails);
    void deleteOrderDetails(String id);
    void updateOrderDetails(OrderManagementDetails orderManagementDetails);
}
