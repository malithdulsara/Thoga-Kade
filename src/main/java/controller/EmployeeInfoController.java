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
import model.dto.EmployeeInfoDto;
import model.dto.SupplierInfoDto;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeInfoController implements Initializable {
    ObservableList<EmployeeInfoDto>employeeInfoDtos  = FXCollections.observableArrayList(
            new EmployeeInfoDto("E001", "Sunil Perera", "832451230V", "1983-07-12", "Manager", 75000.0, "0712456789", "No.15 Temple Road,Kalutara", "2018-05-10", "Active"),
            new EmployeeInfoDto("E002", "Kamal Perera", "145623587V", "1980-05-15", "Manager", 55000.0, "0778546321", "No.15 Temple Road,panadura", "2018-05-10", "Active")
    );

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContactNo;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colJoinedDate;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colPosition;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableView<EmployeeInfoDto> tblEmployeeInfo;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtEmployeeId;

    @FXML
    private TextField txtJoinedDate;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtStatus;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtEmployeeId.getText();
        String name = txtName.getText();
        String nic=txtNic.getText();
        String dob=txtDob.getText();
        String position=txtPosition.getText();
        double salary= Double.parseDouble(txtSalary.getText());
        String contactNo=txtContactNo.getText();
        String address=txtAddress.getText();
        String joinedDate=txtJoinedDate.getText();
        String status = txtStatus.getText();

        employeeInfoDtos.add(new EmployeeInfoDto(id,name,nic,dob,position,salary,contactNo,address,joinedDate,status));
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        EmployeeInfoDto selectEmployee =tblEmployeeInfo.getSelectionModel().getSelectedItem();
        employeeInfoDtos.remove(selectEmployee);
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        colId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joinDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblEmployeeInfo.setItems(employeeInfoDtos);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        EmployeeInfoDto selectEmployee = tblEmployeeInfo.getSelectionModel().getSelectedItem();
        selectEmployee.setEmployeeId(txtEmployeeId.getText());
        selectEmployee.setName(txtName.getText());
        selectEmployee.setNic(txtNic.getText());
        selectEmployee.setDob(txtDob.getText());
        selectEmployee.setPosition(txtPosition.getText());
        selectEmployee.setSalary(Double.parseDouble(txtSalary.getText()));
        selectEmployee.setContactNumber(txtContactNo.getText());
        selectEmployee.setAddress(txtAddress.getText());
        selectEmployee.setJoinDate(txtJoinedDate.getText());
        selectEmployee.setStatus(txtStatus.getText());

        tblEmployeeInfo.refresh();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblEmployeeInfo.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)  ->{
            if (newValue != null){
                txtEmployeeId.setText(newValue.getEmployeeId());
                txtName.setText(newValue.getName());
                txtNic.setText(newValue.getNic());
                txtDob.setText(newValue.getDob());
                txtPosition.setText(newValue.getPosition());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtContactNo.setText(newValue.getContactNumber());
                txtAddress.setText(newValue.getAddress());
                txtJoinedDate.setText(newValue.getJoinDate());
                txtStatus.setText(newValue.getStatus());
            }
        } );
    }
    }

