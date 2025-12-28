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
import model.dto.CustomerInfoDto;

import java.net.URL;
import java.util.ResourceBundle;

public class CustemerInfoController implements Initializable {
    ObservableList<CustomerInfoDto> customerInfoDtos = FXCollections.observableArrayList(
        new CustomerInfoDto("C001","Mr","Malith","2001-05-02",25000.0,"No450,Makandura","Pannala","North Western","60160"),
            new CustomerInfoDto("C002","Mr","Kamal","2003-08-025",15000,"Walana","Panadura","North","450123")

    );

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<CustomerInfoDto> tblCustomerInfo;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtCustomerId.getText();
        String title= txtTitle.getText();
        String name = txtName.getText();
        String dob = txtDob.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String postalCode = txtPostalCode.getText();

        customerInfoDtos.add(new CustomerInfoDto(id,title,name,dob,salary,address,city,province,postalCode));
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        CustomerInfoDto selectCustomer = tblCustomerInfo.getSelectionModel().getSelectedItem();
        customerInfoDtos.remove(selectCustomer);
    }

    @FXML
    void btnReloadaOnAction(ActionEvent event) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        tblCustomerInfo.setItems(customerInfoDtos);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
    CustomerInfoDto selectCustomer = tblCustomerInfo.getSelectionModel().getSelectedItem();
        selectCustomer.setId(txtCustomerId.getText());
        selectCustomer.setTitle(txtTitle.getText());
        selectCustomer.setName(txtName.getText());
        selectCustomer.setDob(txtDob.getText());
        selectCustomer.setSalary(Double.parseDouble(txtSalary.getText()));
        selectCustomer.setAddress(txtAddress.getText());
        selectCustomer.setCity(txtCity.getText());
        selectCustomer.setProvince(txtProvince.getText());
        selectCustomer.setPostalCode(txtPostalCode.getText());

        tblCustomerInfo.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
tblCustomerInfo.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
    if (newValue != null){
    txtCustomerId.setText(newValue.getId());
    txtTitle.setText(newValue.getTitle());
    txtName.setText(newValue.getName());
    txtDob.setText(newValue.getDob());
    txtSalary.setText(String.valueOf(newValue.getSalary()));
    txtAddress.setText(newValue.getAddress());
    txtCity.setText(newValue.getCity());
    txtProvince.setText(newValue.getProvince());
    txtPostalCode.setText(newValue.getPostalCode());

    }
}));

    }
}
