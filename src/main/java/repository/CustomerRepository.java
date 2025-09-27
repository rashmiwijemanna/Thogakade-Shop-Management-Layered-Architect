package repository;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository {
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

    public  PreparedStatement addCustomerDetails(){
        String SQL="INSERT INTO Customer(CustID, CustTitle, CustName, DOB, salary, CustAddress, City, Province, PostalCode) VALUES(?,?,?,?,?,?,?,?,?);";
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            return preparedStatement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public PreparedStatement deleteCustomerDetails(){
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Customer WHERE CustId = ?");
            return  preparedStatement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public  PreparedStatement updateCustomerDetails(){
        String SQL="UPDATE Customer SET CustTitle = ?, CustName = ?, DOB = ?, salary = ?, CustAddress = ?, City = ?, Province = ?, PostalCode = ? WHERE CustID = ?";
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            return preparedStatement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
