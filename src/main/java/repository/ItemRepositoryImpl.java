package repository;

import db.DBConnection;
import model.ItemManagementDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepositoryImpl implements ItemRepository {
    @Override
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

    @Override
    public  void  addItemDetails(ItemManagementDetails itemManagementDetails){
        String SQL="INSERT INTO Itemm(ItemCode, Description, PackSize, UnitPrice, QtyOnHand) VALUES(?,?,?,?,?);";

        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,itemManagementDetails.getCode());
            preparedStatement.setObject(2,itemManagementDetails.getDescription());
            preparedStatement.setObject(3,itemManagementDetails.getPackSize());
            preparedStatement.setObject(4,itemManagementDetails.getUnitPrice());
            preparedStatement.setObject(5,itemManagementDetails.getQty());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteItemDetails(String code){
        String SQL="DELETE FROM Itemm WHERE ItemCode = ?";
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,code);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public  void  updateItemDetails(ItemManagementDetails itemManagementDetails){
        String SQL="UPDATE Itemm SET Description = ?, PackSize = ?, UnitPrice = ?, QtyOnHand = ? WHERE ItemCode = ?";
        Connection connection= null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,itemManagementDetails.getDescription());
            preparedStatement.setObject(2,itemManagementDetails.getPackSize());
            preparedStatement.setObject(3,itemManagementDetails.getUnitPrice());
            preparedStatement.setObject(4,itemManagementDetails.getQty());
            preparedStatement.setObject(5,itemManagementDetails.getCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
