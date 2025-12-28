package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    void btnCustomerOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customer_info.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
        stage.setTitle("Customer Information");

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employee_Info.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

        stage.setTitle("Employee Information");
    }


    @FXML
    void btnItemOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/item_info.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
        stage.setTitle("Item Information");
    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) {
    Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/supplier_info.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

        stage.setTitle("Supplier Information");
    }

}
