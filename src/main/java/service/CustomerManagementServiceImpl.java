package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerManagementDetails;
import repository.CustomerRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerManagementServiceImpl implements CustomerManagementService {
    CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();

    @Override
    public void addCustomerDetails(CustomerManagementDetails customerManagementDetails) {

        try {
            customerRepository.addCustomerDetails(customerManagementDetails);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCustomerDetails(String id) {
        customerRepository.deleteCustomerDetails(id);

    }

    @Override
    public void updateCustomerDetails(CustomerManagementDetails customerManagementDetails) {
        customerRepository.updateCustomerDetails(customerManagementDetails);
    }

    @Override
    public ObservableList<CustomerManagementDetails> getAllCustomerDetails() {

        ObservableList<CustomerManagementDetails>  customerManagementDetails= FXCollections.observableArrayList();

        ResultSet allCustomer = customerRepository.getAllCustomer();
        try {
            while(allCustomer.next()){
                customerManagementDetails.add(new CustomerManagementDetails(
                        allCustomer.getString("CustID"),
                        allCustomer.getString("CustTitle"),
                        allCustomer.getString("CustName"),
                        allCustomer.getDate("DOB").toLocalDate(),
                        allCustomer.getDouble("salary"),
                        allCustomer.getString("CustAddress"),
                        allCustomer.getString("City"),
                        allCustomer.getString("Province"),
                        allCustomer.getString("PostalCode")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerManagementDetails;

    }
}
