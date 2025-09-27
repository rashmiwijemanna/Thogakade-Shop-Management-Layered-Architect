package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerManagementDetails;
import repository.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerManagementServiceImpl implements CustomerManagementService {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void addCustomerDetails(CustomerManagementDetails customerManagementDetails) {

        PreparedStatement preparedStatement = customerRepository.addCustomerDetails();



        try {

            preparedStatement.setObject(1,customerManagementDetails.getId());
            preparedStatement.setObject(2,customerManagementDetails.getTitle());
            preparedStatement.setObject(3,customerManagementDetails.getName());
            preparedStatement.setObject(4,customerManagementDetails.getDOB());
            preparedStatement.setObject(5,customerManagementDetails.getSalary());
            preparedStatement.setObject(6,customerManagementDetails.getAddress());
            preparedStatement.setObject(7,customerManagementDetails.getCity());
            preparedStatement.setObject(8,customerManagementDetails.getProvince());
            preparedStatement.setObject(9,customerManagementDetails.getPostalcode());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteCustomerDetails(String id) {
        PreparedStatement preparedStatement = customerRepository.deleteCustomerDetails();
        Connection connection=null;
        try {
            preparedStatement.setObject(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void updateCustomerDetails(CustomerManagementDetails customerManagementDetails) {
        PreparedStatement preparedStatement = customerRepository.updateCustomerDetails();

        try {


            preparedStatement.setObject(1,customerManagementDetails.getTitle());
            preparedStatement.setObject(2,customerManagementDetails.getName());
            preparedStatement.setObject(3,customerManagementDetails.getDOB());
            preparedStatement.setObject(4,customerManagementDetails.getSalary());
            preparedStatement.setObject(5,customerManagementDetails.getAddress());
            preparedStatement.setObject(6,customerManagementDetails.getCity());
            preparedStatement.setObject(7,customerManagementDetails.getProvince());
            preparedStatement.setObject(8,customerManagementDetails.getPostalcode());
            preparedStatement.setObject(9,customerManagementDetails.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
