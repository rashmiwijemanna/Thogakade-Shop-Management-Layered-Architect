package repository;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepository {
    public ResultSet getAllItemDetails(){
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Itemm");
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public  PreparedStatement addItemDetails(){
        String SQL="INSERT INTO Itemm(ItemCode, Description, PackSize, UnitPrice, QtyOnHand) VALUES(?,?,?,?,?);";

        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            return  preparedStatement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PreparedStatement deleteItemDetails(){
        String SQL="DELETE FROM Itemm WHERE ItemCode = ?";
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            return preparedStatement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public  PreparedStatement updateItemDetails(){
        String SQL="UPDATE Itemm SET Description = ?, PackSize = ?, UnitPrice = ?, QtyOnHand = ? WHERE ItemCode = ?";
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            return  preparedStatement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
