package repository;

import model.CustomerManagementDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepository {
    ResultSet getAllCustomer();
    void addCustomerDetails(CustomerManagementDetails customerManagementDetails)throws SQLException;
    void deleteCustomerDetails(String id);
    void updateCustomerDetails(CustomerManagementDetails customerManagementDetails);

}
