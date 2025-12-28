package controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.SupplierInfoDto;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplierInfoController implements Initializable {
    ObservableList<SupplierInfoDto>supplierInfoDtos = FXCollections.observableArrayList(
            new SupplierInfoDto("S001","Kamal","Araliya","No.23 Polonnaruva","Polonnaruva","Polonnaruva","456214","0774568211","Kaml@gmail.com"),
            new SupplierInfoDto("S002","Amara","Nipuna","No.450 Anuradapura","Anuradapura","Anuradapura","456214","0112546358","Amara@gmail.com")
    );

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCompany;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private TableView<SupplierInfoDto> tblSupplierInfo;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSupplierId;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtSupplierId.getText();
        String name = txtName.getText();
        String company=txtCompanyName.getText();
        String address=txtAddress.getText();
        String city=txtCity.getText();
        String province=txtProvince.getText();
        String postalCode=txtPostalCode.getText();
        String phone=txtPhone.getText();
        String email=txtEmail.getText();

        supplierInfoDtos.add(new SupplierInfoDto(id,name,company,address,city,province,postalCode,phone,email));
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        SupplierInfoDto selectSupplier =tblSupplierInfo.getSelectionModel().getSelectedItem();
        supplierInfoDtos.remove(selectSupplier);
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCompany.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblSupplierInfo.setItems(supplierInfoDtos);

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        SupplierInfoDto selectSupplier = tblSupplierInfo.getSelectionModel().getSelectedItem();
        selectSupplier.setSupplierId(txtSupplierId.getText());
        selectSupplier.setName(txtName.getText());
        selectSupplier.setCompanyName(txtCompanyName.getText());
        selectSupplier.setAddress(txtAddress.getText());
        selectSupplier.setCity(txtCity.getText());
        selectSupplier.setProvince(txtProvince.getText());
        selectSupplier.setPostalCode(txtPostalCode.getText());
        selectSupplier.setPhone(txtPhone.getText());
        selectSupplier.setEmail(txtEmail.getText());

        tblSupplierInfo.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblSupplierInfo.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            if (newValue != null){
                txtSupplierId.setText(newValue.getSupplierId());
                txtName.setText(newValue.getName());
                txtCompanyName.setText(newValue.getCompanyName());
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                txtProvince.setText(newValue.getProvince());
                txtPostalCode.setText(newValue.getPostalCode());
                txtPhone.setText(newValue.getPhone());
                txtEmail.setText(newValue.getEmail());
            }
        } );
    }
}
