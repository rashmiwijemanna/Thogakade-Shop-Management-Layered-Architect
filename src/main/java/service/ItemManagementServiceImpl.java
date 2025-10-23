package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ItemManagementDetails;
import repository.ItemRepository;
import repository.ItemRepositoryImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemManagementServiceImpl implements ItemManagementService {
   ItemRepository itemRepository=new ItemRepositoryImpl();
    @Override
    public ObservableList<ItemManagementDetails> getAllItemDetails() {
        ObservableList<ItemManagementDetails> itemManagementDetails= FXCollections.observableArrayList();
        ResultSet allItemDetails = itemRepository.getAllItemDetails();

        try {
            while (allItemDetails.next()){
                itemManagementDetails.add(new ItemManagementDetails(
                        allItemDetails.getString("ItemCode"),
                        allItemDetails.getString("Description"),
                        allItemDetails.getString("PackSize"),
                        allItemDetails.getDouble("UnitPrice"),
                        allItemDetails.getString("QtyOnHand")

                ));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemManagementDetails;
    }

    @Override
    public void addItemDetails(ItemManagementDetails itemManagementDetails) {
        itemRepository.addItemDetails(itemManagementDetails);
    }

    @Override
    public void deleteItemDetails(String code) {
        PreparedStatement preparedStatement = itemRepository.deleteItemDetails();
        try {

            preparedStatement.setObject(1,code);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateItemDetails(ItemManagementDetails itemManagementDetails) {
        PreparedStatement preparedStatement = itemRepository.updateItemDetails();

        try {
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
