package com.script972;

import com.script972.Model.Deposit;
import com.script972.Model.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.text.TabableView;
import java.awt.*;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

public class Controller  {

    private ObservableList<Deposit> desositList= FXCollections.observableArrayList();


    /*Table*/
    @FXML
    private TableView<Deposit> tableDeposit;
    @FXML
    private TableColumn<Deposit, Integer> columnAccoundId;
    @FXML
    private TableColumn<Deposit,String> columnName;
    @FXML
    private TableColumn<Deposit, String> columnCountry;
    @FXML
    private TableColumn<Deposit, Type> columnType;
    @FXML
    private TableColumn<Deposit, String> columnDepositor;
    @FXML
    private TableColumn<Deposit, BigInteger> columnAmountOnDeposit;
    @FXML
    private TableColumn<Deposit, Byte> columnProfitability;
    @FXML
    private TableColumn<Deposit, Integer> columnTimeConstraints;
    /*////////////TABLE////////////*/




    public void fieldTable(ArrayList<Deposit> list){
        list.add(new Deposit("Name", "Couuntry", Type.CALCULATED, "lbfd", 32, 32,  5, 5));
        desositList.addAll(list);
        columnAccoundId.setCellValueFactory(new PropertyValueFactory<Deposit, Integer>("account_id"));
        columnName.setCellValueFactory(new PropertyValueFactory<Deposit, String>("name"));
        columnCountry.setCellValueFactory(new PropertyValueFactory<Deposit, String>("country"));
        columnType.setCellValueFactory(new PropertyValueFactory<Deposit, Type>("type"));
        columnDepositor.setCellValueFactory(new PropertyValueFactory<Deposit, String>("deposit"));
        columnAmountOnDeposit.setCellValueFactory(new PropertyValueFactory<Deposit, BigInteger>("money"));
        columnProfitability.setCellValueFactory(new PropertyValueFactory<Deposit, Byte>("persent"));
        columnTimeConstraints.setCellValueFactory(new PropertyValueFactory<Deposit, Integer>("time_constraints"));
        tableDeposit.setItems(desositList);


    }


    public void searchByID(ActionEvent actionEvent) {
        fieldTable(new ArrayList<>());
    }
}
