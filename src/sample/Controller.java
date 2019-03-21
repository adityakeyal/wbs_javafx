package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller  {

    @FXML private TableView<Task> taskTable;





//
//
    public void load(ActionEvent actionEvent) {

        this.taskTable.getItems().addAll(
                new Task("1","T1","ST1"),
                new Task("2","T2","ST2"),
                new Task("3","T3","ST3")


        );


    }

    public void save(TableColumn.CellEditEvent cellEditEvent) {
        System.out.println(cellEditEvent);
    }

    public void processKeyPress(KeyEvent keyEvent) {

        System.out.println(keyEvent.getSource());
        System.out.println(keyEvent.getText());
        System.out.println(keyEvent.getTarget());
        System.out.println(keyEvent.getCode());

        if(keyEvent.getCode() == KeyCode.TAB){
            keyEvent.consume();

        }




    }

    public void calStart(TableColumn.CellEditEvent cellEditEvent) {
        System.out.println("HUZZAHH");
    }
}
