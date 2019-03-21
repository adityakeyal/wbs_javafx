package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller  implements Initializable{

    @FXML private TableView<Task> taskTable;





    public void processKeyPress(KeyEvent keyEvent) {


        if(keyEvent.getCode() == KeyCode.DOWN && keyEvent.isControlDown()){
            //add a new row
            //based on the selected row number
            addRow();
            keyEvent.consume();

        }
//        }

    }



    public void addNewRow(ActionEvent actionEvent) {

        addRow();

    }

    private void addRow() {
        int selectedIndex = this.taskTable.getSelectionModel().getSelectedIndex();
        selectedIndex = selectedIndex < 0 ? (this.taskTable.getItems().size()) : selectedIndex + 1;



        this.taskTable.getItems().add(selectedIndex,new Task());

        //handle the Sl. No.

        final AtomicInteger count = new AtomicInteger(1);
        this.taskTable.getItems().forEach( t -> t.setSlNo(String.valueOf((count.getAndIncrement()))));



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.taskTable.getSelectionModel().setCellSelectionEnabled(true);
    }
}
