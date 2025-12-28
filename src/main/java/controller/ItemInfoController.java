package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.ItemInfoDto;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemInfoController implements Initializable {
ObservableList<ItemInfoDto>itemInfoDtos = FXCollections.observableArrayList(
        new ItemInfoDto("I001","Red Rice 5kg","Groceries",40,1200),
        new ItemInfoDto("I002","White Rice 5kg","Groceries",50,1350)
);

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQuantityOnHand;

    @FXML
    private TableColumn<?, ?> colUnitprice;

    @FXML
    private TableView<ItemInfoDto> tblItemInfo;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String itemCode = txtItemCode.getText();
        String description = txtDescription.getText();
        String category = txtCategory.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());
        double unitprice = Double.parseDouble(txtUnitPrice.getText());

        itemInfoDtos.add(new ItemInfoDto(itemCode,description,category,quantity,unitprice));

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        ItemInfoDto selectItem = tblItemInfo.getSelectionModel().getSelectedItem();
        itemInfoDtos.remove(selectItem);
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQuantityOnHand.setCellValueFactory(new PropertyValueFactory<>("quantityOnHand"));
        colUnitprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tblItemInfo.setItems(itemInfoDtos);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        ItemInfoDto selectItem = tblItemInfo.getSelectionModel().getSelectedItem();
        selectItem.setItemCode(txtItemCode.getText());
        selectItem.setDescription(txtDescription.getText());
        selectItem.setCategory(txtCategory.getText());
        selectItem.setQuantityOnHand(Integer.parseInt(txtQuantity.getText()));
        selectItem.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));

        tblItemInfo.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblItemInfo.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
        if (newValue != null) {
            txtItemCode.setText(newValue.getItemCode());
            txtDescription.setText(newValue.getDescription());
            txtCategory.setText(newValue.getCategory());
            txtQuantity.setText(String.valueOf(newValue.getQuantityOnHand()));
            txtUnitPrice.setText(String.valueOf(newValue.getUnitPrice()));

        }

    } );
    }
}
