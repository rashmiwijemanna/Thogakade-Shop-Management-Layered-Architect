package repository;

import javafx.collections.ObservableList;
import model.ItemManagementDetails;

import java.sql.ResultSet;

public interface ItemRepository {
     ResultSet getAllItemDetails();
    public  void  addItemDetails(ItemManagementDetails itemManagementDetails);
    void deleteItemDetails(String code);
}
