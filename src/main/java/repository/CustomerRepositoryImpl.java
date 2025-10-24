package repository;

import db.DBConnection;
import model.CustomerManagementDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl {
    public ResultSet getAllCustomer(){
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("Select * FROM Customer;");
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public  void addCustomerDetails(CustomerManagementDetails customerManagementDetails) throws SQLException {
        String SQL="INSERT INTO Customer(CustID, CustTitle, CustName, DOB, salary, CustAddress, City, Province, PostalCode) VALUES(?,?,?,?,?,?,?,?,?);";

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
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



    }

    public void deleteCustomerDetails(String id){
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Customer WHERE CustId = ?");
            preparedStatement.setObject(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public  void updateCustomerDetails(CustomerManagementDetails customerManagementDetails){
        String SQL="UPDATE Customer SET CustTitle = ?, CustName = ?, DOB = ?, salary = ?, CustAddress = ?, City = ?, Province = ?, PostalCode = ? WHERE CustID = ?";
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
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
}
